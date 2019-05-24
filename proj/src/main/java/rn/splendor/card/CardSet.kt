package rn.splendor.card

class CardSet {
    companion object {
        const val LEVEL_SIZE = 4

        val allLevel0: List<Card> = Gc.level0

        val allLevel1: List<Card> = Gc.level1

        val allLevel2: List<Card> = Gc.level2

        const val initialGoldCount = 5
        const val initialNoblesCount = 3L
        const val borrowLimit = 3

        const val WIN_POINTS = 15
    }
}

