enum class User(val balance: Int) {
    Adam(10),
    Lutfi(20),
    Ramadhan(30)
}

class Total(user: User) {
    var balances = user.balance
    fun withdraw(amount : Int, lambda :(Int) -> Int ) {
        if (balances-amount >= 0) {
            balances =  lambda(amount)
            println("Balance after withdraw : $balances")
        } else {
            println("Insufficient Balance")
        }
    }
    fun deposit(amount : Int, lambda :(Int) -> Int) {
        balances = lambda(amount)
        println("Balance after deposit : $balances")
    }
}

//========Deprecated=========//
//class Total(var refBalance: Int) {
//
//    fun withdraw(amount : Int, lambda :(Int) -> Int ) {
//        if (refBalance-amount >= 0) {
//            refBalance =  lambda(amount)
//            println("Balance after withdraw : $refBalance")
//        } else {
//            println("Insufficient Balance")
//        }
//    }
//    fun deposit(amount : Int, lambda :(Int) -> Int) {
//        refBalance = lambda(amount)
//        println("Balance after deposit : $refBalance")
//    }
//}

fun main() {
do {
    print("Please enter your username : ")
    val balance = Total(userValidator())
    var changeUser = false
    var programExit = false
    do {
        menu()
        val option: String = optionValidator(arrayOf("0", "1", "2", "3"))
        when (option) {
            "0" -> {
                programExit = true
            }

            "1" -> {
                println("Currently your balance is ${balance.balances}")
            }

            "2" -> {
                print("Enter Deposit Amount : ")
                val depositAmount: Int = readln().toInt()
                balance.deposit(depositAmount) { amount -> balance.balances + amount }
            }

            "3" -> {
                print("Enter Withdraw Amount : ")
                val withdrawAmount: Int = readln().toInt()
                balance.withdraw(withdrawAmount) { amount -> balance.balances - amount }
            }

            else -> {
                println("Invalid Option, please enter the right options")
            }
        }
        print("Continue? [Y/N] : ")
        if (!programExit) {
            val confirmExit: String = optionValidator(arrayOf("Y", "N"))
            if (confirmExit == "N") {
                programExit = true
            }
        }
    } while (!programExit)
    print("Change User? [Y/N] : ")
    val confirmExit: String = optionValidator(arrayOf("Y", "N"))
    if (confirmExit == "N") {
        changeUser = true
    }

} while (!changeUser)
}

fun optionValidator(optionList : Array<String>) : String {
        var optionInput : String
        do {
            optionInput = readln()
            if (!optionList.contains(optionInput)) {
                print("Invalid Option, please enter the right options : ")
            } else {
                println("Processing your request......")
            }
        } while (!optionList.contains(optionInput))
        return optionInput
}

fun userValidator() : User {
    var userInput : String
    do {
        userInput = readln()
        if (!(User.entries.any { it.name == userInput })) {
            print("User not found, please enter the existing username : ")
        } else {
            println("Welcome ${userInput}")
        }
    } while (!(User.entries.any { it.name == userInput }))
    return User.valueOf(userInput)
}


fun menu() {
    println("==========Menu==========")
    println("1. Check Balance        ")
    println("2. Deposit Balance      ")
    println("3. Withdraw Balance     ")
    println("0. Exit                 ")
    print("Enter Option : ")
}
