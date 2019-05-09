package rn.splendor.action

import rn.splendor.entity.Table
import rn.splendor.entity.User

interface IActionProvider {
    fun get(table: Table, user: User): List<IAction>
}