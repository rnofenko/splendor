package rn.splendor

import rn.splendor.card.DefinedCardMagazine
import rn.splendor.card.ICardMagazine
import rn.splendor.entity.CARD
import rn.splendor.entity.Card

object Tester {
    fun magazine(vararg cards: Card): ICardMagazine {
        val list = ArrayList<Card>()
        for(card in cards) {
            list.add(card)
        }
        return DefinedCardMagazine(fakeMagList(list), fakeMagList(), fakeMagList())
    }

    private fun fakeMagList(initial: List<Card> = ArrayList()): List<Card> {
        val res = ArrayList<Card>(initial)
        while (res.size < 15) {
            res.add(CARD.X)
        }
        return res
    }
}