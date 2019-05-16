package rn.splendor.action

import rn.splendor.card.Noble

class NobleAction(val noble: Noble) : IAction {
    override val type: ActionType
        get() = ActionType.Noble
}