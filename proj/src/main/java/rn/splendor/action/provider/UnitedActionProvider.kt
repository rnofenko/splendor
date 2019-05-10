package rn.splendor.action.provider

import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Game
import rn.splendor.entity.User

class UnitedActionProvider : IActionProvider {
    private val takeGemProvider = TakeGemActionProvider()
    private val buyCardProvider = BuyCardActionProvider()

    override fun get(game: Game, user: User): List<IAction> {
        val actions = ArrayList<IAction>()
        actions.addAll(takeGemProvider.get(game, user))
        actions.addAll(buyCardProvider.get(game, user))

        return actions
    }
}