package rn.splendor.action

import rn.splendor.entity.GemBank

class TakeGemAction(val bank: GemBank) : IAction {
    override val type: ActionType
        get() = ActionType.TakeGem

    override fun toString(): String {
        return "TAKE $bank"
    }
}