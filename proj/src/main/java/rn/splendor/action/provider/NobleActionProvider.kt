package rn.splendor.action.provider

import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Game
import rn.splendor.entity.User

class NobleActionProvider : IActionProvider {
    override fun get(game: Game, user: User): List<IAction> {
        val result = ArrayList<IAction>()

        for(noble in game.nobles) {
            if(user.canTake(noble)) {
                result.add(ActionFactory.noble(noble))
            }
        }

        return result
    }

}