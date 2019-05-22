package rn.splendor

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import rn.splendor.action.provider.TakeGemActionProvider
import rn.splendor.entity.Gem
import rn.splendor.entity.User
import kotlin.test.assertEquals

class TakeGemActionProviderTests {

    private lateinit var provider: TakeGemActionProvider

    @Test
    fun provider_should_return_empty_lists_when_user_has_8_gems_and_1_gold() {
        //prepare
        val game = Tester.game()
        val user = User().plus(Gem.W, 5).plus(Gem.U, 3).plusGold()

        //test
        val actions = provider.get(game, user)

        //check
        assertEquals(0, actions.size)
    }

    @BeforeEach
    fun init() {
        provider = TakeGemActionProvider()
    }
}