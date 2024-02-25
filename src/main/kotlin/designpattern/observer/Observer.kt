package designpattern.observer

fun main() {
    val newsletterV1 = NewsletterV1()
    newsletterV1.add( Reader(newsletterV1) )
    newsletterV1.add( Reader(newsletterV1) )
    newsletterV1.add( Reader(newsletterV1) )

    newsletterV1.newestArticleUrl = "https://example.com/article/1"

    val newsletterV2 = NewsletterV2()
    newsletterV2.newestArticleObservers.add { newestArticleUrl ->
        println("New article: $newestArticleUrl")
    }

}