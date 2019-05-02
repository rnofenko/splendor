package rn.splendor

import rn.splendor.entity.Bank
import rn.splendor.entity.Card
import rn.splendor.entity.Gem
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class CardSet {
    private val LEVEL_SIZE = 4
    private val level0 : ArrayList<Card>
    private val level1 : ArrayList<Card>
    private val level2 : ArrayList<Card>
    private val rand: Random

    constructor() {
        level0 = ArrayList(allLevel0)
        level1 = ArrayList(allLevel1)
        level2 = ArrayList(allLevel2)
        rand = Random(LocalDateTime.now().nano)
    }

    fun getInitialSet() : List<Card> {
        val list = getInitial(level0)
        list.addAll(getInitial(level1))
        list.addAll(getInitial(level2))
        return list
    }

    fun pop(list: ArrayList<Card>) : Card {
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
        for(i in 0..LEVEL_SIZE) {
            res.add(pop(source))
        }
        return res
    }

    companion object {
        val allLevel0 : List<Card> = Arrays.asList(
                Card(Gem.W, 0, Bank.u(1, 2, 1, 1)),
                Card(Gem.W, 0, Bank.u(2, 2, 0, 1)),

                Card(Gem.U, 0, Bank.w(1, 0, 1, 2, 1)),
                Card(Gem.U, 0, Bank.w(1, 0, 2, 2)),
                Card(Gem.U, 0, Bank.u(1, 3, 1)),
                Card(Gem.U, 0, Bank.g(2, 0, 2)),
                Card(Gem.U, 0, Bank.b(3)),
                Card(Gem.U, 1, Bank.r(4)),

                Card(Gem.G, 0, Bank.w(1, 1, 0, 1, 2)),
                Card(Gem.G, 0, Bank.u(1, 0, 2, 2)),
                Card(Gem.G, 0, Bank.u(2, 0, 2)),
                Card(Gem.G, 1, Bank.b(4)),

                Card(Gem.R, 0, Bank.w(1, 0, 0, 1, 3)),
                Card(Gem.R, 0, Bank.w(2, 0, 0, 2)),
                Card(Gem.R, 0, Bank.w(2, 0, 1, 0, 2)),
                Card(Gem.R, 0, Bank.w(3)),
                Card(Gem.R, 0, Bank.u(2, 1)),
                Card(Gem.R, 1, Bank.w(4)),

                Card(Gem.B, 0, Bank(0, 0, 3, 0, 0)),
                Card(Gem.B, 0, Bank(1, 1, 1, 1, 0)),
                Card(Gem.B, 1, Bank(0, 4, 0, 0, 0))
        )

        val allLevel1 : List<Card> = Arrays.asList(
                Card(Gem.W, 1, Bank.w(2, 3, 0, 3)),
                Card(Gem.W, 2, Bank.r(5, 3)),
                Card(Gem.W, 3, Bank.w(6)),

                Card(Gem.U, 1, Bank.u(2, 2, 3)),
                Card(Gem.U, 2, Bank.w(5, 3)),
                Card(Gem.U, 2, Bank.u(5)),

                Card(Gem.G, 1, Bank.w(2, 3, 0, 0, 2)),
                Card(Gem.G, 1, Bank.w(3, 0, 2, 3)),
                Card(Gem.G, 2, Bank.w(4, 2, 0, 0, 1)),
                Card(Gem.G, 2, Bank.w(4, 2, 0, 0, 1)),
                Card(Gem.G, 2, Bank.u(5, 3)),
                Card(Gem.G, 3, Bank.g(6)),

                Card(Gem.R, 1, Bank.w(2, 0, 0, 2, 3)),
                Card(Gem.R, 1, Bank.u(3, 0, 2, 3)),
                Card(Gem.R, 2, Bank.w(1, 4, 2)),
                Card(Gem.R, 2, Bank.w(3, 0, 0, 0, 5)),

                Card(Gem.B, 1, Bank.w(3, 2, 2, 0, 0)),
                Card(Gem.B, 2, Bank.g(5, 3)),
                Card(Gem.B, 3, Bank.b(6))
        )

        val allLevel2 : List<Card> = Arrays.asList(
                Card(Gem.W, 3, Bank.u(3, 3, 5, 3)),
                Card(Gem.W, 4, Bank.w(3, 0, 0, 3, 6)),
                Card(Gem.W, 4, Bank.b(7)),
                Card(Gem.W, 5, Bank.w(3, 0, 0, 0, 7)),

                Card(Gem.U, 4, Bank.w(7)),
                Card(Gem.U, 5, Bank.w(2, 3, 0, 3)),
                Card(Gem.U, 5, Bank.w(7, 3)),

                Card(Gem.G, 3, Bank.w(5, 3, 0, 3, 3)),
                Card(Gem.G, 4, Bank.w(3, 6, 3)),

                Card(Gem.R, 3, Bank.w(3, 5, 3, 0, 3)),
                Card(Gem.R, 4, Bank.g(7)),
                Card(Gem.R, 5, Bank.g(7, 3)),

                Card(Gem.B, 3, Bank.w(3, 3, 5, 3, 0)),
                Card(Gem.B, 4, Bank.g(3, 6, 3)),
                Card(Gem.B, 4, Bank.b(7)),
                Card(Gem.B, 4, Bank.r(7)),
                Card(Gem.B, 5, Bank.r(7, 3))
        )
    }
}

