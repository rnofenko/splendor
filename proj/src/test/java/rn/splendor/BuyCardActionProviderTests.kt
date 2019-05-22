package rn.splendor

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import rn.splendor.action.provider.BuyCardActionProvider
import rn.splendor.card.Gc
import rn.splendor.entity.Gem
import rn.splendor.entity.User
import kotlin.test.assertEquals

class BuyCardActionProviderTests {

    private lateinit var provider: BuyCardActionProvider

    @Test
    fun provider_should_use_gold_and_gems_together() {
        //prepare
        val table = Tester.table(Gc.W0_W3UB, Gc.W0_U2G2B)
        val user = User().plus(Gem.W, 3).plusGold().plusGold()

        //test
        val actions = provider.get(table, user)

        //check
        assertEquals(1, actions.size)
    }

    @Test
    fun provider_should_return_two_actions_when_user_bank_has_a_lot() {
        //prepare
        val table = Tester.table(Gc.W0_W3UB, Gc.W0_U2G2B)
        val user = User().plus(Gem.W, 3).plus(Gem.U, 2).plus(Gem.G, 2).plus(Gem.B)

        //test
        val actions = provider.get(table, user)

        //check
        assertEquals(2, actions.size)
    }

    @Test
    fun provider_should_return_one_action_when_user_bank_has_only_for_one_card() {
        //prepare
        val table = Tester.table(Gc.W0_W3UB, Gc.W0_U2G2B)
        val user = User().plus(Gem.W, 3).plus(Gem.U).plus(Gem.B)

        //test
        val actions = provider.get(table, user)

        //check
        assertEquals(1, actions.size)
    }

    @Test
    fun provider_should_return_zero_actions_when_user_bank_is_empty() {
        //prepare
        val table = Tester.table(Gc.W0_W3UB)

        //test
        val actions = provider.get(table, User())

        //check
        assertEquals(0, actions.size)
    }

    @BeforeEach
    fun init() {
        provider = BuyCardActionProvider()
    }
}