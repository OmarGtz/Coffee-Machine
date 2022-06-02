const val negativePopulations = 0
const val GREATER_THAN_50_000_000 = 50_000_000

class City(val name: String) {
    var population: Int = 0
        get() {
            return when {
                field < 0 -> negativePopulations
                field < GREATER_THAN_50_000_000 -> field
                else -> GREATER_THAN_50_000_000
            }
        }
}
