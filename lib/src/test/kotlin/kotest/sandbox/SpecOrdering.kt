package kotest.sandbox

import io.kotest.core.spec.Order
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength
import java.time.ZonedDateTime

@Order(1)
class FooTest: FunSpec({
    test("sam should be a three letter name") {
        "sam".shouldHaveLength(3)
        println("FooTest ${ZonedDateTime.now()}")
    }
})

@Order(1)
class BarTest: FunSpec({
    test("sam should be a three letter name") {
        "sam".shouldHaveLength(3)
        println("BarTest ${ZonedDateTime.now()}")
    }
})

@Order(0)
class FarTest: FunSpec({
    test("sam should be a three letter name") {
        "sam".shouldHaveLength(3)
        println("FarTest ${ZonedDateTime.now()}")
    }
})

class BooTest: FunSpec({
    test("sam should be a three letter name") {
        "sam".shouldHaveLength(3)
        println("BooTest ${ZonedDateTime.now()}")
    }
})

@Order(2)
class BazTest: FunSpec({
    test("sam should be a three letter name") {
        "sam".shouldHaveLength(3)
        println("BazTest ${ZonedDateTime.now()}")
    }
})