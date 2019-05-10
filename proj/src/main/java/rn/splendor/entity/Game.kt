package rn.splendor.entity

import rn.splendor.card.Card
import rn.splendor.card.Deck
import rn.splendor.card.Table

class Game {
    val bank: GemBank
    val table: Table
    val deck: Deck

    constructor(cards: Array<Card>, deck: Deck) {
        bank = GemBank.createForTable()
        table = Table(cards)
        this.deck = deck
    }

    constructor(table: Table, bank: GemBank, deck: Deck) {
        this.bank = bank
        this.table = table
        this.deck = deck
    }

    fun clone(): Game {
        return Game(table.clone(), bank.clone(), this.deck.clone())
    }

    fun getUniqueKey(): String {
        return bank.getUniqueKey() + table.hashCode()
    }
}