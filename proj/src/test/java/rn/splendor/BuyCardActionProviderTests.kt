package rn.splendor

import org.junit.jupiter.api.Test
import rn.splendor.entity.CARD

class BuyCardActionProviderTests {

    @Test
    fun should_be_zero_actions_when_user_bank_is_empty() {
        val magazine = Tester.magazine(CARD.W0_W3)
        val table = TableFactory().create(magazine)
    }
}