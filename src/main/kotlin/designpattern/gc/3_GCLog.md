## GC 로그 확인 방법
1. `-XX:+PrintGCDetails` 옵션을 사용 하여 GC 로그를 확인 할 수 있다.
2. `-XX:+PrintGCTimeStamps` 옵션을 사용 하여 GC 발생 시간을 확인 할 수 있다.
3. `-Xloggc:파일경로` 옵션을 사용 하여 GC 로그를 파일로 저장 할 수 있다.
4. `-XX:+UseGCLogFileRotation` 옵션을 사용 하여 GC 로그를 파일로 저장 할 때 파일을 자동 으로 생성 할 수 있다.
5. `-XX:GCLogFileSize=파일크기` 옵션을 사용 하여 GC 로그를 파일로 저장 할 때 파일의 크기를 설정 할 수 있다.
6. `-XX:+PrintGCApplicationStoppedTime` 옵션을 사용 하여 GC 발생 시 application 의 정지 시간을 확인 할 수 있다.
7. `-XX:+PrintGCApplicationConcurrentTime` 옵션을 사용 하여 GC 발생 시 application 의 실행 시간을 확인 할 수 있다.
8. `-XX:+PrintReferenceGC` 옵션을 사용 하여 GC 발생 시 참조 객체의 정보를 확인 할 수 있다.
9. `-XX:+PrintHeapAtGC` 옵션을 사용 하여 GC 발생 시 Heap 영역의 정보를 확인 할 수 있다.
10. `-XX:+PrintTenuringDistribution` 옵션을 사용 하여 GC 발생 시 객체의 Age 를 확인 할 수 있다.
11. `-XX:+PrintAdaptiveSizePolicy` 옵션을 사용 하여 GC 발생 시 Heap 영역의 크기를 확인 할 수 있다.
12. `-XX:+PrintPromotionFailure` 옵션을 사용 하여 GC 발생 시 Promotion 실패 정보를 확인 할 수 있다.
13. `-XX:+PrintGCTaskTimeStamps` 옵션을 사용 하여 GC 발생 시 GC Task 의 시간을 확인 할 수 있다.