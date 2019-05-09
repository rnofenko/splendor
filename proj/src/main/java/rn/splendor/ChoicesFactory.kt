package rn.splendor

import rn.splendor.entity.GemBank
import rn.splendor.entity.Gem
import rn.splendor.tool.CombinationInt

class ChoicesFactory {
    fun selectGem3(): List<GemBank> {
        return CombinationInt().build(3, Global.gemTypeCount).map { GemBank.ofIndices(it) }
    }

    fun selectGemDuplicate(): List<GemBank> {
        val a = IntArray(Global.gemTypeCount) { i -> i}
        return a.map { GemBank.create(Gem.fromInt(it), 2) }
    }

    fun selectGem2(): List<GemBank> {
        return CombinationInt().build(2, Global.gemTypeCount).map { GemBank.ofIndices(it) }
    }
}