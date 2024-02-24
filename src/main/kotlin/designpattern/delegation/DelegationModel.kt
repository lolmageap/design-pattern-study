package designpattern.delegation

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

interface Producer {
    fun produce(): String
}

class ProducerImpl: Producer {
    override fun produce() = "ProducerImpl"
}

/**
 * delegate pattern 은 ProducerImpl 의 결과를 재사용 하면서, 추가 적인 기능을 추가 할 수 있게 해준다.
 * producerImpl 에서 구현된 기능을 EnhancedProducer 와 SynchronizedProducer 에서 모두 재사용 할 수 있다.
 * EnhancedProducer 는 기존 기능에 추가 기능을 더하고, SynchronizedProducer 는 기존 기능을 동기화 한다.
 * kotlin 은 아래 처럼 by 키워드 를 사용 해서 delegate pattern 을 쉽게 구현 할 수 있다.
 */
class EnhancedProducer(
    private val producer: Producer,
) : Producer by producer {
    override fun produce() = "${producer.produce()} and EnhancedProducer"
}

class SynchronizedProducer(
    private val producer: Producer,
) : Producer by producer {

    private val lock = ReentrantLock()

    override fun produce(): String {
        lock.withLock {
            return producer.produce()
        }
    }
}