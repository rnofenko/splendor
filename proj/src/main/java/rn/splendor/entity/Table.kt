package rn.splendor.entity

class Table {
    val bank: Bank
    val user: User
    var cards: Array<Card>

    constructor(cards: Array<Card>) {
        bank = Bank.createForTable()
        user = User()
        this.cards = cards
    }

    constructor(cards: Array<Card>, bank: Bank, user: User) {
        this.bank = bank
        this.user = user
        this.cards = cards
    }

    fun clone(): Table {
        return Table(cards.copyOf(), bank.clone(), user.clone())
    }
}