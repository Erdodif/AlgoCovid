@Suppress("SpellCheckingInspection")
class Stack<T>(size: Int) {
    private var content: Array<T?>
    var count: Int private set

    init {
        @Suppress("UNCHECKED_CAST")
        content = arrayOfNulls<Any?>(size) as Array<T?>
        count = 0
    }

    fun push(item: T) {
        if (count == content.size) throw IndexOutOfBoundsException("A verem megtelt")
        content[count] = item
        count++

    }

    fun pop(): T {
        if (count == 0) throw IndexOutOfBoundsException("A verem üres")
        count--
        return content[count]!!
    }
}