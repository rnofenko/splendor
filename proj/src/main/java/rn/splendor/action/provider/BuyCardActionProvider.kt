package rn.splendor.action.provider

import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Table
import rn.splendor.entity.User

class BuyCardActionProvider : IActionProvider {

    override fun get(table: Table, user: User): List<IAction> {
        val result = ArrayList<IAction>()
        for(card in table.deck.cards) {
            if(user.allGems.equalOrMore(card.cost)) {
                result.add(ActionFactory.buyCard(card))
            }
        }

        return result
    }
}