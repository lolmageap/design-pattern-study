# design-pattern-study

## 1. 디자인 패턴 이란?

디자인 패턴은 software 설계 에서 자주 발생 하는 문제를 해결 하기 위한 방법을 정리한 것이다.
디자인 패턴은 공통된 설계 문제를 해결 하기 위한 template 으로, 이를 이용 하여 software 설계를 빠르게 할 수 있다.

출처: https://www.baeldung.com/kotlin/category/patterns

## 2. 디자인 패턴의 종류

### 생성 패턴

- `Singleton` : 객체를 하나만 생성 하기 위한 패턴
- `Factory Method` : 객체를 한 곳에서 생성 하기 위한 패턴
- `Abstract Factory` : 관련 객체를 생성 하기 위한 패턴

### 구조 패턴

- `Adapter` : 객체를 변환 하기 위한 패턴
- `Bridge` : 객체를 분리 하기 위한 패턴
- `Composite` : 객체를 계층 구조로 구성 하기 위한 패턴
- `Decorator` : 객체에 기능을 추가 하기 위한 패턴
- `Facade` : 객체를 감싸기 위한 패턴
- `Flyweight` : 객체를 공유 하기 위한 패턴
- `Proxy` : 객체를 대신 하기 위한 패턴

### 행위 패턴

- `Chain of Responsibility` : 객체를 연결 하기 위한 패턴
- `Command` : 객체를 명령 하기 위한 패턴
- `Interpreter` : 객체를 해석 하기 위한 패턴
- `Iterator` : 객체를 반복 하기 위한 패턴
- `Mediator` : 객체를 중재 하기 위한 패턴
- `Memento` : 객체를 저장 하기 위한 패턴
- `Observer` : 객체를 감시 하기 위한 패턴
- `State` : 객체를 상태 로 구분 하기 위한 패턴
- `Strategy` : 객체를 전략 으로 구분 하기 위한 패턴
- `Template Method` : 객체를 템플릿 으로 구분 하기 위한 패턴
- `Visitor` : 객체를 방문 하기 위한 패턴

## 3. 디자인 패턴의 장단점

### 장점

### 단점

# jvm-memory-study

## 1. memory 란?

컴퓨터 에서 데이터 를 저장 하는 장치 이다.
memory 는 데이터 를 저장 하는 장치 로서, 데이터 를 저장 하고 읽어 오는 기능을 수행 한다.
memory 는 disc 보다 데이터 를 빠르게 읽고 쓸 수 있으며, 데이터 를 저장 하는 용량 이 작다.

## 2. memory 의 종류

- `RAM`
- `ROM`
- `Cache`
- `Virtual Memory`
- `Flash Memory`
- `Disc`
- `Tape`
- `Register`
- `Stack`
- `Heap`
- `Method Area`
- `PC Register`
- `Native Method Stack`
- `Execution Engine`
- `Code Cache`
- `Metaspace`
- `Compressed Class Space`
- `Direct Memory`
- `Old Generation`
- `Young Generation`
- `Eden Space`
- `Survivor Space`
- `Tenured Generation`
- `Permanent Generation`

## 3. jvm memory 의 구조

## 4. 메모리 의 동작 원리

 - `메모리 할당`
 - `메모리 해제`
 - `메모리 읽기`
 - `메모리 쓰기`
 - `메모리 초기화`
 - `메모리 복사`
 - `메모리 이동`
 - `메모리 검색`
 - `메모리 정렬`
 - `메모리 보호`
 - `메모리 공유`
 - `메모리 분할`
 - `메모리 통합`
 - `메모리 압축`
 - `메모리 확장`
 - `메모리 축소`
 - `메모리 병렬 처리`
 - `메모리 동기화`
 - `메모리 비동기화`
 - `메모리 캐시`
 - `메모리 버퍼`

## 5. 메모리 의 튜닝 방법

## 6. 메모리 의 문제점

 - `메모리 누수`
 - `메모리 부족`
 - `메모리 오버플로우`
 - `메모리 언더플로우`
 - `반영구적`

## 7. 메모리 누수

### 메모리 누수 방지 방법

## 8. JVM 메모리 관리 방법

### G1GC

### CMS

### Parallel GC

### ZGC

### Shenandoah

## 9. JVM 메모리 영역

### Method Area

### Heap

### Stack

### PC Register

### Native Method Stack

### Execution Engine

## 10. JVM 메모리 튜닝 방법

### JVM 옵션

### GC 튜닝

### 메모리 튜닝

### GC 로그 분석