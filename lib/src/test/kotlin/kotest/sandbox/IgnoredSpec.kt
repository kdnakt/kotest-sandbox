package kotest.sandbox

import io.kotest.core.annotation.Ignored
import io.kotest.core.spec.style.FunSpec

@Ignored
class IgnoredSpec : FunSpec() {
    init {
        // spec will not be created so this error will not happen
        error("boom")
    }
}