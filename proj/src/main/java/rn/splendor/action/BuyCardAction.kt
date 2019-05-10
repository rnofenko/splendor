package rn.splendor.action

import rn.splendor.card.Card

class BuyCardAction(val card: Card) : IAction {
    override val type: ActionType
        get() = ActionType.BuyCard

    override fun toString(): String {
        return "BUY $card"
    }
}