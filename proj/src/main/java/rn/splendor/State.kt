package rn.splendor

class State {
    val table: Table

    constructor(table: Table) {
        this.table = table
    }

    fun clone(): State {
        return State(table.clone())
    }
}