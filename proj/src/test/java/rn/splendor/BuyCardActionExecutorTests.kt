package rn.splendor

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import rn.splendor.action.ActionFactory
import rn.splendor.action.executor.BuyCardActionExecutor
import rn.splendor.card.Gc
import rn.splendor.entity.Gem
import rn.splendor.entity.User
import rn.splendor.solver.State
import rn.splendor.tool.AppException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BuyCardActionExecutorTests {
    private lateinit var executor: BuyCardActionExecutor

    @Test
    fun executor_should_not_return_to_table_full_cost_when_user_uses_permanent_gems() {
        //prepare
        val table = Tester.table(Gc.W1_G4)
        val user = User().plus(Gem.G, 4).plusPermanent(Gem.G)
        val initialState = State(table, user)
        val action = ActionFactory.buyCard(Gc.W1_G4)

        //test
        val newState = executor.execute(initialState, action)

        //check
        val newTable = newState.game
        assertEquals(7, newTable.bank.gems[Gem.G.index])
    }

    @Test
    fun executor_should_user_permanent_gem_first_when_user_buys_card() {
        //prepare
        val table = Tester.table(Gc.W1_G4)
        val user = User().plus(Gem.G, 4).plusPermanent(Gem.G)
        val initialState = State(table, user)
        val action = ActionFactory.buyCard(Gc.W1_G4)

        //test
        val newState = executor.execute(initialState, action)

        //check
        val newUser = newState.user
        assertEquals(1, newUser.permanentGems.gems[Gem.G.index])
        assertEquals(1, newUser.tempGems.gems[Gem.G.index], "tempGems")
        assertEquals(2, newUser.allGems.gems[Gem.G.index])
    }

    @Test
    fun executor_should_increase_permanent_gem_when_user_buys_card() {
        //prepare
        val table = Tester.table(Gc.W1_G4)
        val user = User().plus(Gem.G, 4)
        val initialState = State(table, user)
        val action = ActionFactory.buyCard(Gc.W1_G4)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(1, newState.user.permanentGems.gems[Gem.W.index])
    }

    @Test
    fun executor_should_return_gems_when_user_buys_card() {
        //prepare
        val table = Tester.table(Gc.W1_G4)
        val user = User().plus(Gem.G, 4)
        val initialState = State(table, user)
        val action = ActionFactory.buyCard(Gc.W1_G4)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(8, newState.game.bank.gems[Gem.G.index])
    }

    @Test
    fun executor_should_throw_error_when_user_bank_is_empty() {
        //prepare
        val table = Tester.table(Gc.W1_G4)
        val user = User()
        val initialState = State(table, user)
        val action = ActionFactory.buyCard(Gc.W1_G4)

        //test
        assertFailsWith(AppException::class) {
            executor.execute(initialState, action)
        }
    }

    @Test
    fun executor_should_increase_points_when_user_bank_has_enough_gems() {
        //prepare
        val table = Tester.table(Gc.W1_G4)
        val initialState = State(table, User().plus(Gem.G, 4))
        val action = ActionFactory.buyCard(Gc.W1_G4)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(1, newState.user.points)
    }

    @Test
    fun executor_should_minus_gems_from_user() {
        //prepare
        val table = Tester.table(Gc.W1_G4)
        val initialState = State(table, User().plus(Gem.G, 4))
        val action = ActionFactory.buyCard(Gc.W1_G4)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(0, newState.user.tempGems.gems[Gem.G.index])
    }

    @Test
    fun executor_should_replace_card_on_table() {
        //prepare
        val table = Tester.table(Gc.W1_G4)
        val initialState = State(table, User().plus(Gem.G, 4))
        val action = ActionFactory.buyCard(Gc.W1_G4)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(0, newState.game.table.cards.count { it == Gc.W1_G4 })
    }

    @BeforeEach
    fun init() {
        executor = BuyCardActionExecutor()
    }
}