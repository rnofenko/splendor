package rn.splendor.action.executor

import rn.splendor.action.IAction
import rn.splendor.action.RedeemCardAction
import rn.splendor.solver.State

class RedeemCardActionExecutor : IActionExecutor {
    private val buyCardProcedure = BuyCardProcedure()

    override fun execute(state: State, action: IAction): State {
        val newState = state.next(action)
        executeImpl(newState, action as RedeemCardAction)
        return newState
    }

    private fun executeImpl(state: State, action: RedeemCardAction) {
        val game = state.game
        val user = state.user
        val card = action.card

        buyCardProcedure.execute(game, state.user, card)

        user.redeem(card)
    }
}