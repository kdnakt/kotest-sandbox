package kotest.sandbox

import io.kotest.assertions.timing.continually
import io.kotest.assertions.until.fixed
import io.kotest.core.spec.style.ShouldSpec
import kotlin.time.Duration.Companion.seconds

class ContinuallyTest : ShouldSpec() {
    init {
        should("pass for 10 seconds") {
            continually(10.seconds,
                // executed every 1 second
                1.seconds.fixed()) {
                // code here that should succeed and continue to succeed for 60 seconds
                println("I'm alive!")
            }
        }
    }
}