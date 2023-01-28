package models

import SUITS
import RANKS

class Deck {

    val cards = mutableListOf<Card>()

    init {
        for (suit in SUITS)
            for (rank in RANKS)
                cards.add(Card(suit, rank))
        cards.shuffle()
    }

}