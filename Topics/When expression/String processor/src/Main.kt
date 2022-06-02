fun main() {
    // write your code here

    val string1 = readLine() ?: ""
    val operation = readLine() ?: ""
    val string2 = readLine() ?: ""
    val result = when (operation) {
        "equals" -> (string1 == string2).toString()
        "plus" -> string1 + string2
        "endsWith" -> string1.endsWith(string2)
        else -> "Unknown operation"
    }
    println(result)
}