enum class Suit {
    SPADE,
    HEART,
    DIAMOND,
    CLUB
}

enum class Number {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    fun getPossibleValues(): List<Int> {
        return when(this) {
            TWO -> listOf(2)
            THREE -> listOf(3)
            FOUR -> listOf(4)
            FIVE -> listOf(5)
            SIX -> listOf(6)
            SEVEN -> listOf(7)
            EIGHT -> listOf(8)
            NINE -> listOf(9)
            TEN -> listOf(10)
            JACK -> listOf(10)
            QUEEN -> listOf(10)
            KING -> listOf(10)
            ACE -> listOf(1,11)
        }
    }
}