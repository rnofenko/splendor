package rn.splendor

import rn.splendor.entity.GemBank

class Choices {

    companion object {
        val gem3AndDuplicate: List<GemBank>
        val gem2: List<GemBank>
        init {
            val factory = ChoicesFactory()
            gem2 = factory.selectGem2()

            val gem3 = ArrayList<GemBank>(factory.selectGem3())
            gem3.addAll(factory.selectGemDuplicate())
            gem3AndDuplicate = gem3
        }
    }
}