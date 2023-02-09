import models.Deck
import models.Hand
import views.displayWinner

fun main() {
    val deck = Deck()
    val hand1 = Hand()
    val hand2 = Hand()

    displayWinner(hand1,hand2)
}