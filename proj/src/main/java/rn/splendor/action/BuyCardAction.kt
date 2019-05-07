package rn.splendor.action

import rn.splendor.entity.Card

class BuyCardAction(val card: Card) : IAction {
    override val type: ActionType
        get() = ActionType.BuyCard
}