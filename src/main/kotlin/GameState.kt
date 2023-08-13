interface GameState {
    val stateName: String

    fun performAction(player: BlackJackPlayer, dealer: Dealer, shoe: Shoe, blackJackGame: BlackJackGame)

    fun isCompletionConditionMet(player: BlackJackPlayer): Boolean {
        val currentScore = player.getScore()
        if(currentScore >= 21) {
            return true
        }

        return false
    }

    fun printGameView(player: BlackJackPlayer, dealer: Dealer) {
        // 1. Show Player's cards
        println("Players cards: ")
        player.hand.cards.forEach { i ->
            println("card: ${i.suit} ${i.number}, possible values: ${i.number.getPossibleValues()}")
        }
        println("current best score: ${player.getScore()}\n")

        // 2. Show Dealer's cards
        println("Dealers cards: ")
        dealer.hand.cards.forEach { i ->
            println("card: ${i.suit} ${i.number}, possible values: ${i.number.getPossibleValues()}")
        }
        println("current best score: ${dealer.getScore()}\n")
    }
}