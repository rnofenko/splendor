package rn.splendor.card

class SequencedCardMagazine : ICardMagazine {

    override fun pop(list: ArrayList<Card>): Card {
        if(list.isEmpty()) {
            return Card.blank
        }
        val card = list[0]
        list.removeAt(0)
        return card
    }
}