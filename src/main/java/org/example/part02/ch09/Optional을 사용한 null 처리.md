# Optional을 사용한 null 처리

---

## null 참조의 문제
- null 참조는 단순히 `값이 없는 상태`가 아니다.
- 실제 타입과 관계없이 `어떠한 객체 참조와도 호환되는 일반화된 타입`이다.
- 값이 할당되지 않을 경우 기본값으로 null을 갖게 되며, null 참조에 접근하면 NullPointException이 발생한다.
  - null을 처리하지 않으면 해당 스레드는 중단된다.

표면적으로 null 값을 처리할 수 있더라도, 올바른 결과를 보장하기 위해선 반드시 null 여부를 확인해야 한다.

어떠한 객체 참조와도 호환되기 때문에 구체적인 타입이 없어도 모든 타입을 대표할 수 있다. -> `타입 모호성`

타입을 강제하는 자바에서 타입 모호성...?

## null 처리 방법
Optional을 사용해 쉽게 null 처리가 가능하지만 코드 전체에서 null을 관리하기 위한 완벽한 해결책은 아니다.

### Optional 도입 전 null 처리

**변수를 null로 초기화하지 않도록 주의하기**
- 변수는 항상 null이 아닌 값을 가져야 한다.
```java
// 비권장
String value = null;

if(isTrue) {
    value = "is True";
} else {
    value = "is False";
}

// 권장
String value = isTrue ? "is True" : "is False";  
```
- 변수를 재할당하지 않는 경우 해당 변수는 effectively final 상태가 되기 때문에 람다 표현식에서 외부 변수로 활용할 수 있다.

**null을 전달하거나 수용, 반환하지 않아야 한다.**

```java
record User(long id, String firstName, String lastName) {

    // null 값 방지를 위한 기본 값 설정
    public User(long id) {
        this(id, "n/a", "n/a");
    }

    // null에 대한 인수 검증
    public User {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
    }
}
```

## 도구를 활용한 null 검사
- 하지만 이 어노테이션들은 기본적으로 자바에서 제공되는 스펙이 아니다.
- 직접 사용하기 위해서는 별도의 의존성이 필요하다.
  - com.google.code.findbugs:jsr305:x.x.x
- 어노테이션으로 간편한 null 검사를 제공하지만 도구에 과도하게 의존할 경우, 해당 도구 없이는 프로그램이 제대로 동작하지 않을 수 있다.

---

## Optional
- null이 될 수 있는 값을 담은 상자
- 상자는 그 내부의 값을 보호하는 래퍼의 역할을 한다.
- Optional은 래핑하는 것 이상으로, 값의 존재 여부에 따라 호출체인을 만들어낼 수 있으며 체인 내에 값이 없는 경우 대체 값을 만들어 반환할 수 있다.
- 스트림처럼 부가적인 래퍼는 오버헤드를 발생시킬 수 있지만 기존의 null 처리 작업 흐름을 더욱 간결하고 직관적으로 표현할 수 있다.

## Optional 파이프라인 구축

### Optional 생성
- Optional 타입에는 public 생성자는 제공하지 않는다.
- 대신 새로운 인스턴스를 생성하기 위한 정적 팩토리 메서드를 제공한다.

**Optional.ofNullable(T value)**
- 값이 null 일 가능성이 있는 경우 null값을 허용하는 새 인스턴스를 만든다.

**Optional.of(T value)**
- 반드시 값이 있어야 하는 경우 사용된다.
- 상황에따라 중요한 예외 상황을 간과했거나 외부 메서드의 반환 값이 변경되어 null을 반환하게 될 수도 있다.
  - of 메서드 사용 시 값이 null인지 확인하고 그렇지 않으면 NullPointException을 발생시킨다.
  - 예기치 않은 동작 변화에도 유연한 대응이 가능하다.

**Optional.empty()**
- 값이 비어 있다는 것을 이미 알고 있다면 empty 메서드를 사용할 수 있다.

Optional은 런타임에서 동작하는 특성을 가지며, 객체 생성과 관련된 오버헤드가 발생한다.

