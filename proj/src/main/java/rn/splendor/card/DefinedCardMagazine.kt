package rn.splendor.card

import rn.splendor.entity.Card
import rn.splendor.tool.AppException

class DefinedCardMagazine : ICardMagazine {
    private var mapByLevel: Map<CardLevel, ArrayList<Card>>
    private val level0 : ArrayList<Card>
    private val level1 : ArrayList<Card>
    private val level2 : ArrayList<Card>

    constructor(level0 : ArrayList<Card>, level1 : ArrayList<Card>, level2 : ArrayList<Card>) {
        this.level0 = level0
        this.level1 = level1
        this.level2 = level2
        mapByLevel = mapOf(CardLevel.L0 to level0, CardLevel.L1 to level1, CardLevel.L2 to level2)
    }

    override fun getInitial(): Array<Card> {
        val list = getInitial(level0)
        list.addAll(getInitial(level1))
        list.addAll(getInitial(level2))
        return list.toTypedArray()
    }

    override fun pop(level: CardLevel): Card {
        val list = mapByLevel[level] ?: throw AppException("Level no found")
        return pop(list)
    }

    private fun pop(list: ArrayList<Card>): Card {
        if(list.isEmpty()) {
            return Card.blank
        }
        val card = list[0]
        list.removeAt(0)
        return card
    }

    private fun getInitial(source: ArrayList<Card>) : ArrayList<Card> {
        val res = ArrayList<Card>()
        for(i in 0..CardSet.LEVEL_SIZE) {
            res.add(pop(source))
        }
        return res
    }
}