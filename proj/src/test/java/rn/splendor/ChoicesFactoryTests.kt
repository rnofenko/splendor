package rn.splendor

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChoicesFactoryTests {

    @Test
    fun combination_size_should_be_10_when_2_cards() {
        val factory = ChoicesFactory()
        val res = factory.selectGem2()
        assertEquals(10, res.size)
    }
}