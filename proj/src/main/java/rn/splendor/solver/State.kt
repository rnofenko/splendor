package rn.splendor.solver

import rn.splendor.entity.Table

class State {
    val table: Table
    val stepNo: Int

    constructor(table: Table, stepNo: Int) {
        this.table = table
        this.stepNo = stepNo
    }

    fun next(): State {
        return State(table.clone(), stepNo + 1)
    }
}