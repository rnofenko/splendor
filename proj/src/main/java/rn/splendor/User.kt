package rn.splendor

class User {
    private val bank: Bank

    constructor() {
        bank = Bank.createEmpty()
    }
}