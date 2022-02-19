package kotest.sandbox

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength

class DisableTestWithX : FunSpec({
    context("this outer block is enabled") {
        xtest("this test is disabled") {
            // this test is disabled
            "hello" shouldHaveLength 4
        }
    }
    xcontext("this block is disabled") {
        test("disabled by inheritance from the parent") {
            // this test is disabled
            "hello" shouldHaveLength 4
        }
    }
})