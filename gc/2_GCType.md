## GC 종류

1. Serial GC
2. Parallel GC
3. G1 GC
4. Shenandoah GC
5. Z GC
6. concurrent mark-sweep GC

### Serial GC
- serial GC 는 오래전 단일 cpu 에서 사용이 되었던 GC로 single thread 로 동작을 하여 client 모드 에 적합 하다.
- single thread 로 동작 하여 thread 간 gc overhead 가 발생 하지 않는다. ( GC 가 발생할 때 application 이 멈추게 된다. )
- `-XX:+UseSerialGC` 옵션을 사용 하여 사용이 가능 하다.
- 단일 process 장비에 적합 하다.

### Parallel GC
- parallel GC 도 오래전 서버 에서 사용 하던 GC로 multi thread 로 동작을 한다.
- `-XX:+UseParallelGC` 옵션을 사용 하여 사용이 가능 하다.
- 위 옵션은 compaction 과정이 기본적 으로 발생 한다.
- `-XX:+UseParallelOldGC` 옵션을 사용 하여 compaction 과정이 발생 하지 않도록 설정이 가능 하다.
- compaction 작업 이란 메모리 에 분산 되어 있는 객체 들을 한 곳으로 모아 메모리 공간을 확보 하는 작업 이다.
- compaction 작업을 하지 않으면 메모리 공간을 하나로 모으지 않기 때문에 단순 성능적 으로는 좋다.
- 하지만 compaction 작업이 발생 하지 않으면 메모리 공간이 분산 되어 있기 때문에 공간을 확보 하지 못해 문제가 발생 할 수 있다.
    - ex) 500M 의 공간에 400M 의 객체가 있고 100M 의 공간이 남아 있다고 가정 했을 때, 100M 의 공간이 분산 되어 있으면 100M 의 객체를 할당 하지 못한다.
    - 그럴때 분산 되어 있는 객체를 모으지 않고 메모리 를 해제 하려고 하면 stop the world 가 긴 시간 동안 발생 하게 된다.

serial GC 와 parallel GC 는 survivor 영역간 이동을 할때 깊은 복사가 이뤄져 성능이 좋지 않기 때문에 이제는 거의 사용 하지 않는 GC 이다.

### G1 GC
- `-XX:+UseG1GC` 옵션을 사용 하여 사용이 가능 하다.
- G1 GC 는 메모리 를 바둑판 처럼 나누어 관리를 한다.
- 메모리 가 사용 되기 전에는 Eden 영역, 한번 사용이 되면 Survivor 영역 으로 변경이 되고, 더 이상 사용이 되지 않으면 Old 영역 으로 변경이 된다.
- G1 GC 는 compaction 작업을 하지 않기 때문에 메모리 공간이 분산 되어 있어도 성능적 으로 좋다.

### Shenandoah GC
- `-XX:+UseShenandoahGC` 옵션을 사용 하여 사용이 가능 하다.
- low pause time 을 목표로 하는 GC 이다.
- Shenandoah GC 는 실시간 으로 compaction 작업을 하기 때문에 stop the world 가 짧은 시간 동안 발생 하게 된다.
- cpu 의 사용량 이 높을 수 밖에 없다. (cpu 가 4개 이상 이여야 사용이 가능 하다.)
- openjdk 12 부터 사용이 가능 하다.

### Z GC
- `-XX:+UseZGC` 옵션을 사용 하여 사용이 가능 하다.
- 확장 가능한 빠른 GC 이다. (적용 가능한 Heap Memory Size : 8M ~ 16TB)
- 최대 대기 시간을 10ms 미만 으로 유지 하기 위해 노력 한다. (메모리 가 16T 여도 밀리 세컨드 단위를 목표로 한다.)

### concurrent mark-sweep GC
- `-XX:+UseConcMarkSweepGC` 옵션을 사용 하여 사용이 가능 하다.
- java 9 부터 deprecated 되었다. (java 9 부터 G1 GC 가 default 로 사용이 된다.)
- java 8 버전 까지는 G1 GC 가 없었기 때문에 사용이 되었던 GC 이다.