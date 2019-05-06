package rn.splendor

import org.junit.jupiter.api.Test
import rn.splendor.action.BuyCardActionProvider
import rn.splendor.card.DefinedCardMagazine

class BuyCardActionProviderTests {

    @Test
    fun should_be_zero_actions_when_user_bank_is_empty() {
        val provider = BuyCardActionProvider()

//        var magazine = DefinedCardMagazine()
//        val t = TableFactory().create(magazine)
//        provider.get()
    }
}