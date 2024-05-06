## FAQ
Q. Application 마다 모두 같은 GC 옵션을 사용 했다.
A. 특정 application 은 메모리 사용량 이 많고, 특정 application 은 메모리 사용량 이 적을 수 있기 때문에 GC 옵션을 다르게 설정 하는 것이 좋다.
   예를 들어 A application 은 파일 관련된 작업을 많이 하고, B application 은 DB CRUD 관련된 작업을 많이 한다면 A application 은 메모리 사용량 이 많을 수 있기 때문에 GC 옵션을 다르게 설정 하는 것이 좋다.

Q. Memory 크기는 어떻게 잡는게 좋은가?
A. Memory 크기가 크다면 GC 가 더 넓은 범위를 탐색 해야 하기 때문에 오히려 GC 시간이 오래 걸려서 성능은 떨어 질 수 있다.
   일반 적인 web service 는 2G ~ 4G 정도로 잡는 것이 좋다.

Q. Full GC 이후 Old 영역이 계속 부족 하다.
A. Heap Dump 를 떠서 어떤 객체가 많이 생성 되었 는지 확인을 해보고, 해당 객체 들을 어떻게 처리 할지 확인을 해야 한다.
   Heap Dump 는 운영 중인 application 에 영향을 미치기 때문에 다운된 상태 에서 떠야 한다.
   왜냐면 Heap Dump 는 Memory 의 SNAPSHOT 을 찍기 때문에 stop the world 가 오래 발생 하게 된다.
   그래서 Heap Dump 를 뜰 때 는 circuit breaker 같은 기능을 사용 하여 다른 application 으로 요청을 보내는 것이 좋다.