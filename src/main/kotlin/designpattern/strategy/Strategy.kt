package designpattern.strategy

fun main() {
    val book = Book("Design Pattern", 100.0)
    val customer = Customer("John", MembershipType.REGULAR)

    val discountCalculatorV1 = DiscountCalculatorV1()
    val discountV1 = discountCalculatorV1.calculateDiscount(book, customer)
    println("DiscountV1: $discountV1")

    val discountCalculatorV2 = DiscountCalculator.createDiscountCalculator(customer)
    val discountV2 = discountCalculatorV2.calculateDiscount(book)
    println("DiscountV2: $discountV2")
}