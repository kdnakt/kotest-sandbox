package kotest.sandbox

import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.framework.concurrency.until
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds


val channel = mutableListOf<String>()

class Broker {
    fun poll(): List<String> {
        return channel
    }
}

fun createBrokerClient() = Broker()

suspend fun sendMessage() = coroutineScope {
    delay(6000)
    channel += "foo"
    channel += "bar"
}

@OptIn(ExperimentalKotest::class)
class UntilTest : ShouldSpec() {

    private val broker = createBrokerClient()

    init {
        should("broker should receive a message") {
            sendMessage()
            until(5.seconds) {
                broker.poll().isNotEmpty()
            }
        }
    }
}