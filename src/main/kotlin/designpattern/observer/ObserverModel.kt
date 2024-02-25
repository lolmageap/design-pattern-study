package designpattern.observer

import kotlin.properties.Delegates

interface IObserver {
    fun update()
}

interface IObservable {
    val observers: ArrayList<IObserver>

    fun add(observer: IObserver) {
        observers.add(observer)
    }

    fun remove(observer: IObserver) {
        observers.remove(observer)
    }

    fun sendUpdateEvent() {
        observers.forEach { it.update() }
    }
}

/**
 * observable class
 * newestArticleUrl 의 값이 변경이 되면 sendUpdateEvent 를 호출 하여 observer 에게 알림
 */
class NewsletterV1 : IObservable {
    override val observers: ArrayList<IObserver> = ArrayList()
    var newestArticleUrl = ""
        set(value) {
            field = value
            sendUpdateEvent()
        }
}

class Reader(
    private var newsletter: NewsletterV1,
) : IObserver {
    override fun update() {
        println("New article: ${newsletter.newestArticleUrl}")
    }
}

/**
 * kotlin 의 Delegates 객체에 observable 를 사용해 observer pattern 을 구현 할 수 있다.
 * observable 의 값이 변경이 되면 observers 에 등록된 함수를 호출하여 알림을 준다.
 */
class NewsletterV2 {
    val newestArticleObservers = mutableListOf<(String) -> Unit>()

    var newestArticleUrl: String by Delegates.observable("") { _, _, newValue ->
        newestArticleObservers.forEach { it(newValue) }
    }
}