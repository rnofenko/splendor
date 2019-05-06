package rn.splendor.solver

import org.slf4j.LoggerFactory
import rn.splendor.action.*
import rn.splendor.print.StatePrinter
import rn.splendor.entity.Table

class BruteForcer {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private var counter = 0
    private val actionExecutor: IActionExecutor = ActionExecutor()
    private val printer = StatePrinter()
    private val takeGemActionProvider = TakeGemActionProvider()

    fun start(table: Table) {
        val root = State(table)
        printer.print(root)
        next(root)
    }

    private fun next(state: State) {
        counter++
        val actions = getAvailableActions(state.table)
        if(actions.isEmpty()) {
            log.error("no actions")
        }

        log.info("$counter. StepNo=${state.stepNo} actions count=${actions.size} ")
        printer.print(state)
        for(action in actions) {
            val newState = actionExecutor.execute(state, action)
            printer.print(newState)
            next(newState)
        }
    }

    private fun getAvailableActions(table: Table): List<IAction> {
        val actions = ArrayList<IAction>()
        actions.addAll(takeGemActionProvider.get(table))

        return actions
    }
}