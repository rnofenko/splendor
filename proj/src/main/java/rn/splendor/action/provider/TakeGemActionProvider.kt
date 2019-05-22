package rn.splendor.action.provider

import rn.splendor.Choices
import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.GemBank
import rn.splendor.entity.Game
import rn.splendor.entity.User

class TakeGemActionProvider : IActionProvider {

    override fun get(game: Game, user: User): List<IAction> {
        val gems = getAvailableGemSelections(game, user)

        return gems
                .filter { game.bank.equalOrMore(it) }
                .map { ActionFactory.takeGem(it) }
    }

    private fun getAvailableGemSelections(game: Game, user: User): List<GemBank> {
        if (game.bank.total >= 3 && user.hasThreeSpaces) {
            return Choices.gem3AndDuplicate
        }

        if (game.bank.total >= 2 && user.hasTwoSpaces) {
            return Choices.gem2
        }

        return emptyList()
    }
}