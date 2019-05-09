package rn.splendor.entity

class GemBank {
    val gems : IntArray
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

    constructor(gems: IntArray) {
        this.gems = gems
        this.total = this.gems.sum()
    }

    fun equalOrMore(bank: GemBank): Boolean {
        for (i in gems.indices) {
            if(gems[i] < bank.gems[i]) {
                return false
            }
        }
        return true
    }

    fun less(bank: GemBank): Boolean {
        for (i in gems.indices) {
            if(gems[i] < bank.gems[i]) {
                return true
            }
        }
        return false
    }

    fun plus(gem: Gem, count: Int = 1): GemBank {
        this.gems[gem.index] += count
        this.total += count

        return this
    }

    private fun plus(gem: Int, count: Int) {
        this.gems[gem] += count
        this.total += count
    }

    fun clone(): GemBank {
        return GemBank(gems.clone())
    }

    fun minus(bank: GemBank) {
        for (i in gems.indices) {
            gems[i] -= bank.gems[i]
        }
        this.total = this.gems.sum()
    }

    fun plus(bank: GemBank) {
        for (i in gems.indices) {
            gems[i] += bank.gems[i]
        }
        this.total = this.gems.sum()
    }

    override fun toString(): String {
        return "W${gems[Gem.W.index]} U${gems[Gem.U.index]} G${gems[Gem.G.index]} R${gems[Gem.R.index]} B${gems[Gem.B.index]}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GemBank

        if (total != other.total) return false
        if (!gems.contentEquals(other.gems)) return false

        return true
    }

    override fun hashCode(): Int {
        return gems.contentHashCode()
    }

    companion object {
        fun createForTable() : GemBank {
            return GemBank(4)
        }

        fun createEmpty() : GemBank {
            return GemBank(0)
        }

        fun create(gem: Gem, count: Int): GemBank {
            val bank = createEmpty()
            bank.plus(gem, count)
            return bank
        }

        fun ofIndices(indices: IntArray): GemBank {
            val bank = createEmpty()
            for(i in indices) {
                bank.plus(i, 1)
            }
            return bank
        }

        fun g(g: Int, r: Int = 0, b: Int = 0) : GemBank {
            return GemBank(0, 0, g, r, b)
        }

        fun w(w: Int, u: Int = 0, g: Int = 0, r: Int = 0, b: Int = 0) : GemBank {
            return GemBank(w, u, g, r, b)
        }

        fun u(u: Int, g: Int = 0, r: Int = 0, b: Int = 0) : GemBank {
            return GemBank(0, u, g, r, b)
        }

        fun r(r: Int, b: Int = 0) : GemBank {
            return GemBank(0, 0, 0, r, b)
        }

        fun b(b: Int) : GemBank {
            return GemBank(0, 0, 0, 0, b)
        }

        fun combine(tempGems: GemBank, permanentGems: GemBank): GemBank {
            val tempArray = tempGems.gems
            val permanentArray = permanentGems.gems
            val sum = IntArray(tempGems.gems.size)
            for(i in sum.indices) {
                sum[i] = tempArray[i] + permanentArray[i]
            }
            return GemBank(sum)
        }
    }
}