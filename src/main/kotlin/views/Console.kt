package views

import HANDS
import models.Hand

fun displayWinner(hand1: Hand, hand2: Hand){
    display(hand1,hand2)

    when {
        hand1 > hand2 -> println("Hand 1 is the winner!")
        hand1 < hand2 -> println("Hand 2 is the winner!")
        else -> print("It's a draw!")
    }
}

private fun display(hand1: Hand, hand2: Hand){
    println()
    println("----- Hand 1 -----")
    display(hand1)
    println()
    println("----- Hand 2 -----")
    display(hand2)
}

private fun display(hand: Hand){
    print("--> ")
    println(HANDS.find { it.second == hand.score }?.first)
    println()
    for (card in hand.cardsInHand.sortedDescending())
        println(card.rank.first + " of " + card.suit)
    println()
}