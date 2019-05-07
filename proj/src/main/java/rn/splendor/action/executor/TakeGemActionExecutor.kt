package rn.splendor.action.executor

import rn.splendor.action.IAction
import rn.splendor.action.TakeGemAction
import rn.splendor.solver.State

class TakeGemActionExecutor : IActionExecutor {
    override fun execute(state: State, action: IAction): State {
        val newState = state.next(action)
        executeImpl(newState, action as TakeGemAction)
        return newState
    }

    private fun executeImpl(state: State, action: TakeGemAction) {
        val table = state.table
        table.bank.minus(action.bank)
        table.user.plus(action.bank)
    }
}