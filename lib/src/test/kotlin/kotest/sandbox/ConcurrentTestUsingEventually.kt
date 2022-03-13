package kotest.sandbox

import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.style.StringSpec
import io.kotest.framework.concurrency.eventually
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

data class User(val id: Int, val name: String)

suspend fun getById(id: Int): User = coroutineScope {
    delay(2000L)
    User(id, "bob")
}

@OptIn(ExperimentalKotest::class)
class ConcurrentTestUsingEventually : StringSpec({
    "user id 1 is Bob".config(coroutineDebugProbes = false) {
        eventually<String>({
            duration = 1000
            initialDelay = 500
            retries = 3
            suppressExceptionIf = { it is java.lang.RuntimeException }
            listener = { println("No.${it.times} returned ${it.result}") }
            // predicate = { it.result == "alice" } // fails after 2 times
        }) {
            println("before getById")
            val name = getById(1).name
            name shouldBe "bob"
            println("after getById")
            name
        }
    }
})