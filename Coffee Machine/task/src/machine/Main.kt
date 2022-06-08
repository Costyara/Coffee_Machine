package machine

fun main() {
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        when(readln()){
            "buy" -> CoffeeMachine().buy()
            "fill" -> CoffeeMachine().fill()
            "take" -> CoffeeMachine().take()
            "remaining" -> CoffeeMachine().remaining()
            "exit" -> break
        }
    }
}
class CoffeeMachine() {
    companion object Resource {
        var water = 400
        var milk = 540
        var coffee = 120
        var cups = 9
        var money = 550
    }
    fun buy() {
        while (true) {
            print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
            when (val num = readln()) {
                "1", "2", "3" -> {
                    if (coffee < select(num).coffee) {
                        println("Sorry, not enough coffee beans!\n")
                        return
                    }  else if (water < select(num).water) {
                        println("Sorry, not enough water!\n")
                        return
                    } else if (milk < select(num).milk) {
                        println("Sorry, not enough milk!\n")
                        return
                    } else if (cups < 1) {
                        println("Sorry, not enough disposable cups\n")
                        return
                    } else {
                        println("I have enough resources, making you a coffee!\n")
                        coffee -= select(num).coffee
                        water -= select(num).water
                        milk -= select(num).milk
                        cups--
                        money += select(num).money
                        return
                    }
                }
                "back" -> return
            }
        }
    }
    fun fill() {
        println()
        print("Write how many ml of water do you want to add: ")
        water += readln().toInt()
        print("Write how many ml of milk do you want to add: ")
        milk += readln().toInt()
        print("Write how many grams of coffee beans do you want to add: ")
        coffee += readln().toInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        cups += readln().toInt()
        println()
    }
    fun take() {
        println("\nI gave you $money")
        money = 0
        println()
    }
    fun remaining(){
        println("\nThe coffee machine has:\n" +
                "$water ml of water\n" +
                "$milk ml of milk\n" +
                "$coffee g of coffee beans\n" +
                "$cups disposable cups\n" +
                "$$money of money\n")
    }

    private fun select(num: String): TypeOfCoffee {
        when(num) {
            "1" -> return TypeOfCoffee.ESPRESSO
            "2" -> return TypeOfCoffee.LATTE
            "3" -> return TypeOfCoffee.CAPPUCCINO
        }
        return TypeOfCoffee.NULL
    }
}
enum class TypeOfCoffee(val water: Int, val milk: Int, val coffee: Int, val money: Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6),
    NULL(0, 0, 0, 0)
}
