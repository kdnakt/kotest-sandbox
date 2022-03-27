package kotest.sandbox

import io.kotest.core.spec.style.FunSpec
import io.kotest.engine.spec.tempfile
import io.kotest.matchers.shouldBe

class TemporaryFileExample : FunSpec({

    val file = tempfile()

    test("a temporary file dependent test") {
        file.writeText("this is a test")
        with(file.bufferedReader()) {
            val text = readText()
            println("text is: $text")
            text shouldBe "this is a test"
        }
    }
})