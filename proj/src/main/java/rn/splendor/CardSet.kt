package rn.splendor

class CardSet {
    private val INITIAL_SIZE = 12

    fun getInitialSet() : Array<Card> {
        val array = Array<Card>(INITIAL_SIZE)
        for(i in array.indices) {
            array[i] = Card()
        }
        return array
    }
}