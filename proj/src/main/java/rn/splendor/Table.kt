package rn.splendor

class Table {
    private val bank: Bank
    private val user: User
    private var cards: Array<Card>

    constructor(cards: Array<Card>) {
        bank = Bank.createForTable()
        user = User()
        this.cards = cards
    }
}