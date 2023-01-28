package models

data class Card(val suit: String, val rank: Pair<String, Int>) : Comparable<Card> {

    override fun compareTo(other: Card) = compareValuesBy(this, other,
        { it.rank.second },
        { it.suit }
    )

}