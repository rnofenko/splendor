package rn.splendor.action.executor

import rn.splendor.card.Card
import rn.splendor.entity.Game
import rn.splendor.entity.User
import rn.splendor.tool.AppException

class BuyCardProcedure {
    fun execute(game: Game, user: User, card: Card) {
        if(!user.canBuy(card)) {
            throw AppException("Not enough gems")
        }

        val finalCost = user.calcBuyCost(card)

        user.addPoints(card.points)
        user.minus(finalCost)
        user.plusPermanent(card.reward)

        game.bank.plus(finalCost)
    }
}