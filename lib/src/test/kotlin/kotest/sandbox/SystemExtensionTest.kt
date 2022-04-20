package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.system.withEnvironment
import io.kotest.matchers.shouldBe

class SystemExtensionTest: StringSpec({
    "withEnvironment()" {
        withEnvironment("FooKey", "BarValue") {
            val value = System.getenv("FooKey")
            println(value)
            value shouldBe "BarValue" // System environment overridden!
        }
    }
})