package rn.splendor.card

import rn.splendor.entity.GemBank
import rn.splendor.entity.Card
import rn.splendor.entity.Gem
import java.util.*

object Gc {
    private val W0_R2B = Card(Gem.W, 0, GemBank.r(2, 1), CardLevel.L0)
    private val W0_UGRB = Card(Gem.W, 0, GemBank.u(1, 1, 1, 1), CardLevel.L0)
    private val W0_UG2RB = Card(Gem.W, 0, GemBank.u(1, 2, 1, 1), CardLevel.L0)
    private val W0_U2B2 = Card(Gem.W, 0, GemBank.u(2, 0, 0, 2), CardLevel.L0)
    val W0_U2G2B = Card(Gem.W, 0, GemBank.u(2, 2, 0, 1), CardLevel.L0)
    private val W0_U3 = Card(Gem.W, 0, GemBank.u(3), CardLevel.L0)
    val W0_W3UB = Card(Gem.W, 0, GemBank.w(3, 1, 0, 0, 1), CardLevel.L0)
    val W1_G4 = Card(Gem.W, 1, GemBank.g(4), CardLevel.L0)

    private val U0_WGRB = Card(Gem.U, 0, GemBank.w(1, 0, 1, 1, 1), CardLevel.L0)
    private val U0_WB2 = Card(Gem.U, 0, GemBank.w(1, 0, 0, 0, 2), CardLevel.L0)
    private val U0_B3 = Card(Gem.U, 0, GemBank.b(3), CardLevel.L0)
    private val U0_G2B2 = Card(Gem.U, 0, GemBank.g(2, 0, 2), CardLevel.L0)
    private val U0_WGR2B = Card(Gem.U, 0, GemBank.w(1, 0, 1, 2, 1), CardLevel.L0)
    private val U0_WG2R2 = Card(Gem.U, 0, GemBank.w(1, 0, 2, 2), CardLevel.L0)
    private val U0_UG3R = Card(Gem.U, 0, GemBank.u(1, 3, 1), CardLevel.L0)
    private val U1_R4 = Card(Gem.U, 1, GemBank.r(4), CardLevel.L0)

    private val G0_W2B = Card(Gem.G, 0, GemBank.w(2, 1), CardLevel.L0)
    private val G0_R3 = Card(Gem.G, 0, GemBank.r(3), CardLevel.L0)
    private val G0_WURB = Card(Gem.G, 0, GemBank.w(1, 1, 0, 1, 1), CardLevel.L0)
    private val G0_WURB2 = Card(Gem.G, 0, GemBank.w(1, 1, 0, 1, 2), CardLevel.L0)
    private val G0_UR2B2 = Card(Gem.G, 0, GemBank.u(1, 0, 2, 2), CardLevel.L0)
    private val G0_U2R2 = Card(Gem.G, 0, GemBank.u(2, 0, 2), CardLevel.L0)
    private val G0_WU3G = Card(Gem.G, 0, GemBank.w(1, 3, 1), CardLevel.L0)
    private val G1_B4 = Card(Gem.G, 1, GemBank.b(4), CardLevel.L0)

    private val R0_U2G = Card(Gem.R, 0, GemBank.u(2, 1), CardLevel.L0)
    private val R0_WGRB = Card(Gem.R, 0, GemBank.w(1, 0, 1, 1, 1), CardLevel.L0)
    private val R0_W2GRB = Card(Gem.R, 0, GemBank.w(2, 0, 1, 1, 1), CardLevel.L0)
    private val R0_W2R2 = Card(Gem.R, 0, GemBank.w(2, 0, 0, 2), CardLevel.L0)
    private val R0_W2GB2 = Card(Gem.R, 0, GemBank.w(2, 0, 1, 0, 2), CardLevel.L0)
    private val R0_WRB3 = Card(Gem.R, 0, GemBank.w(1, 0, 0, 1, 3), CardLevel.L0)
    private val R0_W3 = Card(Gem.R, 0, GemBank.w(3), CardLevel.L0)
    private val R1_W4 = Card(Gem.R, 1, GemBank.w(4), CardLevel.L0)

    private val B0_G2R = Card(Gem.B, 0, GemBank.g(2, 1), CardLevel.L0)
    private val B0_WUGR = Card(Gem.B, 0, GemBank.w(1, 1, 1, 1), CardLevel.L0)
    private val B0_WU2GR = Card(Gem.B, 0, GemBank.w(1, 2, 1, 1), CardLevel.L0)
    private val B0_W2G2 = Card(Gem.B, 0, GemBank.w(2, 0, 2), CardLevel.L0)
    private val B0_W2B2R = Card(Gem.B, 0, GemBank.w(2, 2, 0, 1), CardLevel.L0)
    private val B0_GR3B = Card(Gem.B, 0, GemBank.g(1, 3, 1), CardLevel.L0)
    private val B0_G3 = Card(Gem.B, 0, GemBank.g(3), CardLevel.L0)
    private val B1_U4 = Card(Gem.B, 1, GemBank.u(4), CardLevel.L0)

    val X0 = Card(Gem.W, 0, GemBank.w(9), CardLevel.L0)
    val X1 = Card(Gem.W, 0, GemBank.w(9), CardLevel.L1)
    val X2 = Card(Gem.W, 0, GemBank.w(9), CardLevel.L2)

    val level0 = Arrays.asList(
            W0_R2B, W0_UGRB, W0_UG2RB, W0_U2B2, W0_U2G2B, W0_U3, W0_W3UB, W1_G4,
            U0_WGRB, U0_WB2, U0_B3, U0_G2B2, U0_WGR2B, U0_WG2R2, U0_UG3R, U1_R4,
            G0_W2B, G0_R3, G0_WURB, G0_WURB2, G0_UR2B2, G0_U2R2, G0_WU3G, G1_B4,
            R0_U2G, R0_WGRB, R0_W2GRB, R0_W2R2, R0_W2GB2, R0_WRB3, R0_W3, R1_W4,
            B0_G2R, B0_WUGR, B0_WU2GR, B0_W2G2, B0_W2B2R, B0_GR3B, B0_G3, B1_U4
    )
}