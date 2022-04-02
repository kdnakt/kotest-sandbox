package kotest.sandbox

import io.kotest.core.spec.style.WordSpec
import io.kotest.core.spec.style.wordSpec
import io.kotest.matchers.shouldBe

interface IndexedSeq<T> {

    // returns the size of t
    fun size(): Int

    // returns a new seq with t added
    fun add(t: T): IndexedSeq<T>

    // returns true if this seq contains t
    fun contains(t: T): Boolean

    fun clear()
}

data class Vector<T>(val list: MutableList<T> = mutableListOf()): IndexedSeq<T> {
    override fun size() = list.size
    override fun add(t: T): IndexedSeq<T> {
        list.add(t)
        return this.copy()
    }
    override fun contains(t: T): Boolean {
        return list.contains(t)
    }
    override fun clear() = list.clear()
}

data class List<T>(val list: MutableList<T> = mutableListOf()): IndexedSeq<T> {
    override fun size() = list.size
    override fun add(t: T): IndexedSeq<T> {
        list.add(t)
        return this.copy()
    }
    override fun contains(t: T): Boolean {
        return list.contains(t)
    }
    override fun clear() = list.clear()
}

class IndexedSeqTestSuite : WordSpec({
    include(indexedSeqTests("vector", Vector()))
    include(indexedSeqTests("list", List()))
})

fun indexedSeqTests(name: String, empty: IndexedSeq<Int>) = wordSpec {
    name should {
        beforeAny { empty.clear() }
        "increase size as elements are added" {
            empty.size() shouldBe 0
            val plus1 = empty.add(1)
            plus1.size() shouldBe 1
            val plus2 = plus1.add(2)
            plus2.size() shouldBe 2
        }
        "contain an element after it is added" {
            empty.contains(1) shouldBe false
            empty.add(1).contains(1) shouldBe true
            empty.add(1).contains(2) shouldBe false
        }
    }
}
