package rn.splendor

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import rn.splendor.action.ActionFactory
import rn.splendor.action.executor.NobleActionExecutor
import rn.splendor.card.Gc
import rn.splendor.entity.Gem
import rn.splendor.entity.User
import rn.splendor.solver.State
import rn.splendor.tool.AppException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NobleActionExecutorTests {
    private lateinit var executor: NobleActionExecutor

    @Test
    fun executor_should_remove_noble_when_user_has_enough_gems() {
        //prepare
        val noble = Gc.N_4_WB
        val table = Tester.table(noble)
        val user = User().plusPermanent(Gem.W, 4).plusPermanent(Gem.B, 4)
        val initialState = State(table, user)
        val action = ActionFactory.noble(noble)
        assertEquals(1, initialState.game.nobles.size)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(0, newState.game.nobles.size)
    }

    @Test
    fun executor_should_keep_the_same_stepNo_for_noble() {
        //prepare
        val noble = Gc.N_4_WB
        val table = Tester.table(noble)
        val user = User().plusPermanent(Gem.W, 4).plusPermanent(Gem.B, 4)
        val initialState = State(table, user)
        val action = ActionFactory.noble(noble)
        assertEquals(0, initialState.stepNo)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(0, newState.stepNo)
    }

    @Test
    fun executor_should_increase_points_when_user_has_enough_gems() {
        //prepare
        val noble = Gc.N_4_WB
        val table = Tester.table(noble)
        val user = User().plusPermanent(Gem.W, 4).plusPermanent(Gem.B, 4)
        val initialState = State(table, user)
        val action = ActionFactory.noble(noble)

        //test
        val newState = executor.execute(initialState, action)

        //check
        assertEquals(4, newState.user.points)
    }

    @Test
    fun executor_should_ignore_temp_gems() {
        //prepare
        val noble = Gc.N_4_WB
        val table = Tester.table(noble)
        val user = User().plus(Gem.W, 4).plusPermanent(Gem.W).plus(Gem.B, 4).plusPermanent(Gem.B)
        val initialState = State(table, user)
        val action = ActionFactory.noble(noble)

        //test
        assertFailsWith(AppException::class) {
            executor.execute(initialState, action)
        }
    }

    @BeforeEach
    fun init() {
        executor = NobleActionExecutor()
    }
}