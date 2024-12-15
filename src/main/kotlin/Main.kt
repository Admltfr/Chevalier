
class Total{
    var refbalance : Int = 0

    constructor(refbalance : Int) {
        this.refbalance = refbalance
    }
    fun withdraw(amount : Int ) {
        if (refbalance-amount >= 0) {
            refbalance -=  amount
            println("Balance after withdraw : $refbalance")
        } else {
            println("Insufficient Balance")
        }
    }
    fun deposit(amount : Int) {
        refbalance += amount
        println("Balance after deposit : $refbalance")
    }
}

fun main() {
    val balance = Total(10)
    var programExit : Boolean = false
    while (!programExit) {
        menu()
        val option: String = readln()
        optionValidator(arrayOf("0","1","2","3"),option)
        when (option) {
            "0" -> {
                programExit = true
            }

            "1"-> {
                println("Currently your balance is ${balance.refbalance}")
            }

            "2" -> {
                print("Enter Deposit Amount : ")
                val depositamount: Int = readln().toInt()
                balance.deposit(depositamount)
            }

            "3" -> {
                print("Enter Withdraw Amount : ")
                val withdrawamount: Int = readln().toInt()
                balance.withdraw(withdrawamount)
            }

            else -> {
                println("Invalid Option, please enter the right options")
            }
        }
        print("Continue? [Y/N] : ")
        if (!programExit) {
            val confirmExit : String = readln()
            optionValidator(arrayOf("Y","N"),confirmExit)
            if (confirmExit == "N") {
                programExit = true
            }
        }

    }
}

fun optionValidator(optionList : Array<String>, optionInput : String) {
    if (optionList.contains(optionInput)) {
        println("Processing request...")
    } else {
        while (!optionList.contains(optionInput)) {
            print("Invalid Option, please enter the right options : ")
            val optionInput = readln()
        }
    }
}


fun menu() {
    println("==========Menu==========")
    println("1. Check Balance        ")
    println("2. Deposit Balance      ")
    println("3. Withdraw Balance     ")
    println("0. Exit                 ")
    print("Enter Option : ")
}
