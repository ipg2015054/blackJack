fun main(args: Array<String>) {

    // 0. Initialize the game
    println("Initializing the game...\n")
    val blackJackGame = BlackJackGame()

    // 1. Distribute cards
    println("Distributing the cards...\n")
    blackJackGame.distributeCards()
    blackJackGame.printGameView()

    // 2. Players turn of events
    println("Player's turn")
    blackJackGame.performPlayersTurn()
    val playerScore = blackJackGame.blackJackPlayer.getScore()
    // blackJackGame.printGameView()

    if(playerScore > 21) {
        println("You are busted!!")
        return
    }

    if(playerScore == 21) {
        println("It's a blackJack, You won!!")
        return
    }

    // 3. Dealers turn of events
    println("Dealer's turn")
    blackJackGame.performDealersTurn()
    val dealerScore = blackJackGame.dealer.getScore()
    // blackJackGame.printGameView()

    if(dealerScore > 21) {
        println("Dealer is busted, You won!!")
        return
    }

    // 4. Game summary
    if(playerScore > dealerScore) {
        println("Congrats You have won!!")
    } else if(dealerScore > playerScore) {
        println("Dealer has won!!")
    } else {
        println("It's a tie")
    }
}