package rn.splendor

import rn.splendor.card.ICardMagazine
import rn.splendor.entity.Table

class TableFactory {
    fun create(magazine: ICardMagazine): Table {
        val cards = magazine.getInitial()
        return Table(cards)
    }
}