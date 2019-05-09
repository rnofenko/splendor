package rn.splendor.action.provider

import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Table
import rn.splendor.entity.User

class UnitedActionProvider : IActionProvider {
    private val takeGemProvider = TakeGemActionProvider()
    private val buyCardProvider = BuyCardActionProvider()

    override fun get(table: Table, user: User): List<IAction> {
        val actions = ArrayList<IAction>()
        actions.addAll(takeGemProvider.get(table, user))
        actions.addAll(buyCardProvider.get(table, user))

        return actions
    }
}