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

    fun minus(gems: GemBank) {
        this.allGems.minus(gems)
        this.tempGems.minus(gems)
    }

    fun plus(gem: Gem, count: Int = 1): User {
        this.allGems.plus(gem, count)
        this.tempGems.plus(gem, count)
        return this
    }

    fun plusPermanent(gem: Gem): User {
        this.permanentGems.plus(gem)
        this.allGems.plus(gem)
        return this
    }

    fun addPoints(points: Int): User {
        this.points += points
        return this
    }

    fun getUniqueKey(): String {
        return permanentGems.getUniqueKey() + tempGems.getUniqueKey() + points
    }
}