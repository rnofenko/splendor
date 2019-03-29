package rn.splendor

class Bank {
    private val gems : IntArray

    constructor(gemsCount: Int) {
        this.gems = intArrayOf(gemsCount, gemsCount, gemsCount, gemsCount, gemsCount)
    }

    companion object {
        fun createForTable() : Bank {
            return Bank(4)
        }

        fun createEmpty() : Bank {
            return Bank(0)
        }
    }
}