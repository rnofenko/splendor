package rn.splendor

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import rn.splendor.action.provider.BorrowActionProvider
import rn.splendor.card.Gc
import rn.splendor.entity.User
import rn.splendor.util.Tester
import kotlin.test.assertEquals

class BorrowActionProviderTests {
    private lateinit var provider: BorrowActionProvider

    @Test
    fun provider_should_not_allow_to_borrow_when_user_has_3_borrowed_cards() {
        //prepare
        val game = Tester.game()
        val user = User().borrow(Gc.X0).borrow(Gc.X0)

        //test
        var actions = provider.get(game, user)

        //pre check
        assertEquals(15, actions.size)

        //prepare
        user.borrow(Gc.X1)

        //test
        actions = provider.get(game, user)

        //check
        assertEquals(0, actions.size)
    }

    @BeforeEach
    fun init() {
        provider = BorrowActionProvider()
    }
}