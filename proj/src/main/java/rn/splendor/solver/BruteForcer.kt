package rn.splendor.solver

import org.slf4j.LoggerFactory
import rn.splendor.action.executor.ActionExecutor
import rn.splendor.action.executor.IActionExecutor
import rn.splendor.action.provider.UnitedActionProvider
import rn.splendor.print.StatePrinter
import rn.splendor.entity.Table

class BruteForcer {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private var counter = 0
    private val actionExecutor: IActionExecutor = ActionExecutor()
    private val printer = StatePrinter()
    private val actionProvider = UnitedActionProvider()
    private val winPoints = 15;

    fun start(table: Table) {
        val root = State(table)
        printer.print(root)
        next(root)
    }

    private fun next(state: State) {
        counter++
        val actions = actionProvider.get(state.table, state.user)
        if(actions.isEmpty()) {
            log.error("no actions")
        }

        log.info("$counter. StepNo=${state.stepNo} actions count=${actions.size} ")
//        printer.print(state)
        for(action in actions) {
            val newState = actionExecutor.execute(state, action)
//            printer.print(newState)
            next(newState)
        }
    }
}