package rn.splendor.entity

import rn.splendor.Global.Companion.userBankLimit

class User {
    val allGems: GemBank
    val permanentGems: GemBank
    val tempGems: GemBank
    var points: Int = 0
        private set

    constructor() {
        allGems = GemBank.createEmpty()
        permanentGems = GemBank.createEmpty()
        tempGems = GemBank.createEmpty()
    }

    constructor(tempGems: GemBank, permanentGems: GemBank, points: Int) {
        this.allGems = GemBank.combine(tempGems, permanentGems)
        this.permanentGems = permanentGems
        this.points = points
        this.tempGems = tempGems
    }

    val hasTwoSpaces: Boolean
        get() = userBankLimit - tempGems.total >= 2

    val hasThreeSpaces: Boolean
        get() = userBankLimit - tempGems.total >= 3

    fun clone(): User {
        return User(tempGems.clone(), permanentGems.clone(), points)
    }

    fun plus(bank: GemBank) {
        this.allGems.plus(bank)
        this.tempGems.plus(bank)
    }

    fun minus(bank: GemBank) {
        this.allGems.minus(bank)
        this.tempGems.minus(bank)
    }

    fun plus(gem: Gem, count: Int = 1): User {
        this.allGems.plus(gem, count)
        this.tempGems.plus(gem, count)
        return this
    }

    fun plusPermanent(gem: Gem) {
        this.permanentGems.plus(gem)
    }

    fun addPoints(card: Card) {
        points += card.points
    }
}