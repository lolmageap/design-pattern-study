## GC 구조

GC 는 Miner GC(Young GC) 과 Major GC(Full GC) 으로 나뉜다.

JVM 에서 Heap 영역은 Eden 영역, virtual 영역, Survivor 영역 1, 2 로 나뉜다.

객체가 생성이 되면 Eden 영역에 할당이 되고, Miner GC 가 발생 하면 Eden 영역에 있는 객체들 중 참조 되지 않는 객체 들은 삭제가 된다.
참조 되는 객체들 은 Survivor 영역 1 로 이동이 된다.
GC 가 발생할 때 간혹 객체의 크기가 매우 크다면 Survivor 영역 으로 이동 하지 않고 Old 영역 으로 이동 하는 경우도 있다. (극히 드뭄)

1. Survivor 영역 1 에 있는 객체들 은 Miner GC 가 발생할 때마다 Survivor 영역 2 로 이동 하면서 Age 가 1씩 증가가 된다.
2. Survivor 영역 2 에 있는 객체들 은 Miner GC 가 발생할 때마다 Survivor 영역 1 로 이동 하면서 Age 가 1씩 증가가 된다.

위 두 과정을 반복 한다.
그리고 Age 가 특정 값 이상이 되면 Old 영역 으로 이동이 된다. (일반적 으로 15 or 12 이상이 되면 Old 영역 으로 이동이 된다.)
Old 영역에 데이터 가 많이 쌓이게 된다면 Miner GC 가 발생 하지 않고 Major GC(Full GC) 가 발생이 된다.
Major GC(Full GC) 가 발생이 되면 Old 영역에 있는 객체들 중 참조 되지 않는 객체 들은 삭제가 된다.

이러한 과정을 통해 GC 가 발생이 되면서 Heap 영역에 있는 객체들 중 참조 되지 않는 객체 들은 삭제가 되어 메모리 누수를 방지 할 수 있다.