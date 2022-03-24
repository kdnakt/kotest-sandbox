package kotest.sandbox

import io.kotest.core.spec.Order
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCaseOrder
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

class SequentialSpec : StringSpec() {

    override fun testCaseOrder(): TestCaseOrder? = TestCaseOrder.Sequential

    init {
        "foo" {
            println("I run first as I'm defined first")
        }

        "bar" {
            println("I run second as I'm defined second")
        }
    }
}

class RandomSpec : StringSpec() {

    override fun testCaseOrder(): TestCaseOrder? = TestCaseOrder.Random

    init {
        "foo" {
            println("foo: This test may run first or second")
        }

        "bar" {
            println("bar: This test may run first or second")
        }
    }
}

class LexicographicSpec : StringSpec() {

    override fun testCaseOrder(): TestCaseOrder? = TestCaseOrder.Lexicographic

    init {
        "foo" {
            println("I run second as bar < foo")
        }

        "bar" {
            println("I run first as bar < foo")
        }
    }
}