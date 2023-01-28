package models

import FLUSH
import FOUR_OF_A_KIND
import FULL
import HIGH_CARD
import PAIR
import STRAIGHT
import STRAIGHT_FLUSH
import THREE_OF_A_KIND
import TWO_PAIRS

class Hand(draw: List<Card>) : Comparable<Hand> {

    val cardsInHand: List<Card> = draw.sorted()
    private val rankRecurrenceMap: Map<Int, Int> = cardsInHand.groupingBy { it.rank.second }.eachCount()
    val score: Int = calculateScore()
    private val comparableRanks: List<Int> = findComparableRanks()

    private fun calculateScore(): Int {
        return when {
            hasStraightFlush() -> STRAIGHT_FLUSH.second
            hasFourOfAKind() -> FOUR_OF_A_KIND.second
            hasFull() -> FULL.second
            hasFlush() -> FLUSH.second
            hasStraight() -> STRAIGHT.second
            hasThreeOfAKind() -> THREE_OF_A_KIND.second
            hasTwoPairs() -> TWO_PAIRS.second
            hasPair() -> PAIR.second
            else -> HIGH_CARD.second
        }
    }

    private fun findComparableRanks(): List<Int> {
        return when (score) {
            STRAIGHT_FLUSH.second,
            STRAIGHT.second -> listOf(cardsInHand.last().rank.second)

            FOUR_OF_A_KIND.second -> listOf(rankRecurrenceMap.filterValues { it == 4 }.keys.first())

            FULL.second -> listOf(rankRecurrenceMap.filterValues { it == 3 }.keys.first())

            FLUSH.second,
            HIGH_CARD.second -> cardsInHand.groupingBy { it.rank.second }.eachCount().keys.sortedDescending()

            THREE_OF_A_KIND.second -> listOf(rankRecurrenceMap.filterValues { it == 3 }.keys.first())

            TWO_PAIRS.second -> {
                rankRecurrenceMap.filterValues { it == 2 }.keys.sortedDescending() +
                        listOf(rankRecurrenceMap.filterValues { it == 1 }.keys.first())
            }

            PAIR.second -> {
                listOf(rankRecurrenceMap.filterValues { it == 2 }.keys.first()) +
                        rankRecurrenceMap.filterValues { it == 1 }.keys.sortedDescending()
            }

            else -> {
                listOf(0)
            }
        }
    }

    private fun getWinnerOfEqualHands(thisComparableRanks: List<Int>, otherComparableRanks: List<Int>): Int {
        comparableRanks.indices.forEach { i ->
            when {
                thisComparableRanks[i] > otherComparableRanks[i] -> return 1
                thisComparableRanks[i] < otherComparableRanks[i] -> return -1
            }
        }
        return 0
    }

    private fun hasStraightFlush(): Boolean {
        return hasStraight() && hasFlush()
    }

    private fun hasFourOfAKind(): Boolean {
        return rankRecurrenceMap.filterValues { it == 4 }.size == 1
    }

    private fun hasFull(): Boolean {
        return hasThreeOfAKind() && hasPair()
    }

    private fun hasFlush(): Boolean {
        return cardsInHand.groupingBy { it.suit }.eachCount().size == 1
    }

    private fun hasStraight(): Boolean {
        return (1 until cardsInHand.size).none { cardsInHand[it].rank.second != cardsInHand[0].rank.second + it }
    }

    private fun hasThreeOfAKind(): Boolean {
        return rankRecurrenceMap.filterValues { it == 3 }.size == 1
    }

    private fun hasTwoPairs(): Boolean {
        return rankRecurrenceMap.filterValues { it == 2 }.size == 2
    }

    private fun hasPair(): Boolean {
        return rankRecurrenceMap.filterValues { it == 2 }.size == 1
    }

    override operator fun compareTo(other: Hand): Int {
        return when {
            this.score > other.score -> 1
            this.score < other.score -> -1
            else -> getWinnerOfEqualHands(this.comparableRanks, other.comparableRanks)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Hand) return false
        return compareTo(other) == 0
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}