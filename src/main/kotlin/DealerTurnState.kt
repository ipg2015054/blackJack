import java.lang.Exception

class DealerTurnState: GameState {
    override val stateName = "Dealer Turn"

    override fun performAction(player: BlackJackPlayer, dealer: Dealer, shoe: Shoe, blackJackGame: BlackJackGame) {
        while (true) {
            if(dealer.getScore() >= 17) throw Exception()
            if(isCompletionConditionMet(dealer)) throw Exception()

            dealer.addCardToHand(shoe.pickRandomCard())
            printGameView(player, dealer)
        }
    }
}