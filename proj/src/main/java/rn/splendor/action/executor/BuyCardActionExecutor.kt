package rn.splendor.action.executor

import rn.splendor.action.BuyCardAction
import rn.splendor.action.IAction
import rn.splendor.solver.State
import rn.splendor.tool.AppException

class BuyCardActionExecutor : IActionExecutor {
    override fun execute(state: State, action: IAction): State {
        val newState = state.next(action)
        executeImpl(newState, action as BuyCardAction)
        return newState
    }

    private fun executeImpl(state: State, action: BuyCardAction) {
        val game = state.game
        val table = game.table
        val user = state.user
        val card = action.card

        if(user.allGems.less(card.cost)) {
            throw AppException("Not enough gems")
        }

        val finalCost = card.cost.calcSafeMinus(user.permanentGems)

        user.addPoints(card.points)
        user.minus(finalCost)
        user.plusPermanent(card.reward)

        game.bank.plus(finalCost)

        val newCard = game.deck.pop(card.level)
        table.replace(card, newCard)
    }
}