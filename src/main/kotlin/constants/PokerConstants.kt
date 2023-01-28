const val HEARTS: String = "Hearts"
const val DIAMONDS: String = "Diamonds"
const val CLUBS: String = "Clubs"
const val SPADES: String = "Spades"

val SUITS: List<String> = listOf(HEARTS, DIAMONDS, CLUBS, SPADES)

val TWO: Pair<String, Int> = Pair("2", 2)
val THREE: Pair<String, Int> = Pair("3", 3)
val FOUR: Pair<String, Int> = Pair("4", 4)
val FIVE: Pair<String, Int> = Pair("5", 5)
val SIX: Pair<String, Int> = Pair("6", 6)
val SEVEN: Pair<String, Int> = Pair("7", 7)
val EIGHT: Pair<String, Int> = Pair("8", 8)
val NINE: Pair<String, Int> = Pair("9", 9)
val TEN: Pair<String, Int> = Pair("10", 10)
val JACK: Pair<String, Int> = Pair("Jack", 11)
val QUEEN: Pair<String, Int> = Pair("Queen", 12)
val KING: Pair<String, Int> = Pair("King", 13)
val ACE: Pair<String, Int> = Pair("Ace", 14)

val RANKS: List<Pair<String, Int>> = listOf(TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE)

val STRAIGHT_FLUSH: Pair<String, Int> = Pair("Straight Flush", 9)
val FOUR_OF_A_KIND: Pair<String, Int> = Pair("Four Of A Kind", 8)
val FULL: Pair<String, Int> = Pair("Full House", 7)
val FLUSH: Pair<String, Int> = Pair("Flush", 6)
val STRAIGHT: Pair<String, Int> = Pair("Straight", 5)
val THREE_OF_A_KIND: Pair<String, Int> = Pair("Three Of A Kind", 4)
val TWO_PAIRS: Pair<String, Int> = Pair("Two Pairs", 3)
val PAIR: Pair<String, Int> = Pair("Pair", 2)
val HIGH_CARD: Pair<String, Int> = Pair("High Card", 1)

val HANDS: List<Pair<String, Int>> = listOf(STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL, FLUSH, STRAIGHT, THREE_OF_A_KIND, TWO_PAIRS, PAIR, HIGH_CARD)