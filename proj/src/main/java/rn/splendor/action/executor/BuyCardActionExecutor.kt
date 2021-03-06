package rn.splendor.action.executor

import rn.splendor.action.BuyCardAction
import rn.splendor.action.IAction
import rn.splendor.solver.State

class BuyCardActionExecutor : IActionExecutor {
    private val buyCardProcedure = BuyCardProcedure()

    override fun execute(state: State, action: IAction): State {
        val newState = state.next(action)
        executeImpl(newState, action as BuyCardAction)
        return newState
    }

    private fun executeImpl(state: State, action: BuyCardAction) {
        val game = state.game
        val table = game.table
        val card = action.card

        buyCardProcedure.execute(game, state.user, card)

        val newCard = game.deck.pop(card.level)
        table.replace(card, newCard)
    }
}

