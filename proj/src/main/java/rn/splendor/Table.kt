package rn.splendor

class Table {
    val bank: Bank
    val user: User
    private var cards: Array<Card>

    constructor(cards: Array<Card>) {
        bank = Bank.createForTable()
        user = User()
        this.cards = cards
    }
}