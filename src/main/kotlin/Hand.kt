class Hand(
    var cards: MutableList<Card>
) {
    fun getScore(): Int {
        val possibleScores = getAllPossibleScores()

        return getBestScore(possibleScores)
    }

    fun getAllPossibleScores(): List<Int> {
        return getPossibleScores(cards.size - 1)
    }

    private fun getPossibleScores(index: Int): List<Int> {
        if(index < 0) return listOf()
        if(index == 0) return cards[index].number.getPossibleValues()

        val subSetScores = getPossibleScores(index-1)

        val possibleScpres = mutableListOf<Int>()

        cards[index].number.getPossibleValues().forEach { faceValue ->
            subSetScores.forEach { score ->
                possibleScpres.add(faceValue + score)
            }
        }

        return possibleScpres
    }



    private fun getBestScore(possibleScores: List<Int>): Int {
        check(possibleScores.isNotEmpty()) {"Atleast one possible score has to be there for a hand"}

        val sortedScores = possibleScores.sorted().reversed()

        sortedScores.forEach {
            if(it <= 21) return it
        }

        return sortedScores[0]
    }

    fun addCard(card: Card) {
        cards.add(card)
    }

}