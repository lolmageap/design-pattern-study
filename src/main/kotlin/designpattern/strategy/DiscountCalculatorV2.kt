package designpattern.strategy

/**
 *  다양한 할인 전략을 정의 하는 DiscountStrategy 라는 interface 를 만든다.
 *  이제 할인 전략이 늘어 나도 DiscountStrategy 를 구현 하는 클래스 를 만들어 주기만 하면 된다.
 *  이렇게 하면 할인 전략이 추가 되어도 기존 코드를 수정 하지 않아도 된다.
 */
internal interface DiscountStrategy {
    fun calculateDiscount(book: Book): Double
}

internal object DiscountCalculator {
     fun createDiscountCalculator(
         customer: Customer,
     ) =
         when (customer.membershipType) {
            MembershipType.REGULAR -> RegularCustomerDiscountStrategy()
            MembershipType.PREMIUM -> PremiumCustomerDiscountStrategy()
        }.let {
             DiscountCalculatorV2(it)
         }
}


internal class RegularCustomerDiscountStrategy : DiscountStrategy {
    override fun calculateDiscount(book: Book): Double {
        return book.price * 0.1
    }
}

internal class PremiumCustomerDiscountStrategy : DiscountStrategy {
    override fun calculateDiscount(book: Book): Double {
        return book.price * 0.2
    }
}

internal class DiscountCalculatorV2(private val discountStrategy: DiscountStrategy) {
    fun calculateDiscount(book: Book): Double {
        return discountStrategy.calculateDiscount(book)
    }
}