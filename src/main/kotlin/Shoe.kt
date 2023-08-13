class Shoe {
    var decks: MutableList<Deck> = mutableListOf()
    var numberOfDecks = 5

    init {
        var i = 0
        while(i < numberOfDecks){
            decks.add(Deck())
            i++
        }
    }

    fun pickRandomCard(): Card {
        val randomDeck = (Math.random()*10000).toInt()%numberOfDecks
        val randomCard = (Math.random()*10000).toInt()%decks[0].cards.size

        return decks[randomDeck].cards[randomCard]
    }
}