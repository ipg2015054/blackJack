import java.util.*

class PlayerTurnState: GameState {
    override val stateName = "Player Turn"

    override fun performAction(player: BlackJackPlayer, dealer: Dealer, shoe: Shoe, blackJackGame: BlackJackGame) {
        while (true) {
            if(isCompletionConditionMet(player)) throw Exception()

            val reader = Scanner(System.`in`)
            println("Choose an option:")
            println("1. Hit")
            println("2. Stand")

            val option = reader.nextInt()

            if(option != 1) {
                blackJackGame.gameState = DealerTurnState()
                return
            }


            player.addCardToHand(shoe.pickRandomCard())
            printGameView(player, dealer)
        }
    }
}