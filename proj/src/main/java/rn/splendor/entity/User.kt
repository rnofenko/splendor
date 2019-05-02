package rn.splendor.entity

import rn.splendor.Global.Companion.userBankLimit

class User {
    val bank: Bank = Bank.createEmpty()

    val hasTwoSpaces: Boolean
        get() = userBankLimit - bank.total >= 2

    val hasThreeSpaces: Boolean
        get() = userBankLimit - bank.total >= 3
}