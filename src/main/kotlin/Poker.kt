import models.Deck
import models.Hand
import views.displayWinner

fun main() {
    val deck = Deck()
    val hand1 = Hand(deck.cards.subList(0, 5).sorted())
    val hand2 = Hand(deck.cards.subList(5, 10).sorted())

    displayWinner(hand1,hand2)
}