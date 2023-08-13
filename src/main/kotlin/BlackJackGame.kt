import java.util.*

class BlackJackGame {
    var dealer: Dealer
    var player: Player
    var shoe: Shoe

    init {
        dealer = Dealer()
        player = Player()
        shoe = Shoe()
    }

    fun distributeCards() {
        var i = 0

        while(i<2) {
            player.addCardToHand(shoe.pickRandomCard())
            dealer.addCardToHand(shoe.pickRandomCard())
            i++
        }
    }

    fun performPlayersTurn() {
        while (true) {
            val currentScore = player.getScore()
            if(currentScore >= 21) {
                return
            }

            val reader = Scanner(System.`in`)
            println("Choose an option:")
            println("1. Hit")
            println("2. Stand")

            val option = reader.nextInt()

            if(option != 1) return


            player.addCardToHand(shoe.pickRandomCard())
            printGameView()
        }
    }

    fun performDealersTurn() {
        while (true) {
            val currentScore = dealer.getScore()
            if(currentScore >= 17) {
                return
            }

            dealer.addCardToHand(shoe.pickRandomCard())
            printGameView()
        }
    }

    fun printGameView() {
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