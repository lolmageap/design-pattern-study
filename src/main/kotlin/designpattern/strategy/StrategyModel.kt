package designpattern.strategy

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