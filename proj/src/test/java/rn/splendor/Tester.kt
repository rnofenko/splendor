package rn.splendor

import rn.splendor.card.*
import rn.splendor.entity.Game
import java.util.*
import kotlin.collections.ArrayList

object Tester {
    fun table(card: Card): Game {
        val deck = deck(Arrays.asList(card))
        return GameFactory().create(deck, ArrayList())
    }

    fun table(card0: Card, card1: Card): Game {
        val deck = deck(Arrays.asList(card0, card1))
        return GameFactory().create(deck, ArrayList())
    }

    fun table(cards: List<Card>): Game {
        val deck = deck(cards)
        return GameFactory().create(deck, ArrayList())
    }

    fun table(noble: Noble): Game {
        return GameFactory().create(deck(), Arrays.asList(noble))
    }

    private fun deck(cards: List<Card> = ArrayList()): Deck {
        return Deck(SequencedCardMagazine(), fakeMagList(Gc.X0, cards), fakeMagList(Gc.X1), fakeMagList(Gc.X2))
    }

    private fun fakeMagList(defaultCard: Card, initial: List<Card> = ArrayList()): List<Card> {
        val res = ArrayList<Card>(initial)
        while (res.size < 15) {
            res.add(defaultCard)
        }
        return res
    }
}