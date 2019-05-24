package rn.splendor

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import rn.splendor.action.ActionFactory
import rn.splendor.action.executor.BorrowActionExecutor
import rn.splendor.card.Gc
import rn.splendor.entity.Gem
import rn.splendor.entity.User
import rn.splendor.solver.State
import rn.splendor.tool.AppException
import rn.splendor.util.Tester
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BorrowActionExecutorTests {
    private lateinit var executor: BorrowActionExecutor

    @Test
    fun executor_should_throw_error_when_user_borrows_the_fourth_card() {
        //prepare
        val table = Tester.table(Arrays.asList(Gc.W1_G4, Gc.W0_U3, Gc.U0_B3, Gc.U1_R4))
        val user = User()
        val initialState = State(table, user)

        //test
        var state = executor.execute(initialState, ActionFactory.borrow(Gc.W1_G4))
        state = executor.execute(state, ActionFactory.borrow(Gc.W0_U3))
        state = executor.execute(state, ActionFactory.borrow(Gc.U0_B3))

        assertFailsWith(AppException::class) {
            executor.execute(state, ActionFactory.borrow(Gc.U1_R4))
        }
    }

    @Test
    fun executor_should_throw_error_when_user_bank_is_full_of_temp() {
        //prepare
        val card = Gc.W1_G4
        //val table = Tester.table(Arrays.asList(Gc.W1_G4, Gc.W0_U3, Gc.U0_B3, Gc.U1_R4))
        val table = Tester.table(card)
        val user = User().plus(Gem.W, 10)
        val initialState = State(table, user)
        val action = ActionFactory.borrow(card)

        //test
        assertFailsWith(AppException::class) {
            executor.execute(initialState, action)
        }
    }

    @Test
    fun executor_should_throw_error_when_user_bank_is_full_of_temp_or_gold() {
        //prepare
        val card = Gc.W1_G4
        val table = Tester.table(card)
        val user = User().plus(Gem.W, 9).plusGold()
        val initialState = State(table, user)
        val action = ActionFactory.borrow(card)

        //test
        assertFailsWith(AppException::class) {
            executor.execute(initialState, action)
        }
    }

    @Test
    fun borrow_should_reduce_gold_in_game_bank() {
        val card = Gc.W1_G4

        //prepare
        val table = Tester.table(card)
        val user = User()
        val initialState = State(table, user)
        val action = ActionFactory.borrow(card)
        val initialGold = initialState.game.gold

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(initialGold - 1, newState.game.gold)
    }

    @Test
    fun borrow_should_add_gold_to_user() {
        val card = Gc.W1_G4

        //prepare
        val table = Tester.table(card)
        val user = User()
        val initialState = State(table, user)
        val action = ActionFactory.borrow(card)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(1, newState.user.gold)
    }

    @Test
    fun borrow_should_remove_card_from_table() {
        val card = Gc.W1_G4

        //prepare
        val table = Tester.table(card)
        val user = User()
        val initialState = State(table, user)
        val action = ActionFactory.borrow(card)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(0, newState.game.table.cards.count { it == card })
    }

    @BeforeEach
    fun init() {
        executor = BorrowActionExecutor()
    }
}