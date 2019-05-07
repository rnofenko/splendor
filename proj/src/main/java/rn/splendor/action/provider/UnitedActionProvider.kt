package rn.splendor.action.provider

import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Table

class UnitedActionProvider : IActionProvider {
    private val takeGemProvider = TakeGemActionProvider()
    private val buyCardProvider = BuyCardActionProvider()

    override fun get(table: Table): List<IAction> {
        val actions = ArrayList<IAction>()
        actions.addAll(takeGemProvider.get(table))
        actions.addAll(buyCardProvider.get(table))

        return actions
    }
}