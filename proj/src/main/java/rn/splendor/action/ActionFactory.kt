package rn.splendor.action

import rn.splendor.entity.GemBank
import rn.splendor.card.Card

class ActionFactory {
    companion object {
        fun takeGem(bank: GemBank) : IAction {
            return TakeGemAction(bank)
        }

        fun buyCard(card: Card) : IAction {
            return BuyCardAction(card)
        }
    }
}