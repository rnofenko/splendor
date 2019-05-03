package rn.splendor.action

import rn.splendor.solver.State

class ActionExecutor : IActionExecutor {
    override fun execute(initialState: State, action: IAction): State {
        val state = initialState.next(action)

        if(action.type == ActionType.TakeGem) {
            return takeGem(state, action as TakeGemAction)
        }

        return state
    }

    private fun takeGem(state: State, action: TakeGemAction): State {
        val table = state.table
        table.bank.minus(action.bank)
        table.user.plus(action.bank)

        return state
    }
}