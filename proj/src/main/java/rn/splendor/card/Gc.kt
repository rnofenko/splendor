package rn.splendor.card

import rn.splendor.entity.Bank
import rn.splendor.entity.Card
import rn.splendor.entity.Gem

object Gc {
    //level 0
    val W0_W3UB = Card(Gem.W, 0, Bank.w(3, 1, 0, 0, 1), CardLevel.L0)
    val W0_U = Card(Gem.W, 0, Bank.u(1, 2, 1, 1), CardLevel.L0)
    val W0_U2G2B = Card(Gem.W, 0, Bank.u(2, 2, 0, 1), CardLevel.L0)
    val W1_G4 = Card(Gem.W, 1, Bank.g(4), CardLevel.L0)


    val X0 = Card(Gem.W, 0, Bank.w(9), CardLevel.L0)
    val X1 = Card(Gem.W, 0, Bank.w(9), CardLevel.L1)
    val X2 = Card(Gem.W, 0, Bank.w(9), CardLevel.L2)
}