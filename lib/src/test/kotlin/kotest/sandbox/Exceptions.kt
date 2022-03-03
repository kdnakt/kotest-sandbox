package kotest.sandbox

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldHaveLength
import io.kotest.matchers.string.shouldStartWith
import io.kotest.matchers.types.shouldBeInstanceOf

fun foo(name: String): String {
    if (name == "illegal") {
        throw IllegalAccessException("Something went wrong")
    }
    return "bar"
}

class Exceptions : FunSpec({
    test("should throw IllegalArgumentException") {
        val exception = shouldThrow<IllegalAccessException> {
            // code in here that you expect to throw an IllegalAccessException
            foo("illegal")
        }
        exception.shouldBeInstanceOf<IllegalAccessException>()
        exception.message.shouldStartWith("Something went wrong")
    }

    test("should return bar") {
        foo("hoge").shouldBe("bar")
    }
})