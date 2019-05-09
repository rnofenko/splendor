package rn.splendor.solver

import rn.splendor.action.IAction
import rn.splendor.entity.Table
import rn.splendor.entity.User

class State {
    val user: User
    val table: Table
    val stepNo: Int
    val history: List<IAction>

    constructor(table: Table, user: User, stepNo: Int, history: List<IAction>) {
        this.table = table
        this.stepNo = stepNo
        this.history = history
        this.user = user
    }

    constructor(table: Table, user: User) : this(table, user, 0, ArrayList())

    fun next(action: IAction): State {
        val newHistory = ArrayList(history)
        newHistory.add(action)
        return State(table.clone(), user.clone(), stepNo + 1, newHistory)
    }
}