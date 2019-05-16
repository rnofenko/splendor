package rn.splendor.action

import rn.splendor.card.Card

class BorrowAction(val card: Card) : IAction {
    override val type: ActionType
        get() = ActionType.Borrow

    override fun toString(): String {
        return "BORROW $card"
    }
}