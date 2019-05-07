package rn.splendor.action

import rn.splendor.entity.Bank

class TakeGemAction(val bank: Bank) : IAction {
    override val type: ActionType
        get() = ActionType.TakeGem
}