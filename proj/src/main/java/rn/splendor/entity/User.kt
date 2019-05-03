package rn.splendor.entity

import rn.splendor.Global.Companion.userBankLimit

class User {
    val bank: Bank

    constructor() {
        bank = Bank.createEmpty()
    }

    constructor(bank: Bank) {
        this.bank = bank
    }

    val hasTwoSpaces: Boolean
        get() = userBankLimit - bank.total >= 2

    val hasThreeSpaces: Boolean
        get() = userBankLimit - bank.total >= 3

    fun clone(): User {
        return User(bank.clone())
    }

    fun plus(bank: Bank) {
        this.bank.plus(bank)
    }
}