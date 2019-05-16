package rn.splendor.card

import rn.splendor.tool.AppException

class SequencedCardMagazine : ICardMagazine {

    override fun pop(list: ArrayList<Card>): Card {
        if(list.isEmpty()) {
            throw AppException("No cards in magazine")
        }
        val card = list[0]
        list.removeAt(0)
        return card
    }
}