package rn.splendor.card

import rn.splendor.entity.*
import java.util.*

class CardSet {
    companion object {
        const val LEVEL_SIZE = 4

        private val l0 = CardLevel.L0
        val allLevel0 : List<Card> = Arrays.asList(
                Gc.W0_W3UB,
                Gc.W0_U,
                Gc.W0_U2G2B,
                Gc.W1_G4,

                Card(Gem.U, 0, Bank.w(1,0,1,2,1), l0),
                Card(Gem.U, 0, Bank.w(1,0,2,2), l0),
                Card(Gem.U, 0, Bank.u(1,3,1), l0),
                Card(Gem.U, 0, Bank.g(2,0,2), l0),
                Card(Gem.U, 0, Bank.b(3), l0),
                Card(Gem.U, 1, Bank.r(4), l0),

                Card(Gem.G, 0, Bank.w(1,1,0,1,1), l0),
                Card(Gem.G, 0, Bank.w(1,1,0,1,2), l0),
                Card(Gem.G, 0, Bank.w(1,3,1), l0),
                Card(Gem.G, 0, Bank.u(1,0,2,2), l0),
                Card(Gem.G, 0, Bank.u(2,0,2), l0),
                Card(Gem.G, 0, Bank.r(3), l0),
                Card(Gem.G, 1, Bank.b(4), l0),

                Card(Gem.R, 0, Bank.w(1,0,0,1,3), l0),
                Card(Gem.R, 0, Bank.w(2,0,0,2), l0),
                Card(Gem.R, 0, Bank.w(2,0,1,0,2), l0),
                Card(Gem.R, 0, Bank.w(3), l0),
                Card(Gem.R, 0, Bank.u(2,1), l0),
                Card(Gem.R, 1, Bank.w(4), l0),

                Card(Gem.B, 0, Bank.w(1,1,1,1), l0),
                Card(Gem.B, 0, Bank.w(1,2,1,1), l0),
                Card(Gem.B, 0, Bank.w(2,0,2), l0),
                Card(Gem.B, 0, Bank.g(1,3,1), l0),
                Card(Gem.B, 0, Bank.g(3), l0),
                Card(Gem.B, 1, Bank.u(4), l0)
        )

        private val l1 = CardLevel.L1
        val allLevel1 : List<Card> = Arrays.asList(
                Card(Gem.W, 1, Bank.w(2,3,0,3), l1),
                Card(Gem.W, 1, Bank.g(3,2,2), l1),
                Card(Gem.W, 2, Bank.r(5,3), l1),
                Card(Gem.W, 3, Bank.w(6), l1),

                Card(Gem.U, 1, Bank.u(2,2,3), l1),
                Card(Gem.U, 1, Bank.u(2,3,0,3), l1),
                Card(Gem.U, 2, Bank.w(2,0,0,1,4), l1),
                Card(Gem.U, 2, Bank.w(5,3), l1),
                Card(Gem.U, 2, Bank.u(5), l1),
                Card(Gem.U, 3, Bank.u(6), l1),

                Card(Gem.G, 1, Bank.w(2,3,0,0,2), l1),
                Card(Gem.G, 1, Bank.w(3,0,2,3), l1),
                Card(Gem.G, 2, Bank.w(4,2,0,0,1), l1),
                Card(Gem.G, 2, Bank.w(4,2,0,0,1), l1),
                Card(Gem.G, 2, Bank.u(5,3), l1),
                Card(Gem.G, 2, Bank.g(5), l1),
                Card(Gem.G, 3, Bank.g(6), l1),

                Card(Gem.R, 1, Bank.w(2,0,0,2,3), l1),
                Card(Gem.R, 1, Bank.u(3,0,2,3), l1),
                Card(Gem.R, 2, Bank.w(1,4,2), l1),
                Card(Gem.R, 2, Bank.w(3,0,0,0,5), l1),

                Card(Gem.B, 1, Bank.w(3,2,2), l1),
                Card(Gem.B, 2, Bank.w(5), l1),
                Card(Gem.B, 2, Bank.u(1,4,2), l1),
                Card(Gem.B, 2, Bank.g(5,3), l1),
                Card(Gem.B, 3, Bank.b(6), l1)
        )

        private val l2 = CardLevel.L2
        val allLevel2 : List<Card> = Arrays.asList(
                Card(Gem.W, 3, Bank.u(3,3,5,3), l2),
                Card(Gem.W, 4, Bank.w(3,0,0,3,6), l2),
                Card(Gem.W, 4, Bank.b(7), l2),
                Card(Gem.W, 5, Bank.w(3,0,0,0,7), l2),

                Card(Gem.U, 4, Bank.w(7), l2),
                Card(Gem.U, 5, Bank.w(2,3,0,3), l2),
                Card(Gem.U, 5, Bank.w(7,3), l2),

                Card(Gem.G, 3, Bank.w(5,3,0,3,3), l2),
                Card(Gem.G, 4, Bank.w(3,6,3), l2),
                Card(Gem.G, 4, Bank.u(7), l2),

                Card(Gem.R, 3, Bank.w(3,5,3,0,3), l2),
                Card(Gem.R, 4, Bank.g(7), l2),
                Card(Gem.R, 5, Bank.g(7,3), l2),

                Card(Gem.B, 3, Bank.w(3,3,5,3), l2),
                Card(Gem.B, 4, Bank.g(3,6,3), l2),
                Card(Gem.B, 4, Bank.b(7), l2),
                Card(Gem.B, 4, Bank.r(7), l2),
                Card(Gem.B, 5, Bank.r(7,3), l2)
        )
    }
}

