package rn.splendor.solver

import rn.splendor.action.IAction
import rn.splendor.entity.Table

class State {
    val table: Table
    val stepNo: Int
    val history: List<IAction>

    constructor(table: Table, stepNo: Int, history: List<IAction>) {
        this.table = table
        this.stepNo = stepNo
        this.history = history
    }

    constructor(table: Table) : this(table, 0, ArrayList())

    fun next(action: IAction): State {
        val newHistory = ArrayList(history)
        newHistory.add(action)
        return State(table.clone(), stepNo + 1, newHistory)
    }
}