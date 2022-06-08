
fun carPrice(old: Int = 5, kilometers:Int = 100000, maximumSpeed: Int = 120, automatic: Boolean = false, price: Int = 20000) {
    var newPrice = price - (old * 2000) - (kilometers / 10000 * 200) + ((maximumSpeed - 120) * 100)
    if (automatic) println(newPrice + 1500) else println(newPrice)
}