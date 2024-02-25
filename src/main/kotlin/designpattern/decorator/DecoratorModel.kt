package designpattern.decorator

interface ChristmasTree {
    fun decorate(): String
}

class PineChristmasTree : ChristmasTree {
    override fun decorate() = "Christmas tree"
}

/**
 * Decorator pattern
 * 기존의 객체에 새로운 기능을 추가 할 수 있다.
 * 기존의 객체를 변경 하지 않고 새로운 기능을 추가 할 수 있다.
 */
abstract class TreeDecorator(
    private val tree: ChristmasTree,
) : ChristmasTree {
    override fun decorate(): String {
        return tree.decorate()
    }
}

class BubbleLights(
    tree: ChristmasTree,
) : TreeDecorator(tree) {

    override fun decorate(): String {
        return super.decorate() + decorateWithBubbleLights()
    }

    private fun decorateWithBubbleLights(): String {
        return " with Bubble Lights"
    }
}

/**
 * kotlin 의 by (delegate)로 위임을 하여 기존의 객체에 새로운 기능을 추가 할 수 있다.
 */
class Garlands(
    private val tree: ChristmasTree,
) : ChristmasTree by tree {

    override fun decorate(): String {
        return tree.decorate() + decorateWithGarlands()
    }

    private fun decorateWithGarlands(): String {
        return " with Garlands"
    }
}