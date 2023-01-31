import models.Deck
import models.Hand
import views.displayWinner

fun main() {
    val deck = Deck()
    val hand1 = Hand(deck.cards.subList(0, 5))
    val hand2 = Hand(deck.cards.subList(5, 10))

    displayWinner(hand1,hand2)
}