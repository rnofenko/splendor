package rn.splendor.action.provider

import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Game
import rn.splendor.entity.User

class RedeemCardActionProvider : IActionProvider {

    override fun get(game: Game, user: User): List<IAction> {
        val result = ArrayList<IAction>()
        for(card in user.getBorrowed()) {
            if(user.canBuy(card)) {
                result.add(ActionFactory.redeemCard(card))
            }
        }

        return result
    }
}