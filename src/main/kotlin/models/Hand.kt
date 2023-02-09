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
import kotlin.math.pow

class Hand : Comparable<Hand> {

    val cards: List<Card>
    private val rankRecurrenceMap: Map<Int, Int>
    private val score: Int
    private val comparableRanks: Int

    constructor() {
        cards = emptyList()
        rankRecurrenceMap = cards.groupingBy { it.rank.second }.eachCount()
        score = calculateScore()
        comparableRanks = findComparableRanks()
    }

    constructor(vararg draw: Card) {
        cards = draw.sorted()
        rankRecurrenceMap = cards.groupingBy { it.rank.second }.eachCount()
        score = calculateScore()
        comparableRanks = findComparableRanks()
    }

    private fun calculateScore(): Int {
        return when {
            hasStraightFlush() -> STRAIGHT_FLUSH
            hasFourOfAKind() -> FOUR_OF_A_KIND
            hasFull() -> FULL
            hasFlush() -> FLUSH
            hasStraight() -> STRAIGHT
            hasThreeOfAKind() -> THREE_OF_A_KIND
            hasTwoPairs() -> TWO_PAIRS
            hasPair() -> PAIR
            else -> HIGH_CARD
        }.second
    }

    private fun findComparableRanks(): Int {
        return when (score) {
            STRAIGHT_FLUSH.second,
            STRAIGHT.second -> cards.last().rank.second
            FOUR_OF_A_KIND.second -> rankRecurrenceMap.filterValues { it == 4 }.keys.first()
            FULL.second -> rankRecurrenceMap.filterValues { it == 3 }.keys.first()
            FLUSH.second,
            HIGH_CARD.second -> comparableArrayToInt(*cards.groupingBy { it.rank.second }.eachCount().keys.sortedDescending().toIntArray())
            THREE_OF_A_KIND.second -> rankRecurrenceMap.filterValues { it == 3 }.keys.first()
            TWO_PAIRS.second -> comparableArrayToInt(*rankRecurrenceMap.filterValues { it == 2 }.keys.sortedDescending().toIntArray(), rankRecurrenceMap.filterValues { it == 1 }.keys.first())
            PAIR.second -> comparableArrayToInt(rankRecurrenceMap.filterValues { it == 2 }.keys.first(), *rankRecurrenceMap.filterValues { it == 1 }.keys.sortedDescending().toIntArray())
            else -> 0
        }
    }

    private fun comparableArrayToInt(vararg array: Int): Int {
        var comp = 0
        array.reversed().forEachIndexed { index, number ->
            comp += number * 15.0.pow(index).toInt()
        }
        return comp
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
        return cards.groupingBy { it.suit }.eachCount().size == 1
    }

    private fun hasStraight(): Boolean {
        return (1 until cards.size).none { cards[it].rank.second != cards[0].rank.second + it }
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

    override fun compareTo(other: Hand): Int {
        return compareValuesBy(this, other,
            { it.score },
            { it.comparableRanks }
        )
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Hand) return false
        return compareTo(other) == 0
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}