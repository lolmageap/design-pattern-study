package designpattern.strategy

/**
 * 두 가지 멤버십 유형이 있는 경우 간단한  if-else 문을 사용 하여 쉽게 할인을 계산할 수 있다.
 * 멤버십 유형이 많아 지면 이 방식을 유지 하기가 어렵다.
 * 멤버십 유형 별로 할인 계산 로직이 복잡 하면 if – else 문으로 유지 보수 하기 어렵다.
 */
internal class DiscountCalculatorV1 {
    fun calculateDiscount(book: Book, customer: Customer): Double {
        return if (customer.membershipType == MembershipType.REGULAR) {
            book.price * 0.1
        } else {
            book.price * 0.2
        }
    }
}