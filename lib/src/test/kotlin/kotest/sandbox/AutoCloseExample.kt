package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.StringReader

class AutoCloseExample : StringSpec() {

    val reader = autoClose(StringReader("xyz"))

    init {
        "your test case" {
            // use resource reader here
            reader.readText() shouldBe "xyz"
        }
    }
}