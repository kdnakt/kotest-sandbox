package kotest.sandbox

import io.kotest.core.spec.style.FunSpec
import io.mockk.*

data class MyDataClass(val value: String)

interface MyRepository {
    fun save(data: MyDataClass)
}

class MyService(val repository: MyRepository) {
    fun save(data: MyDataClass) {
        println(data)
        repository.save(data)
    }
}

class MockkExample : FunSpec({

    val repository = mockk<MyRepository>()
    val target = MyService(repository)

    test("Saves to repository") {
        every { repository.save(any()) } just Runs
        target.save(MyDataClass("a"))
        verify(exactly = 1) { repository.save(MyDataClass("a")) }
    }

})