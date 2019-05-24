package rn.splendor.action.provider

import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Game
import rn.splendor.entity.User

class BorrowActionProvider : IActionProvider {
    override fun get(game: Game, user: User): List<IAction> {
        if(!user.canBorrow()) {
            return emptyList()
        }

        val actions = ArrayList<IAction>()
        for (card in game.table.cards) {
            actions.add(ActionFactory.borrow(card))
        }
        return actions
    }
}