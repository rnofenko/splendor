package rn.splendor.card

import rn.splendor.entity.Card
import rn.splendor.tool.AppException
import java.time.LocalDateTime
import kotlin.random.Random

class RandCardMagazine : ICardMagazine {

    private val mapByLevel: Map<CardLevel, ArrayList<Card>>
    private val level0 : ArrayList<Card>
    private val level1 : ArrayList<Card>
    private val level2 : ArrayList<Card>
    private val rand: Random

    constructor() {
        level0 = ArrayList(CardSet.allLevel0)
        level1 = ArrayList(CardSet.allLevel1)
        level2 = ArrayList(CardSet.allLevel2)
        rand = Random(LocalDateTime.now().nano)
        mapByLevel = mapOf(CardLevel.L0 to level0, CardLevel.L1 to level1, CardLevel.L2 to level2)
    }

    override fun getInitial() : Array<Card> {
        val list = getInitial(level0)
        list.addAll(getInitial(level1))
        list.addAll(getInitial(level2))
        return list.toTypedArray()
    }

    override fun pop(level: CardLevel): Card {
        val list = mapByLevel[level] ?: throw AppException("Level no found")
        return pop(list)
    }

    private fun pop(list: ArrayList<Card>) : Card {
        if(list.isEmpty()) {
            return Card.blank
        }
        val index = rand.nextInt(list.size)
        val card = list[index]
        list.removeAt(index)
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