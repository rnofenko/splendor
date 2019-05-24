package rn.splendor.entity

import rn.splendor.Global.Companion.userBankLimit
import rn.splendor.card.Card
import rn.splendor.card.CardSet
import rn.splendor.card.Noble

class User {
    private var allGems: GemBank
    private val permanentGems: GemBank
    private val tempGems: GemBank
    var points: Int = 0
        private set
    var gold: Int = 0
        private set
    private val borrowed: ArrayList<Card>

    constructor() {
        allGems = GemBank.createEmpty()
        permanentGems = GemBank.createEmpty()
        tempGems = GemBank.createEmpty()
        this.borrowed = ArrayList()
    }

    constructor(tempGems: GemBank, permanentGems: GemBank, points: Int, gold: Int, borrowed: List<Card>) {
        this.allGems = GemBank.combine(tempGems, permanentGems)
        this.permanentGems = permanentGems
        this.points = points
        this.tempGems = tempGems
        this.gold = gold
        this.borrowed = ArrayList(borrowed)
    }

    val hasOneSpace: Boolean
        get() = userBankLimit - tempGems.total - gold >= 1

    val hasTwoSpaces: Boolean
        get() = userBankLimit - tempGems.total - gold >= 2

    val hasThreeSpaces: Boolean
        get() = userBankLimit - tempGems.total - gold >= 3

    fun clone(): User {
        return User(tempGems.clone(), permanentGems.clone(), points, gold, borrowed)
    }

    fun plus(bank: GemBank) {
        this.allGems.plus(bank)
        this.tempGems.plus(bank)
    }

    fun minus(gems: GemBank) {
        val negative = this.tempGems.minus(gems)
        gold -= negative

        allGems.copy(permanentGems)
        allGems.plus(tempGems)
    }

    fun plus(gem: Gem, count: Int = 1): User {
        this.allGems.plus(gem, count)
        this.tempGems.plus(gem, count)
        return this
    }

    fun plusPermanent(gem: Gem, count: Int = 1): User {
        this.permanentGems.plus(gem, count)
        this.allGems.plus(gem)
        return this
    }

    fun addPoints(points: Int): User {
        this.points += points
        return this
    }

    fun plusGold(): User {
        this.gold++
        return this
    }

    fun getUniqueKey(): String {
        return permanentGems.getUniqueKey() + tempGems.getUniqueKey() + points
    }

    fun canBuy(card: Card): Boolean {
        return allGems.equalOrMore(card.cost, gold)
    }

    fun calcBuyCost(card: Card): GemBank {
        return Calculator.minus(card.cost, permanentGems)
    }

    fun canTake(noble: Noble): Boolean {
        return permanentGems.equalOrMore(noble.cost)
    }

    fun canBorrow(): Boolean {
        return borrowed.size < CardSet.borrowLimit && hasOneSpace
    }

    fun borrow(card: Card): User {
        borrowed.add(card)
        return this
    }

    fun redeem(card: Card) {
        borrowed.remove(card)
    }

    fun getBorrowed(): List<Card> {
        return borrowed
    }
}