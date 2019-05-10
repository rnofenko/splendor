package rn.splendor

import rn.splendor.card.Deck
import rn.splendor.card.SequencedCardMagazine
import rn.splendor.card.Card
import rn.splendor.card.Gc
import rn.splendor.entity.Game

object Tester {
    fun table(vararg cards: Card): Game {
        val list = ArrayList<Card>()
        for(card in cards) {
            list.add(card)
        }
        val deck = deck(list)
        return GameFactory().create(deck)
    }

    private fun deck(cards: List<Card>): Deck {
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