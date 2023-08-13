class Deck {
    var cards = mutableListOf<Card>()

    init {
        Suit.values().forEach { suit ->
            Number.values().forEach { number ->
                cards.add(Card(suit, number))
            }
        }
    }

}