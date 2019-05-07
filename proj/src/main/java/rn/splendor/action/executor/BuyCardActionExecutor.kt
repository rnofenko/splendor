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
        val user = table.user
        val userBank = user.bank
        val card = action.card

        if(userBank.less(card.cost)) {
            throw AppException("Not enough gems")
        }

        user.addPoints(card)
        user.bank.minus(card.cost)

        val newCard = table.magazine.pop(card.level)
        deck.replace(card, newCard)
    }
}