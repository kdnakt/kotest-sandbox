package kotest.sandbox

import io.kotest.core.spec.style.FunSpec
import io.kotest.engine.spec.tempdir
import io.kotest.engine.spec.tempfile
import io.kotest.matchers.shouldBe

class TemporaryFileExample : FunSpec({

    val file = tempfile()
    val dir = tempdir()

    test("a temporary file dependent test") {
        file.writeText("this is a test")
        with(file.bufferedReader()) {
            val text = readText()
            println("text is: $text")
            text shouldBe "this is a test"
        }
    }

    test("a temporary dir dependent test") {
        dir.isDirectory shouldBe true
    }
})