package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldHaveLength

class FocusExample : StringSpec({
    "test 1" {
        // this will be skipped
        "hello" shouldHaveLength 6
    }

    "f:test 2" {
        // this will be executed
        "hello" shouldHaveLength 5
    }

    "test 3" {
        // this will be skipped
        "hello" shouldHaveLength 7
    }

    "f:test 4" {
        // this will be executed
        "hello" shouldHaveLength 5
    }

})