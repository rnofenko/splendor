package rn.splendor

class Bank {
    private val gems : IntArray

    constructor(gemsCount: Int) {
        this.gems = intArrayOf(gemsCount, gemsCount, gemsCount, gemsCount, gemsCount)
    }

    constructor(w: Int, u: Int, g: Int, r: Int, b: Int) {
        this.gems = intArrayOf(w, u, g, r, b)
    }

    companion object {
        fun createForTable() : Bank {
            return Bank(4)
        }

        fun createEmpty() : Bank {
            return Bank(0)
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