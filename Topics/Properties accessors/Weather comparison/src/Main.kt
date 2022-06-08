class City(val name: String) {
    var degrees: Int = when(name) {
        "Dubai" -> 30
        "Moscow" -> 5
        "Hanoi" -> 20
        else -> 0
    }
    set(value) {
        field = if (value < -92) degrees
        else if (value > 57) degrees
        else value

    }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    //implement comparing here
    print(
        if (firstCity.degrees == secondCity.degrees || firstCity.degrees == thirdCity.degrees ||
            secondCity.degrees == thirdCity.degrees) "neither"
        else if (firstCity.degrees < secondCity.degrees && firstCity.degrees < thirdCity.degrees) firstCity.name
        else if (secondCity.degrees < firstCity.degrees && secondCity.degrees < thirdCity.degrees) secondCity.name
        else thirdCity.name
    )
}