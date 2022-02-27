package kotest.sandbox

import io.kotest.core.listeners.AfterTestListener
import io.kotest.core.listeners.BeforeTestListener
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.string.shouldHaveLength

object TimerListener : BeforeTestListener, AfterTestListener {

    var started = 0L

    override suspend fun beforeTest(testCase: TestCase): Unit {
        started = System.currentTimeMillis()
    }

    override suspend fun afterTest(testCase: TestCase, result: TestResult): Unit {
        println("Duration of ${testCase.descriptor} = " + (System.currentTimeMillis() - started))
    }
}

class TimerListenerExample : FunSpec({
    extensions(TimerListener)
    // tests here

    test("sam should be a three letter name") {
        "sam".shouldHaveLength(3)
    }
})