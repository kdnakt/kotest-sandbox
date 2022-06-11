package kotest.sandbox

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.DuplicateTestNameMode
import io.kotest.matchers.shouldBe

// Not working as expected ...
object ProjectConfig : AbstractProjectConfig() {
    override val duplicateTestNameMode = DuplicateTestNameMode.Error
}

class SameTestName: StringSpec({
    "test 1" {
        "test".length shouldBe 4
    }

    "test 1" {
        "test".length shouldBe 4
    }
})
