# Strategy Pattern 

```kotlin
internal data class Customer(
    val name: String,
    val membershipType: MembershipType,
)

internal data class Book(
    val title: String,
    val price: Double,
)

internal enum class MembershipType {
    REGULAR, PREMIUM,
}
```

두 가지 멤버십 유형이 있는 경우 간단한  if-else 문을 사용 하여 쉽게 할인을 계산할 수 있다.  
멤버십 유형이 많아 지면 이 방식을 유지 하기가 어렵다.  
멤버십 유형 별로 할인 계산 로직이 복잡 하면 if – else 문으로 유지 보수 하기 어렵다.  
```kotlin
internal class DiscountCalculatorV1 {
    fun calculateDiscount(book: Book, customer: Customer): Double {
        return if (customer.membershipType == MembershipType.REGULAR) {
            book.price * 0.1
        } else {
            book.price * 0.2
        }
    }
}
```

Strategy Pattern을 사용하여 할인 계산 로직을 분리하고 각 멤버십 유형 별로 할인 계산 로직을 캡슐화 한다.  
다양한 할인 전략을 정의 하는 DiscountStrategy 라는 interface 를 만든다.  
이제 할인 전략이 늘어 나도 DiscountStrategy 를 구현 하는 클래스 를 만들어 주기만 하면 된다.  
이렇게 하면 할인 전략이 추가 되어도 기존 코드를 수정 하지 않아도 된다.  
```kotlin

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
```

```kotlin
fun main() {
    val customer = Customer("Tom", MembershipType.REGULAR)
    val book = Book("Design Pattern", 100.0)
    val discountCalculator = DiscountCalculator.createDiscountCalculator(customer)
    println(discountCalculator.calculateDiscount(book))
}
```