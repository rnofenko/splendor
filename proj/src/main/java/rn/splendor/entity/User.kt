package rn.splendor.entity

import rn.splendor.Global.Companion.userBankLimit

class User {
    val bank: Bank
    var points: Int = 0
        private set

    constructor() {
        bank = Bank.createEmpty()
    }

    constructor(bank: Bank, points: Int) {
        this.bank = bank
        this.points = points
    }

    val hasTwoSpaces: Boolean
        get() = userBankLimit - bank.total >= 2

    val hasThreeSpaces: Boolean
        get() = userBankLimit - bank.total >= 3

    fun clone(): User {
        return User(bank.clone(), points)
    }

    fun plus(bank: Bank) {
        this.bank.plus(bank)
    }

    fun addPoints(card: Card) {
        points += card.points
    }
}