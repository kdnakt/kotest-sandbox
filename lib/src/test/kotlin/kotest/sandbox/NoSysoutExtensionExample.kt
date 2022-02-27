package kotest.sandbox

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.system.NoSystemOutListener

class NoSysoutExtensionExample : DescribeSpec({

    // will affect other extension that uses println()
    // listener(NoSystemOutListener)

    describe("All these tests should not write to standard out") {
        it("silence in the court") {
            println("boom") // failure
        }
    }
})