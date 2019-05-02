package rn.splendor.entity

class Table {
    val bank: Bank
    val user: User
    var cards: List<Card>

    constructor(cards: List<Card>) {
        bank = Bank.createForTable()
        user = User()
        this.cards = cards
    }

    fun clone() : Table {
        return this
    }
}