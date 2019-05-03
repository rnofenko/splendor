package rn.splendor.solver

import org.slf4j.LoggerFactory
import rn.splendor.Choices
import rn.splendor.print.StatePrinter
import rn.splendor.action.ActionExecutor
import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionExecutor
import rn.splendor.entity.Bank
import rn.splendor.entity.Table

class BruteForcer {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private var counter = 0
    private var actionExecutor: IActionExecutor = ActionExecutor()

    fun start(table: Table) {
        val root = State(table, 0)
        StatePrinter().print(root)
        next(root)
    }

    private fun next(state: State) {
        counter++
        val actions = getAvailableActions(state.table)
        log.info("$counter. StepNo=${state.stepNo} actions count=${actions.size} ")
        for(action in actions) {
            val newState = actionExecutor.execute(state, action)
            next(newState)
        }
    }

    private fun getAvailableActions(table: Table): List<IAction> {
        val actions = ArrayList<IAction>()
        actions.addAll(getAvailableGemActions(table))

        return actions
    }

    private fun getAvailableGemActions(table: Table): List<IAction> {
        val gems = getAvailableGemSelections(table)

        return gems
                .filter { table.bank.equalOrMore(it) }
                .map { ActionFactory.createTakeGem(it) }
    }

    private fun getAvailableGemSelections(table: Table): List<Bank> {
        val user = table.user

        if (table.bank.total >= 3 && user.hasThreeSpaces) {
            return Choices.gem3AndDuplicate
        }

        if (table.bank.total >= 2 &&user.hasTwoSpaces) {
            return Choices.gem2
        }

        return emptyList()
    }
}