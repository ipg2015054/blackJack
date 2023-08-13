class GameStartState: GameState {
    override val stateName = "Game Started"

    override fun performAction(player: BlackJackPlayer, dealer: Dealer, shoe: Shoe, blackJackGame: BlackJackGame) {
        println("Distributing cards...")
        var i = 0

        while(i<2) {
            player.addCardToHand(shoe.pickRandomCard())
            dealer.addCardToHand(shoe.pickRandomCard())
            i++
        }

        blackJackGame.gameState = PlayerTurnState()
    }
}