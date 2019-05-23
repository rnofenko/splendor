package rn.splendor.entity

object Calculator {
    fun minus(bank1: GemBank, bank2: GemBank): GemBank {
        val res = bank1.gems.clone()
        for (i in res.indices) {
            res[i] -= bank2.gems[i]
            if(res[i] < 0) {
                res[i] = 0
            }
        }
        return GemBank(res)
    }

    fun plus(addend1: GemBank, addend2: GemBank): GemBank {
        val res = addend1.gems.clone()
        for (i in res.indices) {
            res[i] = addend1.gems[i] + addend2.gems[i]
        }
        return GemBank(res)
    }
}