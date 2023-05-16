class Signup(line: String) {
    var name: String private set
    var taj: String private set
    var age: Int private set
    var date: SimpleDate private set


    init {
        val content = line.splitArray('-')
        this.name = content[0]
        this.taj = content[1]
        this.age = Integer.getInteger(content[2])
        this.date = SimpleDate(content[3], content[4], content[5])
    }

    fun compareTo(b: Signup): Int {
        return this.date.compareTo(b.date)
    }
}

private fun String.splitArray(c: Char): Array<String> {
    var i = 0
    return Array(this.count { ch -> ch == c }) { _ ->
        var tmp: String = this[i].toString()
        while (i++ < this.length && this[i] != '.') {
            tmp += this[i]
        }
        return@Array tmp
    }
}
