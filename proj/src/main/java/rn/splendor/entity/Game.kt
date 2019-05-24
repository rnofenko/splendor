package rn.splendor.entity

import rn.splendor.card.Card
import rn.splendor.card.Deck
import rn.splendor.card.Noble
import rn.splendor.card.Table

class Game {
    val bank: GemBank
    val nobles: ArrayList<Noble>
    val table: Table
    val deck: Deck
    var gold: Int = 0
        private set

    constructor(cards: List<Card>, deck: Deck, nobles: List<Noble>, gold: Int) {
        bank = GemBank.createForTable()
        table = Table(cards)
        this.deck = deck
        this.nobles = ArrayList(nobles)
        this.gold = gold
    }

    constructor(table: Table, bank: GemBank, deck: Deck, nobles: List<Noble>, gold: Int) {
        this.bank = bank
        this.table = table
        this.deck = deck
        this.nobles = ArrayList(nobles)
        this.gold = gold
    }

    fun clone(): Game {
        return Game(table.clone(), bank.clone(), this.deck.clone(), nobles, gold)
    }

    fun getUniqueKey(): String {
        return bank.getUniqueKey() + table.hashCode()
    }

    fun removeNoble(noble: Noble) {
        nobles.remove(noble)
    }

    fun takeGold() {
        gold--
    }
}