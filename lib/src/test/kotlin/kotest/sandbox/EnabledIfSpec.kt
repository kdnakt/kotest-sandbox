package kotest.sandbox

import io.kotest.core.annotation.EnabledCondition
import io.kotest.core.annotation.EnabledIf
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength
import org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import kotlin.reflect.KClass

class LinuxOnlyCondition : EnabledCondition {
    override fun enabled(kclass: KClass<out Spec>): Boolean = when {
        kclass.simpleName?.contains("Linux") == true -> IS_OS_LINUX
        else -> true // non Linux tests always run
    }
}

@EnabledIf(LinuxOnlyCondition::class)
class MyLinuxTest1 : FunSpec({
    context("foo") {
        test("bar") {
            "hello" shouldHaveLength 4
        }
    }
})

@EnabledIf(LinuxOnlyCondition::class)
class MyLinuxTest2 : DescribeSpec() {
    // tests here
}

@EnabledIf(LinuxOnlyCondition::class)
class MyWindowsTests : DescribeSpec() {
    // tests here
}