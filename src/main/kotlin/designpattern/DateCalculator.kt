package designpattern

import designpattern.Date.*
import java.time.ZonedDateTime

fun main() {
    val original = ZonedDateTime.of(2021, 1, 1, 0, 0, 0, 0, ZonedDateTime.now().zone)

    val afterDay = original + DAY_10
    val expectDay = ZonedDateTime.of(2021, 1, 11, 0, 0, 0, 0, ZonedDateTime.now().zone)
    require(afterDay == expectDay) { "afterDay: $afterDay, expectDay: $expectDay" }

    val afterMonth = original + MONTH_3
    val expectMonth = ZonedDateTime.of(2021, 4, 1, 0, 0, 0, 0, ZonedDateTime.now().zone)
    require(afterMonth == expectMonth) { "afterMonth: $afterMonth, expectMonth: $expectMonth" }

    val afterYear = original + YEAR_1
    val expectYear = ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZonedDateTime.now().zone)
    require(afterYear == expectYear) { "afterYear: $afterYear, expectYear: $expectYear" }

    println("All tests passed")
}

enum class Date {
    DAY_10,
    MONTH_3,
    YEAR_1,
}

operator fun ZonedDateTime.plus(date: Date) =
    when {
        date.name.startsWith("DAY_") -> {
            val day = date.name.substringAfter("DAY_").toLong()
            this.plusDays(day)
        }

        date.name.startsWith("MONTH_") -> {
            val month = date.name.substringAfter("MONTH_").toLong()
            this.plusMonths(month)
        }

        date.name.startsWith("YEAR_") -> {
            val year = date.name.substringAfter("YEAR_").toLong()
            this.plusYears(year)
        }

        else -> this
    }!!