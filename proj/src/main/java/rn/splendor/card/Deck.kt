package rn.splendor.card

import rn.splendor.entity.Card

class Deck {
    val cards: Array<Card>

    constructor(cards: Array<Card>) {
        this.cards = cards.clone()
    }

    fun clone(): Deck {
        return Deck(cards)
    }

    fun replace(oldCard: Card, newCard: Card) {
        for (i in cards.indices) {
            if(cards[i] == oldCard) {
                cards[i] = newCard
            }
        }
    }
}