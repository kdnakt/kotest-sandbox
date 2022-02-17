package kotest.sandbox

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.string.shouldHaveLength

class MyBehavior : BehaviorSpec({
    given("a broomstick") {
        `when`("I sit on it") {
            then("I should be able to fly") {
                // test code
                "hello".shouldHaveLength(5)
            }
        }
        `when`("I throw it away") {
            then("it should come back") {
                // test code
                "hello".shouldHaveLength(5)
            }
        }
    }
})