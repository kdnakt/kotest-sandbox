package kotest.sandbox

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldHaveLength

class BangExample : StringSpec({

    "!test 1" {
        // this will be ignored
        "hello" shouldHaveLength 6
    }

    "test 2" {
        // this will run
        "hello" shouldHaveLength 5
    }

    "test 3" {
        // this will run too
        "hello" shouldHaveLength 5
    }

    "!test 4" {
        // this will be ignored
        "hello" shouldHaveLength 7
    }
})