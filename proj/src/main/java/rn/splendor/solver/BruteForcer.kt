package rn.splendor.solver

import rn.splendor.Choices
import rn.splendor.StatePrinter
import rn.splendor.action.ActionExecutor
import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionExecutor
import rn.splendor.entity.Bank
import rn.splendor.entity.Table
import rn.splendor.entity.User

class BruteForcer {
    private var actionExecutor: IActionExecutor = ActionExecutor()

    fun start(table: Table) {
        val root = State(table)
        StatePrinter().print(root)
        next(root)
    }

    private fun next(state: State) {
        val actions = getAvailableActions(state.table)
        for(action in actions) {
            val newState = apply(state, action)
            next(newState)
        }
    }

    private fun apply(state: State, action: IAction): State {
        val newState = state.clone()
        actionExecutor.execute(newState, action)
        return newState
    }

    private fun getAvailableActions(table: Table): List<IAction> {
        val actions = ArrayList<IAction>()
        actions.addAll(getAvailableGemActions(table))

        return actions
    }

    private fun getAvailableGemActions(table: Table): List<IAction> {
        val gems = getAvailableGemSelections(table.user)

        return gems
                .filter { table.bank.equalOrMore(it) }
                .map { ActionFactory.createTakeGem(it) }
    }

    private fun getAvailableGemSelections(user: User): List<Bank> {
        if(user.hasThreeSpaces) {
            return Choices.gem3AndDuplicate
        }

        if(user.hasTwoSpaces) {
            return Choices.gem2
        }

        return emptyList()
    }
}