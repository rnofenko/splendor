package rn.splendor.action.executor

import rn.splendor.action.IAction
import rn.splendor.solver.State

interface IActionExecutor {
    fun execute(state: State, action: IAction): State
}