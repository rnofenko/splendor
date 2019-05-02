package rn.splendor

import rn.splendor.entity.Bank
import rn.splendor.entity.Gem
import rn.splendor.tool.CombinationInt

class ChoicesFactory {
    fun selectGem3(): List<Bank> {
        return CombinationInt().build(3, Global.gemTypeCount).map { Bank.ofIndices(it) }
    }

    fun selectGemDuplicate(): List<Bank> {
        val a = IntArray(Global.gemTypeCount) { i -> i}
        return a.map { Bank.create(Gem.fromInt(it), 2) }
    }

    fun selectGem2(): List<Bank> {
        return CombinationInt().build(2, Global.gemTypeCount).map { Bank.ofIndices(it) }
    }
}