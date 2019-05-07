package rn.splendor.action.executor

import rn.splendor.action.*
import rn.splendor.solver.State
import rn.splendor.tool.AppException

class ActionExecutor : IActionExecutor {
    private val map = mapOf(
            ActionType.TakeGem to TakeGemActionExecutor(),
            ActionType.BuyCard to BuyCardActionExecutor())

    override fun execute(state: State, action: IAction): State {
        val executor = map[action.type] ?: throw AppException("No action executor")
        return executor.execute(state, action)
    }
}