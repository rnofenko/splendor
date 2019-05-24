package rn.splendor.action

import rn.splendor.card.Card

class RedeemCardAction(val card: Card) : IAction {
    override val type: ActionType
        get() = ActionType.Redeem

    override fun toString(): String {
        return "REDEEM $card"
    }
}