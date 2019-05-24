package rn.splendor.action.provider

import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Game
import rn.splendor.entity.User

class UnitedActionProvider : IActionProvider {
    private val takeGemProvider = TakeGemActionProvider()
    private val buyCardProvider = BuyCardActionProvider()
    private val redeemCardProvider = RedeemCardActionProvider()
    private val nobleProvider = NobleActionProvider()
    private val borrowProvider = BorrowActionProvider()

    override fun get(game: Game, user: User): List<IAction> {
        val actions = ArrayList(nobleProvider.get(game, user))
        if(actions.isNotEmpty()) {
            return actions
        }

        actions.addAll(takeGemProvider.get(game, user))
        actions.addAll(buyCardProvider.get(game, user))
        actions.addAll(borrowProvider.get(game, user))
        actions.addAll(redeemCardProvider.get(game, user))

        return actions
    }
}