package rn.splendor.action.provider

import rn.splendor.Choices
import rn.splendor.action.ActionFactory
import rn.splendor.action.IAction
import rn.splendor.action.IActionProvider
import rn.splendor.entity.Bank
import rn.splendor.entity.Table

class TakeGemActionProvider : IActionProvider {

    override fun get(table: Table): List<IAction> {
        val gems = getAvailableGemSelections(table)

        return gems
                .filter { table.bank.equalOrMore(it) }
                .map { ActionFactory.takeGem(it) }
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