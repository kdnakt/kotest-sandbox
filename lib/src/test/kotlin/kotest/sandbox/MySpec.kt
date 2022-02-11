package kotest.sandbox

import io.kotest.core.NamedTag
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class MySpec : StringSpec({
    "should use config".config(
        timeout = 2.seconds,
        invocations = 10,
        threads = 2,
        tags = setOf(NamedTag("Database"), NamedTag("Linux"))
    ) {
        "hello".length shouldBe 5
    }
})