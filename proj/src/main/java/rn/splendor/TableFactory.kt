package rn.splendor

import rn.splendor.entity.Table

class TableFactory {
    fun create(cardSet: CardSet): Table {
        val cards = cardSet.getInitialSet()
        return Table(cards)
    }
}