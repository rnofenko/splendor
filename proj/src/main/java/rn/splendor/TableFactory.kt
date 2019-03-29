package rn.splendor

class TableFactory {
    fun create(cardSet: CardSet): Table {
        val cards = cardSet.getInitialSet()
        return Table(cards)
    }
}