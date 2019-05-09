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
        val table = state.table
        val deck = table.deck
        val user = state.user
        val card = action.card

        if(user.allGems.less(card.cost)) {
            throw AppException("Not enough gems")
        }

        user.addPoints(card)
        user.minus(card.cost)
        user.plusPermanent(card.reward)

        table.bank.plus(card.cost)

        val newCard = table.magazine.pop(card.level)
        deck.replace(card, newCard)
    }
}