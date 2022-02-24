package kotest.sandbox

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class ProjectConfig: AbstractProjectConfig() {
    // This project wide config will be overwritten by each spec configuration
    override val isolationMode = IsolationMode.InstancePerLeaf
}

class IsolationModeWithDSL : WordSpec({
    isolationMode = IsolationMode.SingleInstance
    // tests here
    "Hello" When {
        "asked for length" should {
            "return 5" {
                "Hello".length shouldBe 5
            }
        }
        "appended to Bob" should {
            "return Hello Bob" {
                "Hello " + "Bob" shouldBe "Hello Bob"
            }
        }
    }
})


class IsolationModeWithOverrideFun : WordSpec() {
    override fun isolationMode() = IsolationMode.SingleInstance

    init {
        // tests here
        "Hello" When {
            "asked for length" should {
                "return 5" {
                    "Hello".length shouldBe 5
                }
            }
            "appended to Bob" should {
                "return Hello Bob" {
                    "Hello " + "Bob" shouldBe "Hello Bob"
                }
            }
        }
    }
}

class SingleInstanceExample : WordSpec({
    // default isolation mode is SingleInstance
    val id = UUID.randomUUID()
    "a" should {
        println(id)
        "b" {
            println(id)
        }
        "c" {
            println(id)
        }
    }
})

class InstancePerTestExample : WordSpec() {
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest
    val id = UUID.randomUUID()
    init {
        "a" should {
            println("Hello $id")
            "b" {
                println("From $id")
            }
            "c" {
                println("Sam $id")
            }
        }
    }
}

class InstancePerTestWithCounter : WordSpec() {

    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest

    val counter = AtomicInteger(0)

    init {
        "a" should {
            println("a=" + counter.getAndIncrement())
            "b" {
                println("b=" + counter.getAndIncrement())
            }
            "c" {
                println("c=" + counter.getAndIncrement())
            }
        }
    }
}

class InstancePerLeafExample : WordSpec() {
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerLeaf
    val id = UUID.randomUUID()
    init {
        "a" should {
            println("Hello $id")
            "b" {
                println("From $id")
            }
            "c" {
                println("Sam $id")
            }
        }
    }
}