package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SameTestName: StringSpec({
    "test 1" {
        "test".length shouldBe 4
    }

    "test 1" {
        "test".length shouldBe 4
    }
})