이 부분을 최소화하기 위해 값의 유무를 확인할 수 있는 메서드를 제공한다.
```java
// 단순히 값의 유무를 확인하는 메서드
boolean isPresent();
boolean isEmpty();

// 값이 존재할 때만 주어진 작업을 수행한다.
// null은 허용되지 않으며 NullPointException을 발생시킨다.
void ifPresent(...);
void ifPresentOrElse(...);
```
```java
String value = "null";
Optional<String> maybeValue = Optional.ofNullable(value);

if (maybeValue.isPresent()) {
    String result = maybeValue.orElseThrow();
    System.out.println(result); // null
} else {
    System.out.println("Not Found");
}
```

### 필터링 매핑
- filter : 값이 존재하고 주어진 조건에 부합하는 경우 this를 반환
- map : 제공된 매퍼함수로 값을 변환하여 새로운 null 값이 허용된 Optional 반환
- flatMap : Optional\<U>를 반환하는 매핑 함수를 사용할 때 적합하다. ex) map
  - 반환된 Optional\<U>에 map 연산을 사용하면 Optional<Optional\<U>>가 된다.
  - 불필요하게 중첩된 Optional 생성을 피할 수 있다.

### 대체 값 가져오기
- Optional은 null값을 안전하게 래핑하지만 실제값(대체값)이 필요할 수 있다.
```java
// 안전 검사 수행 x
T get();

// 값이 없는 경우 대체값 제공
T orElse();
T orElseGet(...);

// 값이 없는 경우 예외 발생
T orElseThrow(...);
```

## Optional 사용 주의 사항

### Optional은 일반적인 타입이다.
- Optional은 null 참조 문제를 피하려고 도입된 타입이지만, Optional 객체 자체가 null일 수 있는 경우에는 여전히 NullPointerException이 발생할 수 있다. 
- Optional을 생성하거나 사용할 때 null을 전달하는 경우에 발생할 수 있습니다.
```java
Optinoal<String> optionalString  = null;

try {
    // NullPointerException 발생
    optionalString.ifPresent(s -> System.out.println(s.length()));
} catch (NullPointerException e) {
    System.out.println("NullPointerException 발생: " + e.getMessage());
}
```
- Optional을 사용하고자 한다면 어떠한 경우에도 null을 반환해서는 안된다.

### 식별 관련 연산과는 어울리지 않는다.
- Optional, String, Integer 등. 값을 기반으로 하는 타입(value-based type)들은 참조 동일성보다는 값의 동등성에 초점을 맞춘다.
- 이런 타입들은 대체로 불변 객체로 설계되어 객체의 상태가 변하지 않음을 보장할 순 있지만 식별자를 다룰 때는 적합하지 않다.

### 성능 오버헤드
- 간단한 null 검사를 위해 추가적인 연산 없이 단순 Optional을 사용하는 것은 그다지 의미가 없다.
  - 단순 null 검사로 인해 새로운 Optional 인스턴스가 필요하며 각 메서드 호출마다 새로운 스택 프레임을 생성하기 때문
- 삼항 연산자나 직접적인 null 검사를 사용하는 것이 더 좋을 수 있다.
  - 인스턴스 생성과 메서드 호출 횟수를 줄이는 것이 바람직
- 성능 향상과 코드의 안정성, 명료성 사이에는 타협이 필요하다.

### 컬렉션에 대한 고려 사항
- 컬렉션 기반의 타입들은 이미 내부값의 부재를 표현할 수 있는 기능을 갖고 있다.
  - isEmpty() ...
- 컬렉션 또한 값들을 담는 상자의 역할을 하기 때문에 Optional로 래핑하게 된다면 처리해야 할 계층이 늘어난다.
- 빈컬렉션을 사용하면 NullPointException 가능성을 제거할 수 있다.
  - 빈컬렉션을 사용하도록 하면 Optional을 사용하는 것과 동일한 효과를 얻을 수 있다.
- 컬렉션에 대해 절대적으로 null을 사용하지 말아야 한다.
```java
// 비권장
List<String> isNull = null;
isNull.toString(); // NullPointException
```