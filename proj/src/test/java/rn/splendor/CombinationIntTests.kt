package rn.splendor

import org.junit.jupiter.api.Test
import rn.splendor.tool.CombinationInt
import kotlin.test.assertEquals

class CombinationIntTests {
    @Test
    fun should_be_3_when_2_out_of_3() {
        val comb = CombinationInt()
        val res = comb.build(2, 3)
        assertEquals(3, res.size)
        //01 02 12
    }

    @Test
    fun should_be_6_when_2_out_of_4() {
        val comb = CombinationInt()
        val res = comb.build(2, 4)
        assertEquals(6, res.size)
        //01 02 03 12 13 23
    }

    @Test
    fun should_be_1_when_4_out_of_4() {
        val comb = CombinationInt()
        val res = comb.build(4, 4)
        assertEquals(1, res.size)
        //0123
    }
}