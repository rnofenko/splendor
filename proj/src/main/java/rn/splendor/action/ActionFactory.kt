package rn.splendor.action

import rn.splendor.entity.Bank
import rn.splendor.entity.Card

class ActionFactory {
    companion object {
        fun takeGem(bank: Bank) : IAction {
            return TakeGemAction(bank)
        }

        fun buyCard(card: Card) : IAction {
            return BuyCardAction(card)
        }
    }
}