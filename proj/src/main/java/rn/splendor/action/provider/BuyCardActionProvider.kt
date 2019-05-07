package rn.splendor.action.provider

import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Table

class BuyCardActionProvider : IActionProvider {

    override fun get(table: Table): List<IAction> {
        val result = ArrayList<IAction>()
        val userBank = table.user.bank
        for(card in table.deck.cards) {
            if(userBank.equalOrMore(card.cost)) {
                result.add(ActionFactory.buyCard(card))
            }
        }

        return result
    }
}