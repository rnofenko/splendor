package rn.splendor.action.executor

import rn.splendor.action.IAction
import rn.splendor.action.NobleAction
import rn.splendor.solver.State
import rn.splendor.tool.AppException

class NobleActionExecutor : IActionExecutor {
    override fun execute(state: State, action: IAction): State {
        val newState = state.next(action, true)
        executeImpl(newState, action as NobleAction)
        return newState
    }
    private fun executeImpl(state: State, action: NobleAction) {
        val noble = action.noble
        val user = state.user
        if(!user.canTake(noble)) {
            throw AppException("Not enough permanentGems")
        }

        user.addPoints(noble.points)
        state.game.removeNoble(noble)
    }
}