package rn.splendor

import org.junit.jupiter.api.Test
import rn.splendor.entity.Gem
import rn.splendor.entity.GemBank
import rn.splendor.entity.User
import kotlin.test.assertEquals

class UserTests {

    @Test
    fun plusPermanent_should_increase_permanent_and_total() {
        val user = User()

        //test
        user.plusPermanent(Gem.W)

        //check
        assertEquals(1, user.permanentGems.gems[Gem.W.index])
        assertEquals(1, user.allGems.gems[Gem.W.index])
    }

    @Test
    fun minus_should_ignore_permanent_gems() {
        val user = User().plus(Gem.W, 4).plusPermanent(Gem.W)

        //test
        user.minus(GemBank.w(2))

        //check
        assertEquals(1, user.permanentGems.gems[Gem.W.index])
        assertEquals(2, user.tempGems.gems[Gem.W.index], "tempGems")
        assertEquals(3, user.allGems.gems[Gem.W.index])
    }
}