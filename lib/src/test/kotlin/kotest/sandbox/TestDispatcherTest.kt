package kotest.sandbox

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.testCoroutineScheduler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours

@OptIn(ExperimentalStdlibApi::class)
class TestDispatcherTest : FunSpec() {
    init {
        test("advance time").config(testCoroutineDispatcher = true) {
            val duration = 1.days
            // launch a coroutine that would normally sleep for 1 day
            launch {
                delay(duration.inWholeMilliseconds)
            }
            // move the clock on and the delay in the above coroutine will finish immediately.
            testCoroutineScheduler.advanceTimeBy(duration.inWholeMilliseconds)
            // virtual time in milliseconds
            val currentTime = testCoroutineScheduler.currentTime
            println("$currentTime") // 86400000
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
class TestDispatcherTest2 : FunSpec() {
    init {
        testCoroutineDispatcher = true
        test("this test uses a test dispatcher") {
            val duration = 1.hours
            // launch a coroutine that would normally sleep for 1 day
            launch {
                delay(duration.inWholeMilliseconds)
            }
            // move the clock on and the delay in the above coroutine will finish immediately.
            testCoroutineScheduler.advanceTimeBy(duration.inWholeMilliseconds)
            // virtual time in milliseconds
            val currentTime = testCoroutineScheduler.currentTime
            println("$currentTime") // 3600000
        }
        test("and so does this test!") {
        }
    }
}