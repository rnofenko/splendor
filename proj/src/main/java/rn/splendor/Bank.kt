package rn.splendor

class Bank {
    private val gems : IntArray
    var total: Int
        private set

    constructor(gemsCount: Int) {
        this.gems = intArrayOf(gemsCount, gemsCount, gemsCount, gemsCount, gemsCount)
        this.total = this.gems.sum()
    }

    constructor(w: Int, u: Int, g: Int, r: Int, b: Int) {
        this.gems = intArrayOf(w, u, g, r, b)
        this.total = this.gems.sum()
    }

    fun equalOrMore(bank: Bank): Boolean {
        for (i in gems.indices) {
            if(gems[i] < bank.gems[i]) {
                return false
            }
        }
        return true
    }

    private fun add(gem: Gem, count: Int) {
        this.gems[gem.index] += count
        this.total += count
    }

    private fun add(gem: Int, count: Int) {
        this.gems[gem] += count
        this.total += count
    }

    companion object {
        fun createForTable() : Bank {
            return Bank(4)
        }

        fun createEmpty() : Bank {
            return Bank(0)
        }

        fun create(gem: Gem, count: Int): Bank {
            val bank = createEmpty()
            bank.add(gem, count)
            return bank
        }

        fun ofIndices(indices: IntArray): Bank {
            val bank = createEmpty()
            for(i in indices) {
                bank.add(i, 1)
            }
            return bank
        }

        fun g(g: Int, r: Int = 0, b: Int = 0) : Bank {
            return Bank(0, 0, g, r, b)
        }

        fun w(w: Int, u: Int = 0, g: Int = 0, r: Int = 0, b: Int = 0) : Bank {
            return Bank(w, u, g, r, b)
        }

        fun u(u: Int, g: Int = 0, r: Int = 0, b: Int = 0) : Bank {
            return Bank(0, u, g, r, b)
        }

        fun r(r: Int, b: Int = 0) : Bank {
            return Bank(0, 0, 0, r, b)
        }

        fun b(b: Int) : Bank {
            return Bank(0, 0, 0, 0, b)
        }
    }
}