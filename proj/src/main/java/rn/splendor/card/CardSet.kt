package rn.splendor.card

import rn.splendor.entity.*
import java.util.*

class CardSet {
    companion object {
        const val LEVEL_SIZE = 4

        val allLevel0: List<Card> = Gc.level0

        private val l1 = CardLevel.L1
        val allLevel1 : List<Card> = Arrays.asList(
                Card(Gem.W, 1, GemBank.w(2, 3, 0, 3), l1),
                Card(Gem.W, 1, GemBank.g(3, 2, 2), l1),
                Card(Gem.W, 2, GemBank.r(5, 3), l1),
                Card(Gem.W, 3, GemBank.w(6), l1),

                Card(Gem.U, 1, GemBank.u(2, 2, 3), l1),
                Card(Gem.U, 1, GemBank.u(2, 3, 0, 3), l1),
                Card(Gem.U, 2, GemBank.w(2, 0, 0, 1, 4), l1),
                Card(Gem.U, 2, GemBank.w(5, 3), l1),
                Card(Gem.U, 2, GemBank.u(5), l1),
                Card(Gem.U, 3, GemBank.u(6), l1),

                Card(Gem.G, 1, GemBank.w(2, 3, 0, 0, 2), l1),
                Card(Gem.G, 1, GemBank.w(3, 0, 2, 3), l1),
                Card(Gem.G, 2, GemBank.w(4, 2, 0, 0, 1), l1),
                Card(Gem.G, 2, GemBank.w(4, 2, 0, 0, 1), l1),
                Card(Gem.G, 2, GemBank.u(5, 3), l1),
                Card(Gem.G, 2, GemBank.g(5), l1),
                Card(Gem.G, 3, GemBank.g(6), l1),

                Card(Gem.R, 1, GemBank.w(2, 0, 0, 2, 3), l1),
                Card(Gem.R, 1, GemBank.u(3, 0, 2, 3), l1),
                Card(Gem.R, 2, GemBank.w(1, 4, 2), l1),
                Card(Gem.R, 2, GemBank.w(3, 0, 0, 0, 5), l1),

                Card(Gem.B, 1, GemBank.w(3, 2, 2), l1),
                Card(Gem.B, 2, GemBank.w(5), l1),
                Card(Gem.B, 2, GemBank.u(1, 4, 2), l1),
                Card(Gem.B, 2, GemBank.g(5, 3), l1),
                Card(Gem.B, 3, GemBank.b(6), l1)
        )

        private val l2 = CardLevel.L2
        val allLevel2 : List<Card> = Arrays.asList(
                Card(Gem.W, 3, GemBank.u(3, 3, 5, 3), l2),
                Card(Gem.W, 4, GemBank.w(3, 0, 0, 3, 6), l2),
                Card(Gem.W, 4, GemBank.b(7), l2),
                Card(Gem.W, 5, GemBank.w(3, 0, 0, 0, 7), l2),

                Card(Gem.U, 4, GemBank.w(7), l2),
                Card(Gem.U, 5, GemBank.w(2, 3, 0, 3), l2),
                Card(Gem.U, 5, GemBank.w(7, 3), l2),

                Card(Gem.G, 3, GemBank.w(5, 3, 0, 3, 3), l2),
                Card(Gem.G, 4, GemBank.w(3, 6, 3), l2),
                Card(Gem.G, 4, GemBank.u(7), l2),

                Card(Gem.R, 3, GemBank.w(3, 5, 3, 0, 3), l2),
                Card(Gem.R, 4, GemBank.g(7), l2),
                Card(Gem.R, 5, GemBank.g(7, 3), l2),

                Card(Gem.B, 3, GemBank.w(3, 3, 5, 3), l2),
                Card(Gem.B, 4, GemBank.g(3, 6, 3), l2),
                Card(Gem.B, 4, GemBank.b(7), l2),
                Card(Gem.B, 4, GemBank.r(7), l2),
                Card(Gem.B, 5, GemBank.r(7, 3), l2)
        )
    }
}

