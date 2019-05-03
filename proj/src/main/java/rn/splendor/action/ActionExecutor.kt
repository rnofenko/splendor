package rn.splendor.action

import rn.splendor.solver.State

class ActionExecutor : IActionExecutor {
    override fun execute(state: State, action: IAction): State {
        if(action.type == ActionType.TakeGem) {
            return takeGem(state, action as TakeGemAction)
        }

        return state
    }

    private fun takeGem(state: State, action: TakeGemAction): State {
        var newState = state.next()
        val table = newState.table
        table.bank.minus(action.bank)
        table.user.plus(action.bank)

        return state
    }
}