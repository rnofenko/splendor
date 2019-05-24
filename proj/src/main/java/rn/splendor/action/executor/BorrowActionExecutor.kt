package rn.splendor.action.executor

import rn.splendor.action.BorrowAction
import rn.splendor.action.IAction
import rn.splendor.card.CardSet
import rn.splendor.solver.State
import rn.splendor.tool.AppException

class BorrowActionExecutor : IActionExecutor {
    override fun execute(state: State, action: IAction): State {
        val newState = state.next(action)
        executeImpl(newState, action as BorrowAction)
        return newState
    }

    private fun executeImpl(state: State, action: BorrowAction) {
        val game = state.game
        val table = game.table
        val user = state.user
        val card = action.card

        if(!user.hasOneSpace) {
            throw AppException("Not enough space")
        }

        if(!user.canBorrow()) {
            throw AppException("Reach limit of borrows cards")
        }

        user.plusGold()
        game.takeGold()

        user.borrow(card)
        val newCard = game.deck.pop(card.level)
        table.replace(card, newCard)
    }
}