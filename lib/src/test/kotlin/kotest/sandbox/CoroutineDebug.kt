package kotest.sandbox

import io.kotest.core.spec.style.FunSpec
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineDebug : FunSpec() {
    init {
        test("foo").config(coroutineDebugProbes = true) {
            someMethodThatLaunchesACoroutine() // launches a new coroutine
        }
    }
}

suspend fun someMethodThatLaunchesACoroutine() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    println("Hello World")
}