package designpattern.delegation

fun main() {
    val producer = EnhancedProducer(ProducerImpl())
    val synchronizedProducer = SynchronizedProducer(producer)

    require(producer.produce() == "ProducerImpl and EnhancedProducer")
    require(synchronizedProducer.produce() == "ProducerImpl and EnhancedProducer")
}