
fun getFullNames() {
    val firstName1 = readLine()
    val lastName1 = readLine()
    println(createFullName(firstName1, lastName1))

    val firstName2 = readLine()
    val lastName2 = readLine()
    println(createFullName(firstName2, lastName2))

    val firstName3 = readLine()
    val lastName3 = readLine()
    println(createFullName(firstName3, lastName3))
}

fun createFullName(firstName: String?, lastName: String?) = "$firstName $lastName"