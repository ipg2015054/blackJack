import java.util.*

class BlackJackGame {
    var dealer: Dealer = Dealer()
    var blackJackPlayer: BlackJackPlayer = BlackJackPlayer()
    var shoe: Shoe = Shoe()
    var gameState: GameState = GameStartState()

    fun playGame() {
        while(true) {
            val reader = Scanner(System.`in`)
            println("Current state: ${gameState.stateName}")
            println("Choose an option:")
            println("1. Continue")
            println("2. Restart")
            println("3. Quit")

            when(reader.nextInt()) {
                1 -> {
                    try {
                        gameState.performAction(blackJackPlayer, dealer, shoe, this)
                        gameState.printGameView(blackJackPlayer, dealer)
                    } catch (ex: Exception) {
                        handleTerminalCases()
                        restartGame()
                    }

                }
                2 -> restartGame()
                3 -> return
                else -> println("Choose a valid option")
            }
        }
    }

    private fun handleTerminalCases() {
        val playerScore = blackJackPlayer.getScore()

        if(playerScore > 21) {
            println("You are busted!!")
            return
        }

        if(playerScore == 21) {
            println("It's a blackJack, You won!!")
            return
        }

        val dealerScore = dealer.getScore()

        if(dealerScore > 21) {
            println("Dealer is busted, You won!!")
            return
        }

        if(playerScore > dealerScore) {
            println("Congrats You have won!!")
        } else if(dealerScore > playerScore) {
            println("Dealer has won!!")
        } else {
            println("It's a tie")
        }
    }

    private fun restartGame() {
        dealer = Dealer()
        blackJackPlayer = BlackJackPlayer()
        shoe = Shoe()
        gameState = GameStartState()
    }
}