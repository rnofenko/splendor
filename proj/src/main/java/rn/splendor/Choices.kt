package rn.splendor

import rn.splendor.entity.Bank

class Choices {

    companion object {
        val gem3AndDuplicate: List<Bank>
        val gem2: List<Bank>
        init {
            val factory = ChoicesFactory()
            gem2 = factory.selectGem2()

            val gem3 = ArrayList<Bank>(factory.selectGem3())
            gem3.addAll(factory.selectGemDuplicate())
            gem3AndDuplicate = gem3
        }
    }
}