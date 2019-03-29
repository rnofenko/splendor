package rn.splendor

class Card(val reward: Gem, val points: Int, val cost: Bank, isBlank: Boolean = false) {
    companion object {
        val blank = Card(Gem.W, 0, Bank.createEmpty(), true)
    }
}