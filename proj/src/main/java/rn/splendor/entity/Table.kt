package rn.splendor.entity

import rn.splendor.card.Deck
import rn.splendor.card.ICardMagazine

class Table {
    val bank: GemBank
    val deck: Deck
    val magazine: ICardMagazine

    constructor(cards: Array<Card>, magazine: ICardMagazine) {
        bank = GemBank.createForTable()
        deck = Deck(cards)
        this.magazine = magazine
    }

    constructor(deck: Deck, bank: GemBank, magazine: ICardMagazine) {
        this.bank = bank
        this.deck = deck
        this.magazine = magazine
    }

    fun clone(): Table {
        return Table(deck.clone(), bank.clone(), this.magazine.clone())
    }
}