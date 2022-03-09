package kotest.sandbox

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

fun isPythagTriple(a: Int, b: Int, c: Int): Boolean = a * a + b * b == c * c

data class PythagTriple(val a: Int, val b: Int, val c: Int)

data class PythagTripleWithTestName(val a: Int, val b: Int, val c: Int)
    : WithDataTestName {
    override fun dataTestName() = "wibble $a, $b, $c wobble"
}

class SimpleDataDrivenTest : FunSpec({
    context("Pythag triples tests: true") {
        // depends on kotest-framework-datatest
        withData(
            PythagTriple(3, 4, 5),
            PythagTriple(6, 8, 10),
            PythagTriple(8, 15, 17),
            PythagTriple(7, 24, 25)
        ) { (a, b, c) ->
            isPythagTriple(a, b, c) shouldBe true
        }
    }

    context("Pythag triples tests: false") {
        withData(
            PythagTripleWithTestName(3, 4, 6),
            PythagTripleWithTestName(7, 24, 24)
        ) { (a, b, c) ->
            isPythagTriple(a, b, c) shouldBe false
        }
    }

    context("Pythag triples tests with map name") {
        withData(
            mapOf(
                "3, 4, 5" to PythagTriple(3, 4, 5),
                "6, 8, 10" to PythagTriple(6, 8, 10),
                "8, 15, 17" to PythagTriple(8, 15, 17),
                "7, 24, 25" to PythagTriple(7, 24, 25)
            )
        ) { (a, b, c) ->
            a * a + b * b shouldBe c * c
        }
    }

    context("Pythag triples tests with NameFn") {
        withData<PythagTriple>(
            nameFn = { "${it.a}__${it.b}__${it.c}" },
            PythagTriple(3, 4, 5),
            PythagTriple(6, 8, 10),
            PythagTriple(8, 15, 17),
            PythagTriple(7, 24, 25)
        ) { (a, b, c) ->
            a * a + b * b shouldBe c * c
        }
    }
})