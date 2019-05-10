package rn.splendor.action.provider

import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Game
import rn.splendor.entity.User

class BuyCardActionProvider : IActionProvider {

    override fun get(game: Game, user: User): List<IAction> {
        val result = ArrayList<IAction>()
        for(card in game.table.cards) {
            if(user.allGems.equalOrMore(card.cost)) {
                result.add(ActionFactory.buyCard(card))
            }
        }

        return result
    }
}