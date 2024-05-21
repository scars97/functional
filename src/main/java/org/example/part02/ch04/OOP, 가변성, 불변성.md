# OOP, 가변성, 불변성 

---

## 가변성
- OOP의 자바에서는 객체의 상태를 가변 형태로 캡슐화한다.
- 가변 상태를 다루는 JavaBean,POJO, Collection framework 가 있다.
  - 컴포넌트 간의 재사용성을 향상 시키기 위해 상태값을 캡슐화하도록 설계된 자바 객체

### POJO
- 특별한 제한이나 요구 사항 없이 단순한 자바 객체를 의미
- 비즈니스 로직 상태를 캡슐화하는 것이 목적이며, 불변성을 갖도록 설계할 수 있다.
- 가변 상태를 가진 객체 지향적인 컨텍스트에서 유연하게 작동하도록 필드에 getter와 setter를 제공한다.
```java
public class Person {
    private String name;
    private int age;

    // 기본 생성자
    public Person() {}

    // 매개변수가 있는 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter와 Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name;}
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

### JavaBean
- 특정 규약을 따르는 자바 객체
- 매개 변수가 없는 기본 생성자를 가져야 한다.
- 필드는 private으로 선언되고, 각 필드에 대해 public 접근 메서드를 제공해야한다.
- Serializable 인터페이스를 구현해야 한다.
```java
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter와 Setter
    // ...
}
```

### Collection Framework
- 대부분의 컬렉션 클래스는 가변적이며, 요소를 추가/삭제/수정할 수 있다.
- Collcetions.unmodifiableList 메서드를 사용하여 불변 컬렉션으로 만들 수 있다.
```java
public class CollectionExample {
    public static void main(String[] args) {
        List<String> mutableList = new ArrayList<>();
        mutableList.add("박");
        mutableList.add("성");

        List<String> immutableList = Collections.unmodifiableList(mutableList);

        // mutableList는 가변적
        mutableList.add("현");

        // immutableList는 불변적
        try {
            immutableList.add("짱");
        } catch (UnsupportedOperationException e) {
            e.getMessage();
        }
    }
}
```

### 가변 상태와 멘탈 모델
- 가변 상태는 복잡성과 불확실성을 유발한다.
- 그러므로 변경 가능한 모든 상태(가변 상태)를 `멘탈 모델`에 포함시켜야 한다.

> 멘탈 모델
- 개발자가 코드와 시스템을 이해하기 위해 머릿속에 그리는 개념적 모델
- 시스템 동작 방식, 객체와 데이터의 상호작용, 상태가 어떻게 변경되는 지에 대한 모든 정보


가변상태는 특히 동시성 프로그래밍에서 많은 복잡성과 문제를 일으킬 수 있다.
- 여러 스레드가 동시에 같은 가변 상태를 읽거나 쓰는 경우, 예상치 않은 결과가 발생할 수 있다.
- n 개의 스레드가 서로 상대방의 리소스를 기다리며 무한 대기에 빠지는 데드락 문제

가변 상태의 객체는 데이터의 신뢰성과 일관성이 떨어질 것이며,

여러 스레드가 동시에 접근할 시 예기치 못한 결과를 내줄 것이다.

또한, 코드의 정확성와 공유 상태를 보장하기 위해서 끊임없는 단위 테스트와 상태 검증 작업이 필요하다.

**함수형 프로그래밍은 `간결성, 일관성, 정확성, 안전한 동시성, 테스트 용이성`의 장점을 가진다.**

---

## 자바의 불변 타입

### String
```java
// 객체 생성
String str1 = new String("asdf");
String str2 = new String("asdf");

System.out.println("====인스턴스 생성====");
System.out.println(str1 == str2); // false
System.out.println(str1.equals(str2)); // true

// 리터럴
String literalStr1 = "asdf";
String literalStr2 = "asdf";

System.out.println("====리터럴====");
System.out.println(literalStr1 == literalStr2); // true
System.out.println(literalStr1.equals(literalStr2)); //true
```
- 문자열 연결을 위해 반복문 안에 String 인스턴스를 생성한다면 메모리 오버헤드가 발생하여 실제 런타임에 부담이 될 수 있다.
  - 문자열 연결이 필요하다면 StringBuilder, StringBuffer를 사용하는 것이 효율적이다.
- 리터럴로 생성한 경우 문자열 풀링 덕분에 동일한 리터럴은 한 번만 저장되어 재사용된다.
  - 메모리 공간 절약에 도움이 된다.

### 불변 컬렉션
- JCF는 불변성을 중심으로 설계되지는 않았지만, 어느정도의 불변성을 제공한다.
  - 변경 불가능한 컬렉션(unmodifiable collection)
  - 불변 컬렉션 팩토리 메서드
  - 불변 복제
- 이들은 `얕은 불변성`을 가지고 있어, 요소를 추가하거나 제거하는 것은 불가능하지만 요소 자체의 불변성은 보장하지 않는다.

**변경 불가능한 컬렉션**
- Collections 클래스의 일반 정적 메서드 중 하나를 호출하여 기존 컬렉션에서 생성한다.
- 원본 인스턴스와 반환된 인스턴스간의 차이점은 반환된 인스턴스 수정시 런타임 에러가 발생한다.
```java
List<String> list = new ArrayList<>();
list.add("1");
System.out.println(list.get(0)); // 1 출력

List<String> immutableList = Collections.unmodifiableList(list); // 변경 불가능한 컬렉션
        
// 런타임 오류
immutableList.add("1");
System.out.println(immutableList.get(0));
// Exception in thread "main" java.lang.UnsupportedOperationException
```
- immutableList는 원본 리스트의 '뷰'에 불과하므로 원본에 직접적인 변경이 이루어질 경우 변경 불가능한 특성을 우회하게 된다.
```java
List<String> list = new ArrayList<>();
list.add("1");
System.out.println(list.get(0)); // 1 출력

List<String> immutableList = Collections.unmodifiableList(list); // 변경 불가능한 컬렉션
list.add("2");
System.out.println(immutableList.size()); // 2 출력
```
- 변경 불가능한 뷰는 주로 반환값으로 사용될 컬렉션에 대해 원치 않는 변경을 막기 위해 사용된다.

**불변 컬렉션 팩토리 메서드**
- 원하는 요소들은 직접 해당 컬렉션 타입의 정적 편의 메서드를 통해 전달
```java
List<E> of(E e1, ...) { return ImmutableCollections..ListN<>(e1, ...)}
Set<E> of(E e1, ...) { return ImmutableCollections.Set12<>(e1, ...)}
```
```java
List<String> listOf = List.of("1", "2");

listOf.add("3");
System.out.println(list.size());
// UnsupportedOperationException 발생
```

**불변 복제**
- 단순히 뷰를 제공하는 것이 아니라, copyOf 메서드는 새로운 컨테이너를 생성하여 요소들의 참조를 `독립적으로 유지`한다.
```java
// 원본
List<String> original = new ArrayList<>();
original.add("blue");
original.add("red");

// 복사본
List<String> copy = List.copyOf(original);
original.add("green");

System.out.println(original);
System.out.println(copy);
```