package kotest.sandbox

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class SameTestName: StringSpec({
    "test 1" {
        "test".length shouldBe 4
    }

    "test 1" {
        "test".length shouldBe 4
    }
})
