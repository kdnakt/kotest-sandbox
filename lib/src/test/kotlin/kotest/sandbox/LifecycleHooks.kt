package kotest.sandbox

import io.kotest.assertions.fail
import io.kotest.core.spec.BeforeTest
import io.kotest.core.spec.style.WordSpec
import io.kotest.core.test.TestCase

class LifecycleHooks : WordSpec({
    beforeTest {
        println("Starting a test $it")
    }
    afterTest { (test, result) ->
        println("Finished spec with result $result")
    }
    "this test" should {
        "be alive" {
            println("Johnny5 is alive!")
        }
    }
})

val startTest: BeforeTest = {
    println("Starting a test $it")
}

class LifecycleHooksExample1: WordSpec({
    beforeTest(startTest)

    "this test" should {
        "fail" {
//            fail("boom")
        }
    }
})

class LifecycleHooksExample2: WordSpec() {
    override fun beforeTest(testCase: TestCase) {
        println("Starting a test $testCase")
    }

    init {
        "this test" should {
            "be alive" {
                println("Johnny5 is alive!")
            }
        }
    }
}