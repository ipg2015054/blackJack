class Player {
    var hand = Hand(mutableListOf())

    fun addCardToHand(card: Card) {
        hand.addCard(card)
    }

    fun getScore(): Int {
        return hand.getScore()
    }
}