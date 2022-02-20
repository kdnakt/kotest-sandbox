package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.Enabled
import io.kotest.core.test.EnabledIf
import io.kotest.core.test.TestCase
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

val disableStartsWith: EnabledIf = { !it.name.testName.startsWith("startsWith") }
val disableDanger: (TestCase) -> Enabled = {
    if (it.name.testName.startsWith("danger"))
        Enabled.disabled("we don't like danger!")
    else
        Enabled.enabled
}

class EnabledFlags : StringSpec({
    "length should return size of string".config(
        enabled = false
    ) {
        "hello world".length shouldBe 10
    }
    "startsWith should test for a prefix".config(
        enabledIf = disableStartsWith
    ) {
        "sandbox" should startWith("hello")
    }
    "danger test".config(
        enabledOrReasonIf = disableDanger
    ) {
        "sandbox" should startWith("hello")
    }
})