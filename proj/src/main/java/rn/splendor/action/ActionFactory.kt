package rn.splendor.action

import rn.splendor.entity.Bank

class ActionFactory {
    companion object {
        fun createTakeGem(bank: Bank) : IAction {
            return TakeGemAction(ActionType.TakeGem, bank)
        }
    }
}