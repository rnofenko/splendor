package rn.splendor.solver

import rn.splendor.entity.Table

class State {
    val table: Table

    constructor(table: Table) {
        this.table = table
    }

    fun clone(): State {
        return State(table.clone())
    }
}