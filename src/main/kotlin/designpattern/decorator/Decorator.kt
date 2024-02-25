package designpattern.decorator

fun main() {
    val christmasTreeV1 = BubbleLights(PineChristmasTree())
    val decoratedChristmasTreeV1 = christmasTreeV1.decorate()
    println(decoratedChristmasTreeV1)

    val christmasTreeV2 = Garlands(PineChristmasTree())
    val decoratedChristmasTreeV2 = christmasTreeV2.decorate()
    println(decoratedChristmasTreeV2)
}