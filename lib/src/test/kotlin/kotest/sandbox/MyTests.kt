package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MyTests : StringSpec({
    "length should return size of string" {
        "hello world".length shouldBe 11
    }
})