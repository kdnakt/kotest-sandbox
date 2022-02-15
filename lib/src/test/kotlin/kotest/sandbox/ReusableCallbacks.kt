package kotest.sandbox

import io.kotest.core.spec.BeforeTest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

val resetDatabase: BeforeTest = {
    // truncate all tables here
}

class ReusableCallbacks : FunSpec({

    beforeTest(resetDatabase)

    test("this test will have a sparkling clean database!") {
        // test logic here
    }
})