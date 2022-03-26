package kotest.sandbox

import io.kotest.core.Tag
import io.kotest.core.spec.style.StringSpec

object Linux : Tag()
object Windows: Tag()

class TaggedTest : StringSpec() {
    init {
        "should run on Windows".config(tags = setOf(Windows)) {
            // ...
            println("Running on Windows")
        }

        "should run on Linux".config(tags = setOf(Linux)) {
            // ...
            println("Running on Linux")
        }

        "should run on Windows and Linux".config(tags = setOf(Windows, Linux)) {
            // ...
            println("Running on Windows and Linux")
        }
    }
}