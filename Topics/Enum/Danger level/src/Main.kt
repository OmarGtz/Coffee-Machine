enum class DangerLevel(val mLevel: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);
    fun getLevel(): Int {
        return mLevel
    }

}
