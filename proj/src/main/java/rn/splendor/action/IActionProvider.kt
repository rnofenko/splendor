package rn.splendor.action

import rn.splendor.entity.Table

interface IActionProvider {
    fun get(table: Table): List<IAction>
}