class SimpleDate(years: String, months: String, days: String) {
    val year: Int
        get() {
            return this.days / 10000
        }
    val month: Int
        get() {
            return this.days % 10000 / 100
        }
    val day: Int
        get() {
            return this.days % 100
        }
    private var days: Int

    init {
        this.days = Integer.getInteger(years) * 10000 + Integer.getInteger(months) * 100 + Integer.getInteger(days)
    }

    fun compareTo(b: SimpleDate): Int {
        return this.days - b.days
    }
}