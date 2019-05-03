package rn.splendor.action

import rn.splendor.solver.State

interface IActionExecutor {
    fun execute(state: State, action: IAction): State
}