import java.util.*

class BlackJackGame {
    var dealer: Dealer
    var blackJackPlayer: BlackJackPlayer
    var shoe: Shoe

    init {
        dealer = Dealer()
        blackJackPlayer = BlackJackPlayer()
        shoe = Shoe()
    }

    fun distributeCards() {
        var i = 0

        while(i<2) {
            blackJackPlayer.addCardToHand(shoe.pickRandomCard())
            dealer.addCardToHand(shoe.pickRandomCard())
            i++
        }
    }

    fun performPlayersTurn() {
        while (true) {
            if(isCompletionConditionMet(blackJackPlayer)) return

            val reader = Scanner(System.`in`)
            println("Choose an option:")
            println("1. Hit")
            println("2. Stand")

            val option = reader.nextInt()

            if(option != 1) return


            blackJackPlayer.addCardToHand(shoe.pickRandomCard())
            printGameView()
        }
    }

    fun performDealersTurn() {
        while (true) {
            if(isCompletionConditionMet(dealer)) return

            dealer.addCardToHand(shoe.pickRandomCard())
            printGameView()
        }
    }

    fun isCompletionConditionMet(player: BlackJackPlayer): Boolean {
        val currentScore = player.getScore()
        if(currentScore >= 21) {
            return true
        }

        return false
    }

    fun printGameView() {
        // 1. Show Player's cards
        println("Players cards: ")
        blackJackPlayer.hand.cards.forEach { i ->
            println("card: ${i.suit} ${i.number}, possible values: ${i.number.getPossibleValues()}")
        }
        println("current best score: ${blackJackPlayer.getScore()}\n")

        // 2. Show Dealer's cards
        println("Dealers cards: ")
        dealer.hand.cards.forEach { i ->
            println("card: ${i.suit} ${i.number}, possible values: ${i.number.getPossibleValues()}")
        }
        println("current best score: ${dealer.getScore()}\n")
    }
}