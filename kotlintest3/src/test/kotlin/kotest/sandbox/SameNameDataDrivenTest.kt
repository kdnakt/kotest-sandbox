package kotest.sandbox

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class SameNameDataDrivenTest: StringSpec({
    forall(
        row("hello"),
        row("hello")
    ) { s ->
        "$s" {
            s.length shouldBe 5
        }
    }
})