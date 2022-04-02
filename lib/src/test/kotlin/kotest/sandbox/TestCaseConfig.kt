package kotest.sandbox

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import kotlin.time.Duration.Companion.seconds

class TestCaseConfig : ShouldSpec() {
    init {
        should("return the length of the string")
            .config(
                invocations = 10,
                threads = 2
            ) {
                println("testing ...")
                "sammy".length shouldBe 5
                "".length shouldBe 0

                println("tested!")
            }

        should("timeout")
            .config(timeout = 2.seconds) {
                Thread.sleep(2000)
            }
    }
}