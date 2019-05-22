package rn.splendor

import org.junit.jupiter.api.Test
import rn.splendor.card.Gc
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
        assertEquals(1, Access.getPermanentGems(user).gems[Gem.W.index])
        assertEquals(1, Access.getAllGem(user, Gem.W))
    }

    @Test
    fun minus_should_ignore_permanent_gems() {
        val user = User().plus(Gem.W, 4).plusPermanent(Gem.W)

        //test
        user.minus(GemBank.w(2))

        //check
        assertEquals(1, Access.getPermanentGem(user, Gem.W))
        assertEquals(2, Access.getTempGem(user, Gem.W), "tempGems")
        assertEquals(3, Access.getAllGem(user, Gem.W))
    }

    @Test
    fun clone_should_keep_borrowed() {
        val user = User().add(Gc.W1_G4)

        //test
        val newUser = user.clone()

        //check
        assertEquals(1, newUser.borrowed.size)
    }
}