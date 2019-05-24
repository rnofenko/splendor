package rn.splendor.card

class Table {
    val cards: Array<Card>

    constructor(cards: List<Card>) {
        this.cards = cards.toTypedArray()
    }

    constructor(cards: Array<Card>) {
        this.cards = cards.clone()
    }

    fun clone(): Table {
        return Table(cards)
    }

    fun replace(oldCard: Card, newCard: Card) {
        for (i in cards.indices) {
            if(cards[i] == oldCard) {
                cards[i] = newCard
            }
        }
    }

    override fun hashCode(): Int {
        return cards.contentHashCode()
    }
}