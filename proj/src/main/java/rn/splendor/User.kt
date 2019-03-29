package rn.splendor

import rn.splendor.Global.Companion.userBankLimit

class User {
    private val bank: Bank = Bank.createEmpty()

    val hasTwoSpaces: Boolean
        get() = userBankLimit - bank.total >= 2

    val hasThreeSpaces: Boolean
        get() = userBankLimit - bank.total >= 3
}