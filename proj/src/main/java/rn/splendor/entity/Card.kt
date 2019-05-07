package rn.splendor.entity

class Card(val reward: Gem, val points: Int, val cost: Bank, isBlank: Boolean = false) {
    companion object {
        val blank = Card(Gem.W, 0, Bank.createEmpty(), true)
    }
}

object CARD {
    val W0_W3 = Card(Gem.W, 0, Bank.w(3,1,0,0,1))
    val W0_U = Card(Gem.W, 0, Bank.u(1,2,1,1))
    val W0_U2 = Card(Gem.W, 0, Bank.u(2,2,0,1))
    val X = Card(Gem.W, 0, Bank.w(9))
}