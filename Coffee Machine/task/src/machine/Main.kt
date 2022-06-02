package machine

fun main() {
    val coffeeMachine = CoffeeMachine()
}

class CoffeeMachine {

    private var coffeeBar: CoffeeBar = CoffeeBar()

    object MachineStatus {
        var currentAction: MachineActions = MachineActions.IDLE

        fun backToMenu() {
            currentAction = MachineActions.IDLE
        }

        fun update(newState: MachineActions) {
            currentAction = newState
        }
    }

    init {
        initService()
    }

    private fun welcome() {
        print("Write action (buy, fill, take, remaining, exit): ")
        MachineStatus.update(MachineActions.fromAction(readLine()!!))
    }

    private fun exit() {
        MachineStatus.update(MachineActions.EXIT)
    }

    private fun initService() {
        while (MachineStatus.currentAction != MachineActions.EXIT) {
            when (MachineStatus.currentAction) {
                MachineActions.IDLE -> welcome()
                MachineActions.BUY -> coffeeBar.selectCoffee()
                MachineActions.FILL -> Store.fill()
                MachineActions.TAKE -> Cash.take()
                MachineActions.REMAINING -> Store.remaining()
                MachineActions.EXIT -> exit()
            }
        }
    }

    object Store {
        var water = 400
        var milk = 540
        var coffeeBeans = 120
        var disposableCups = 9

        fun discountStock(coffee: Coffee) {
            water -= coffee.water
            coffeeBeans -= coffee.coffeeBeans
            milk -= coffee.milk
            disposableCups--
        }

        fun fill() {
            fillWater()
            fillMilk()
            fillCoffeeBeans()
            fillCups()
            MachineStatus.backToMenu()
        }

        fun remaining() {
            val summary = """
            The coffee machine has:
            $water of water
            $milk of milk
            $coffeeBeans of coffee beans
            $disposableCups of disposable cups
            ${'$'}${Cash.money} of money
            """
            println(summary)
            MachineStatus.backToMenu()
        }

        private fun fillWater() {
            print("Write how many ml of water do you want to add: ")
            val water: Int = readLine()!!.toInt()
            this.water += water
        }

        private fun fillMilk() {
            print("Write how many ml of milk do you want to add: ")
            val milk: Int = readLine()!!.toInt()
            this.milk += milk
        }

        private fun fillCoffeeBeans() {
            print("Write how many grams of coffee beans  do you want to add: ")
            val coffeeBeans: Int = readLine()!!.toInt()
            this.coffeeBeans += coffeeBeans
        }

        private fun fillCups() {
            print("Write how many disposable cups do you want to add: ")
            val cups: Int = readLine()!!.toInt()
            this.disposableCups += cups
        }
    }

    object Cash {
        var money = 550

        fun collect(cash: Int) {
            money += cash
        }

        fun take() {
            println("I gave you $money")
            money = 0
            MachineStatus.backToMenu()
        }
    }

    private inner class CoffeeBar {

        fun selectCoffee() {
            print("what do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
            val action = Coffee.fromAction(readLine()!!)
            if (action != Coffee.NOTHING) {
                makeCoffee(action)
            } else {
                MachineStatus.backToMenu()
            }
        }

        private fun makeCoffee(coffee: Coffee) {
            when {
                Store.water < coffee.water -> {
                    println("Sorry, not enough water!")
                }
                Store.coffeeBeans < coffee.coffeeBeans -> {
                    println("Sorry, not enough coffee beans!")
                }
                Store.disposableCups < 1 -> {
                    println("Sorry, not enough disposable cups!")
                }
                else -> {
                    println("I have enough resources, making you a coffee!")
                    Store.discountStock(coffee)
                    Cash.collect(coffee.price)
                }
            }
            MachineStatus.backToMenu()
        }

    }
}

enum class MachineActions(val action: String) {
    IDLE("idle"),
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit"),
    NOTHING("");

    companion object {
        fun fromAction(action: String): MachineActions {
            for (state in values()) {
                if (state.action == action) return state
            }
            return NOTHING
        }
    }
}

enum class Coffee(val water: Int, val milk: Int, val coffeeBeans: Int, val price: Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6),
    NOTHING(0, 0, 0, 0);

    companion object {
        fun fromAction(action: String): Coffee {
            return when (action) {
                "1" -> ESPRESSO
                "2" -> LATTE
                "3" -> CAPPUCCINO
                "back" -> NOTHING
                else -> NOTHING
            }
        }
    }
}
