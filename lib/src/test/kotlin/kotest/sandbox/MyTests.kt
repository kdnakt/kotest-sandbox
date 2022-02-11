package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class MyTests : StringSpec({
    "length should return size of string" {
        "hello world".length shouldBe 11
    }
    "startsWith should test for a prefix" {
        "sandbox" should startWith("sand")
    }
})