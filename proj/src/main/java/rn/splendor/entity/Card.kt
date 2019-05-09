package rn.splendor.entity

import rn.splendor.card.CardLevel

class Card(val reward: Gem, val points: Int, val cost: GemBank, val level: CardLevel, isBlank: Boolean = false) {
    companion object {
        val blank = Card(Gem.W, 0, GemBank.createEmpty(), CardLevel.L2, true)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (reward != other.reward) return false
        if (points != other.points) return false
        if (cost != other.cost) return false

        return true
    }

    override fun hashCode(): Int {
        var result = reward.hashCode()
        result = 31 * result + points
        result = 31 * result + cost.hashCode()
        return result
    }

    override fun toString(): String {
        return "${reward.name}$points $cost"
    }
}