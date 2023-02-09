package views

import HANDS
import models.Hand

fun displayWinner(hand1: Hand, hand2: Hand){
    display(listOf(hand1,hand2))

    when {
        hand1 > hand2 -> println("Hand 1 is the winner!")
        hand1 < hand2 -> println("Hand 2 is the winner!")
        else -> print("It's a draw!")
    }
}

private fun display(hands: List<Hand>){
    for (hand in hands)
        display(hand)
}

private fun display(hand: Hand){
    print("--> ")
    println()
    for (card in hand.cards.sortedDescending())
        println(card.rank.first + " of " + card.suit)
    println()
}