@Suppress("SpellCheckingInspection")
class PriorityQueue<T : Comparable<T>>(size: Int) {
    private var content: Array<T?>
    var count: Int private set

    init {
        @Suppress("UNCHECKED_CAST")
        content = arrayOfNulls<Any?>(size) as Array<T?>
        count = 0
    }

    fun getFirst() {
        if (count == 0) throw IndexOutOfBoundsException("A sor üres!")
        var first = content[0]!!
    }

    fun peekFirst(): T {
        if (count == 0) throw IndexOutOfBoundsException("A sor üres!")
        return content[0]!!
    }

    private fun leftInBounds(index: Int): Boolean {
        return index * 2 < count
    }

    private fun rightInBounds(index: Int): Boolean {
        return index * 2 + 1 < count
    }

    private fun swap(index1: Int, index2: Int) {
        val x = content[index1]
        content[index1] = content[index2]
        content[index2] = x
    }

    private fun prioDown() {
        swap(0, count - 1)
        var i = 0
        while (
            (leftInBounds(i) && content[i]!! < content[i * 2]!!)
            ||
            (rightInBounds(i) && content[i]!! < content[(i * 2) + 1]!!)
        ) {
            if (content[i * 2]!! > content[(i * 2) + 1]!!) {
                swap(i, i * 2)
                i *= 2
            } else {
                swap(i, (i * 2) + 1)
                i = (i * 2) + 1
            }
        }
    }

    private fun addLast(item: T) {
        if (content.size == count) {
            @Suppress("UNCHECKED_CAST")
            content = Array<Any?>(count * 2) { i -> if (i < content.size) content[i] else null } as Array<T?>
        }
        content[count] = item
        count++
        prioDown()
    }

    private fun RemoveFirst() {
        swap(0,count-1)
        count--
        prioDown()
    }
}