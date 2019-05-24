package rn.splendor.action

import rn.splendor.entity.GemBank
import rn.splendor.card.Card
import rn.splendor.card.Noble

class ActionFactory {
    companion object {
        fun takeGem(bank: GemBank) : IAction {
            return TakeGemAction(bank)
        }

        fun buyCard(card: Card) : IAction {
            return BuyCardAction(card)
        }

        fun redeemCard(card: Card) : IAction {
            return RedeemCardAction(card)
        }

        fun noble(noble: Noble) : IAction {
            return NobleAction(noble)
        }

        fun borrow(card: Card): IAction {
            return BorrowAction(card)
        }
    }
}