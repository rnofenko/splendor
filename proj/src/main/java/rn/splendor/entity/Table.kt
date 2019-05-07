package rn.splendor.entity

import rn.splendor.card.Deck
import rn.splendor.card.ICardMagazine

class Table {
    val bank: Bank
    val user: User
    val deck: Deck
    val magazine: ICardMagazine

    constructor(cards: Array<Card>, magazine: ICardMagazine) {
        bank = Bank.createForTable()
        user = User()
        deck = Deck(cards)
        this.magazine = magazine
    }

    constructor(deck: Deck, bank: Bank, user: User, magazine: ICardMagazine) {
        this.bank = bank
        this.user = user
        this.deck = deck
        this.magazine = magazine
    }

    fun clone(): Table {
        return Table(deck.clone(), bank.clone(), user.clone(), this.magazine.clone())
    }
}