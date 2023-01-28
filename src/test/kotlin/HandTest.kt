import models.Card
import models.Hand
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class HandTest {

    private val equalStraightFlush1 = Hand(
        listOf(
            Card(HEARTS, SIX),
            Card(HEARTS, FIVE),
            Card(HEARTS, FOUR),
            Card(HEARTS, THREE),
            Card(HEARTS, TWO)
        )
    )

    private val equalStraightFlush2 = Hand(
        listOf(
            Card(CLUBS, SIX),
            Card(CLUBS, FIVE),
            Card(CLUBS, FOUR),
            Card(CLUBS, THREE),
            Card(CLUBS, TWO)
        )
    )

    private val highStraightFlush = Hand(
        listOf(
            Card(HEARTS, KING),
            Card(HEARTS, QUEEN),
            Card(HEARTS, JACK),
            Card(HEARTS, TEN),
            Card(HEARTS, NINE)
        )
    )

    private val lowStraightFlush = Hand(
        listOf(
            Card(HEARTS, SIX),
            Card(HEARTS, FIVE),
            Card(HEARTS, FOUR),
            Card(HEARTS, THREE),
            Card(HEARTS, TWO)
        )
    )

    private val highFourOfAKind = Hand(
        listOf(
            Card(HEARTS, TEN),
            Card(SPADES, TEN),
            Card(CLUBS, TEN),
            Card(DIAMONDS, TEN),
            Card(HEARTS, SEVEN)
        )
    )

    private val lowFourOfAKind = Hand(
        listOf(
            Card(HEARTS, FIVE),
            Card(SPADES, FIVE),
            Card(CLUBS, FIVE),
            Card(DIAMONDS, FIVE),
            Card(HEARTS, ACE)

        )
    )

    private val highFull = Hand(
        listOf(
            Card(HEARTS, TEN),
            Card(SPADES, TEN),
            Card(CLUBS, TEN),
            Card(DIAMONDS, SEVEN),
            Card(HEARTS, SEVEN)
        )
    )

    private val lowFull = Hand(
        listOf(
            Card(HEARTS, FIVE),
            Card(SPADES, FIVE),
            Card(CLUBS, FIVE),
            Card(HEARTS, QUEEN),
            Card(DIAMONDS, QUEEN)
        )
    )

    private val equalFlush1 = Hand(
        listOf(
            Card(HEARTS, TEN),
            Card(HEARTS, EIGHT),
            Card(HEARTS, SEVEN),
            Card(HEARTS, FIVE),
            Card(HEARTS, TWO)
        )
    )

    private val equalFlush2 = Hand(
        listOf(
            Card(DIAMONDS, TEN),
            Card(DIAMONDS, EIGHT),
            Card(DIAMONDS, SEVEN),
            Card(DIAMONDS, FIVE),
            Card(DIAMONDS, TWO)
        )
    )

    private val highFlush = Hand(
        listOf(
            Card(HEARTS, KING),
            Card(HEARTS, TEN),
            Card(HEARTS, SEVEN),
            Card(HEARTS, THREE),
            Card(HEARTS, TWO)
        )
    )

    private val lowFlush = Hand(
        listOf(
            Card(SPADES, JACK),
            Card(SPADES, EIGHT),
            Card(SPADES, SIX),
            Card(SPADES, FIVE),
            Card(SPADES, THREE)
        )
    )

    private val equalStraight1 = Hand(
        listOf(
            Card(HEARTS, KING),
            Card(CLUBS, QUEEN),
            Card(HEARTS, JACK),
            Card(DIAMONDS, TEN),
            Card(HEARTS, NINE)
        )
    )

    private val equalStraight2 = Hand(
        listOf(
            Card(SPADES, KING),
            Card(HEARTS, QUEEN),
            Card(DIAMONDS, JACK),
            Card(HEARTS, TEN),
            Card(SPADES, NINE)
        )
    )

    private val highStraight = Hand(
        listOf(
            Card(HEARTS, KING),
            Card(CLUBS, QUEEN),
            Card(HEARTS, JACK),
            Card(DIAMONDS, TEN),
            Card(HEARTS, NINE)
        )
    )

    private val lowStraight = Hand(
        listOf(
            Card(SPADES, JACK),
            Card(HEARTS, TEN),
            Card(DIAMONDS, NINE),
            Card(HEARTS, EIGHT),
            Card(CLUBS, SEVEN)
        )
    )

    private val highThreeOfAKind = Hand(
        listOf(
            Card(HEARTS, TEN),
            Card(SPADES, TEN),
            Card(CLUBS, TEN),
            Card(DIAMONDS, SIX),
            Card(HEARTS, SEVEN)
        )
    )

    private val lowThreeOfAKind = Hand(
        listOf(
            Card(HEARTS, FIVE),
            Card(SPADES, FIVE),
            Card(CLUBS, FIVE),
            Card(DIAMONDS, QUEEN),
            Card(HEARTS, TWO)
        )
    )

    private val equalTwoPairs1 = Hand(
        listOf(
            Card(DIAMONDS, ACE),
            Card(HEARTS, ACE),
            Card(DIAMONDS, SEVEN),
            Card(HEARTS, SEVEN),
            Card(HEARTS, TWO)
        )
    )

    private val equalTwoPairs2 = Hand(
        listOf(
            Card(SPADES, ACE),
            Card(CLUBS, ACE),
            Card(SPADES, SEVEN),
            Card(CLUBS, SEVEN),
            Card(CLUBS, TWO)
        )
    )

    private val highTwoPairs = Hand(
        listOf(
            Card(SPADES, ACE),
            Card(CLUBS, ACE),
            Card(DIAMONDS, SEVEN),
            Card(HEARTS, SEVEN),
            Card(HEARTS, TWO)
        )
    )

    private val lowTwoPairs = Hand(
        listOf(
            Card(SPADES, TEN),
            Card(CLUBS, TEN),
            Card(HEARTS, EIGHT),
            Card(DIAMONDS, EIGHT),
            Card(HEARTS, ACE)
        )
    )

    private val equalPair1 = Hand(
        listOf(
            Card(SPADES, TEN),
            Card(CLUBS, TEN),
            Card(DIAMONDS, QUEEN),
            Card(HEARTS, EIGHT),
            Card(HEARTS, FIVE)
        )
    )

    private val equalPair2 = Hand(
        listOf(
            Card(DIAMONDS, TEN),
            Card(HEARTS, TEN),
            Card(HEARTS, QUEEN),
            Card(CLUBS, EIGHT),
            Card(DIAMONDS, FIVE)
        )
    )

    private val highPair = Hand(
        listOf(
            Card(SPADES, TEN),
            Card(CLUBS, TEN),
            Card(DIAMONDS, SEVEN),
            Card(HEARTS, KING),
            Card(HEARTS, SIX)
        )
    )

    private val lowPair = Hand(
        listOf(
            Card(SPADES, FIVE),
            Card(CLUBS, FIVE),
            Card(HEARTS, ACE),
            Card(DIAMONDS, THREE),
            Card(HEARTS, TWO)
        )
    )

    private val equalHighCard1 = Hand(
        listOf(
            Card(HEARTS, ACE),
            Card(SPADES, JACK),
            Card(DIAMONDS, EIGHT),
            Card(HEARTS, SEVEN),
            Card(DIAMONDS, FIVE),
        )
    )

    private val equalHighCard2 = Hand(
        listOf(
            Card(SPADES, ACE),
            Card(HEARTS, JACK),
            Card(HEARTS, EIGHT),
            Card(CLUBS, SEVEN),
            Card(SPADES, FIVE),
        )
    )

    private val highHighCard = Hand(
        listOf(
            Card(HEARTS, ACE),
            Card(SPADES, JACK),
            Card(DIAMONDS, EIGHT),
            Card(HEARTS, SEVEN),
            Card(DIAMONDS, FIVE),
        )
    )

    private val lowHighCard = Hand(
        listOf(
            Card(SPADES, QUEEN),
            Card(DIAMONDS, NINE),
            Card(HEARTS, SIX),
            Card(DIAMONDS, FOUR),
            Card(HEARTS, THREE)
        )
    )

    @Test
    fun compareTo() {
        // Straight Flush
        assertEquals(equalStraightFlush1, equalStraightFlush2)
        assertTrue(highStraightFlush > lowStraightFlush)
        assertTrue(lowStraightFlush > highFourOfAKind)
        assertTrue(lowStraightFlush > highFull)
        assertTrue(lowStraightFlush > highFlush)
        assertTrue(lowStraightFlush > highStraight)
        assertTrue(lowStraightFlush > highThreeOfAKind)
        assertTrue(lowStraightFlush > highTwoPairs)
        assertTrue(lowStraightFlush > highPair)
        assertTrue(lowStraightFlush > highHighCard)

        // Four Of A Kind
        assertTrue(highFourOfAKind > lowFourOfAKind)
        assertTrue(lowFourOfAKind > highFull)
        assertTrue(lowFourOfAKind > highFlush)
        assertTrue(lowFourOfAKind > highStraight)
        assertTrue(lowFourOfAKind > highThreeOfAKind)
        assertTrue(lowFourOfAKind > highTwoPairs)
        assertTrue(lowFourOfAKind > highPair)
        assertTrue(lowFourOfAKind > highHighCard)

        // Full
        assertTrue(highFull > lowFull)
        assertTrue(lowFull > highFlush)
        assertTrue(lowFull > highStraight)
        assertTrue(lowFull > highThreeOfAKind)
        assertTrue(lowFull > highTwoPairs)
        assertTrue(lowFull > highPair)
        assertTrue(lowFull > highHighCard)

        // Flush
        assertEquals(equalFlush1, equalFlush2)
        assertTrue(highFlush > lowFlush)
        assertTrue(lowFlush > highStraight)
        assertTrue(lowFlush > highThreeOfAKind)
        assertTrue(lowFlush > highTwoPairs)
        assertTrue(lowFlush > highPair)
        assertTrue(lowFlush > highHighCard)

        // Straight
        assertEquals(equalStraight1, equalStraight2)
        assertTrue(highStraight > lowStraight)
        assertTrue(lowStraight > highThreeOfAKind)
        assertTrue(lowStraight > highTwoPairs)
        assertTrue(lowStraight > highPair)
        assertTrue(lowStraight > highHighCard)

        // Three Of A Kind
        assertTrue(highThreeOfAKind > lowThreeOfAKind)
        assertTrue(lowThreeOfAKind > highTwoPairs)
        assertTrue(lowThreeOfAKind > highPair)
        assertTrue(lowThreeOfAKind > highHighCard)

        // Two Pairs
        assertEquals(equalTwoPairs1, equalTwoPairs2)
        assertTrue(highTwoPairs > lowTwoPairs)
        assertTrue(lowTwoPairs > highPair)
        assertTrue(lowTwoPairs > highHighCard)

        // Pair
        assertEquals(equalPair1, equalPair2)
        assertTrue(highPair > lowPair)
        assertTrue(lowPair > highHighCard)

        // High Card
        assertEquals(equalHighCard1, equalHighCard2)
        assertTrue(highHighCard > lowHighCard)
    }
}