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

## Optional
- null이 될 수 있는 값을 담은 상자
- 상자는 그 내부의 값을 보호하는 래퍼의 역할을 한다.
- Optional은 래핑하는 것 이상으로, 값의 존재 여부에 따라 호출체인을 만들어낼 수 있으며 체인 내에 값이 없는 경우 대체 값을 만들어 반환할 수 있다.
- 스트림처럼 부가적인 래퍼는 오버헤드를 발생시킬 수 있지만 기존의 null 처리 작업 흐름을 더욱 간결하고 직관적으로 표현할 수 있다.
