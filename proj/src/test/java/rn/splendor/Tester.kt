package rn.splendor

import rn.splendor.card.DefinedCardMagazine
import rn.splendor.card.ICardMagazine
import rn.splendor.entity.Card
import rn.splendor.card.Gc
import rn.splendor.entity.Table

object Tester {
    fun table(vararg cards: Card): Table {
        val list = ArrayList<Card>()
        for(card in cards) {
            list.add(card)
        }
        val magazine = magazine(list)
        return TableFactory().create(magazine)
    }

    fun magazine(vararg cards: Card): ICardMagazine {
        val list = ArrayList<Card>()
        for(card in cards) {
            list.add(card)
        }
        return magazine(list)
    }

    private fun magazine(cards: List<Card>): ICardMagazine {
        return DefinedCardMagazine(fakeMagList(Gc.X0, cards), fakeMagList(Gc.X1), fakeMagList(Gc.X2))
    }

    private fun fakeMagList(defaultCard: Card, initial: List<Card> = ArrayList()): List<Card> {
        val res = ArrayList<Card>(initial)
        while (res.size < 15) {
            res.add(defaultCard)
        }
        return res
    }
}