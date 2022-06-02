import kotlin.math.absoluteValue

fun main() {
    var distance = readLine()!!.toInt() // the distance back
    var totalDistance = readLine()!!.toInt()

    // fix the code below
    if (distance < 0) {
        val distance = -distance
    }
    totalDistance += distance.absoluteValue
    println(totalDistance)
}