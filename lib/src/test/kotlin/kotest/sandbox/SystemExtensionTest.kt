package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.system.withEnvironment
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe

class SystemExtensionTest: StringSpec({
    "withEnvironment()" {
        withEnvironment("FooKey", "BarValue") {
            val value = System.getenv("FooKey")
            println(value)
            value shouldBe "BarValue" // System environment overridden!
        }
    }

    "withEnvironment(mapOf())" {
        withEnvironment(mapOf("FooKey" to "BarValue", "BarKey" to "FooValue")) {
            val val1 = System.getenv("FooKey")
            println(val1)
            val val2 = System.getenv("BarKey")
            println(val2)
            val1.length shouldBeExactly val2.length
        }
    }

})