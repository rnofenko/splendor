package rn.splendor.card

import rn.splendor.entity.GemBank
import rn.splendor.entity.Gem
import java.util.*

object Gc {
    private val W0_R2B = Card(Gem.W, 0, GemBank.r(2, 1), CardLevel.L0)
    private val W0_UGRB = Card(Gem.W, 0, GemBank.u(1, 1, 1, 1), CardLevel.L0)
    private val W0_UG2RB = Card(Gem.W, 0, GemBank.u(1, 2, 1, 1), CardLevel.L0)
    private val W0_U2B2 = Card(Gem.W, 0, GemBank.u(2, 0, 0, 2), CardLevel.L0)
    val W0_U2G2B = Card(Gem.W, 0, GemBank.u(2, 2, 0, 1), CardLevel.L0)
    val W0_U3 = Card(Gem.W, 0, GemBank.u(3), CardLevel.L0)
    val W0_W3UB = Card(Gem.W, 0, GemBank.w(3, 1, 0, 0, 1), CardLevel.L0)
    val W1_G4 = Card(Gem.W, 1, GemBank.g(4), CardLevel.L0)

    private val U0_WGRB = Card(Gem.U, 0, GemBank.w(1, 0, 1, 1, 1), CardLevel.L0)
    private val U0_WB2 = Card(Gem.U, 0, GemBank.w(1, 0, 0, 0, 2), CardLevel.L0)
    val U0_B3 = Card(Gem.U, 0, GemBank.b(3), CardLevel.L0)
    private val U0_G2B2 = Card(Gem.U, 0, GemBank.g(2, 0, 2), CardLevel.L0)
    private val U0_WGR2B = Card(Gem.U, 0, GemBank.w(1, 0, 1, 2, 1), CardLevel.L0)
    private val U0_WG2R2 = Card(Gem.U, 0, GemBank.w(1, 0, 2, 2), CardLevel.L0)
    private val U0_UG3R = Card(Gem.U, 0, GemBank.u(1, 3, 1), CardLevel.L0)
    val U1_R4 = Card(Gem.U, 1, GemBank.r(4), CardLevel.L0)

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

    val B0_G2R = Card(Gem.B, 0, GemBank.g(2, 1), CardLevel.L0)
    private val B0_WUGR = Card(Gem.B, 0, GemBank.w(1, 1, 1, 1), CardLevel.L0)
    val B0_WU2GR = Card(Gem.B, 0, GemBank.w(1, 2, 1, 1), CardLevel.L0)
    private val B0_W2G2 = Card(Gem.B, 0, GemBank.w(2, 0, 2), CardLevel.L0)
    val B0_W2U2R = Card(Gem.B, 0, GemBank.w(2, 2, 0, 1), CardLevel.L0)
    private val B0_GR3B = Card(Gem.B, 0, GemBank.g(1, 3, 1), CardLevel.L0)
    private val B0_G3 = Card(Gem.B, 0, GemBank.g(3), CardLevel.L0)
    private val B1_U4 = Card(Gem.B, 1, GemBank.u(4), CardLevel.L0)

    val X0 = Card(Gem.W, 0, GemBank.w(9), CardLevel.L0)
    val X1 = Card(Gem.W, 0, GemBank.w(9), CardLevel.L1)
    val X2 = Card(Gem.W, 0, GemBank.w(9), CardLevel.L2)

    val level0: List<Card> = Arrays.asList(
            W0_R2B, W0_UGRB, W0_UG2RB, W0_U2B2, W0_U2G2B, W0_U3, W0_W3UB, W1_G4,
            U0_WGRB, U0_WB2, U0_B3, U0_G2B2, U0_WGR2B, U0_WG2R2, U0_UG3R, U1_R4,
            G0_W2B, G0_R3, G0_WURB, G0_WURB2, G0_UR2B2, G0_U2R2, G0_WU3G, G1_B4,
            R0_U2G, R0_WGRB, R0_W2GRB, R0_W2R2, R0_W2GB2, R0_WRB3, R0_W3, R1_W4,
            B0_G2R, B0_WUGR, B0_WU2GR, B0_W2G2, B0_W2U2R, B0_GR3B, B0_G3, B1_U4
    )

    private val W1_G3R2B2 = Card(Gem.W, 1, GemBank.g(3, 2, 2), CardLevel.L1)
    private val W1_W2U3R3 = Card(Gem.W, 1, GemBank.w(2, 3, 0, 3), CardLevel.L1)
    private val W2_GR4B2 = Card(Gem.W, 2, GemBank.g(1, 4, 2), CardLevel.L1)
    private val W2_R5 = Card(Gem.W, 2, GemBank.r(5), CardLevel.L1)
    val W2_R5B3 = Card(Gem.W, 2, GemBank.r(5, 3), CardLevel.L1)
    private val W3_W6 = Card(Gem.W, 3, GemBank.w(6), CardLevel.L1)

    private val U2_G5 = Card(Gem.U, 2, GemBank.g(5), CardLevel.L1)
    private val U3_G6 = Card(Gem.U, 3, GemBank.g(6), CardLevel.L1)
    private val U1_W2U3B2 = Card(Gem.U, 1, GemBank.w(2,3,0,0,2), CardLevel.L1)
    private val U1_W3G2R3 = Card(Gem.U, 1, GemBank.w(3,0,2,3), CardLevel.L1)
    private val U2_W4U2B = Card(Gem.U, 2, GemBank.w(4,2,0,0,1), CardLevel.L1)
    private val U2_U5G3 = Card(Gem.U, 2, GemBank.u(5,3), CardLevel.L1)

    private val G2_G5 = Card(Gem.G, 2, GemBank.g(5), CardLevel.L1)
    private val G3_G6 = Card(Gem.G, 3, GemBank.g(6), CardLevel.L1)
    private val G1_W2U3B2 = Card(Gem.G, 1, GemBank.w(2,3,0,0,2), CardLevel.L1)
    private val G1_W3G2R3 = Card(Gem.G, 1, GemBank.w(3,0,2,3), CardLevel.L1)
    val G2_W4U2B = Card(Gem.G, 2, GemBank.w(4,2,0,0,1), CardLevel.L1)
    private val G2_U5G3 = Card(Gem.G, 2, GemBank.u(5,3), CardLevel.L1)

    private val R2_B5 = Card(Gem.R, 2, GemBank.b(5), CardLevel.L1)
    private val R3_R6 = Card(Gem.R, 3, GemBank.r(6), CardLevel.L1)
    private val R1_W2R2B3 = Card(Gem.R, 1, GemBank.w(2,0,0,2,3), CardLevel.L1)
    private val R2_WU4G2 = Card(Gem.R, 2, GemBank.w(1,4,2), CardLevel.L1)
    private val R1_U3R2B3 = Card(Gem.R, 1, GemBank.u(3,0,2,3), CardLevel.L1)
    private val R2_W3B5 = Card(Gem.R, 2, GemBank.w(3,0,0,0,5), CardLevel.L1)

    private val B1_W3U2G2 = Card(Gem.B, 1, GemBank.w(3,2,2), CardLevel.L1)
    val B1_W3G3B2 = Card(Gem.B, 1, GemBank.w(3,0,3,0,2), CardLevel.L1)
    val B2_W5 = Card(Gem.B, 2, GemBank.w(5), CardLevel.L1)
    private val B2_B5 = Card(Gem.B, 2, GemBank.b(5), CardLevel.L1)
    private val B2_UG4R2 = Card(Gem.B, 2, GemBank.u(1,4,2), CardLevel.L1)
    private val B2_G5R3 = Card(Gem.B, 2, GemBank.g(5,3), CardLevel.L1)
    private val B3_B6 = Card(Gem.B, 3, GemBank.b(6), CardLevel.L1)

    val level1: List<Card> = Arrays.asList(
            W2_R5, W3_W6, W1_G3R2B2, W1_W2U3R3, W2_GR4B2, W2_R5B3,
            U2_G5, U3_G6, U1_W2U3B2, U1_W3G2R3, U2_W4U2B, U2_U5G3,
            G2_G5, G3_G6, G1_W2U3B2, G1_W3G2R3, G2_W4U2B, G2_U5G3,
            R2_B5, R3_R6, R1_W2R2B3, R2_WU4G2, R1_U3R2B3, R2_W3B5,
            B2_B5, B3_B6, B1_W3U2G2, B2_UG4R2, B1_W3G3B2, B2_G5R3, B2_W5
    )

    private val W4_B7 = Card(Gem.W, 4, GemBank.b(7), CardLevel.L2)
    private val W5_W3B7 = Card(Gem.W, 5, GemBank.w(3,0,0,0,7), CardLevel.L2)
    private val W4_W3R3B6 = Card(Gem.W, 4, GemBank.w(3,0,0,3,6), CardLevel.L2)
    private val W3_U3G3R5B3 = Card(Gem.W, 3, GemBank.u(3,3,5,3), CardLevel.L2)

    private val U4_W7 = Card(Gem.U, 4, GemBank.w(7), CardLevel.L2)
    private val U5_W7U3 = Card(Gem.U, 5, GemBank.w(7,3), CardLevel.L2)
    private val U4_W3U6G3 = Card(Gem.U, 4, GemBank.w(3,6,3), CardLevel.L2)
    private val U3_W3G3R3B5 = Card(Gem.U, 3, GemBank.w(3,0,3,3,5), CardLevel.L2)

    val G3_W5U3R3B3 = Card(Gem.G, 3, GemBank.w(5,3,0,3,3), CardLevel.L2)
    private val G4_U7 = Card(Gem.G, 4, GemBank.u(7), CardLevel.L2)
    val G4_W3U6G3 = Card(Gem.G, 4, GemBank.w(3,6,3), CardLevel.L2)
    private val G5_U7G3 = Card(Gem.G, 5, GemBank.u(7,3), CardLevel.L2)

    val R3_W3U5G3B3 = Card(Gem.R, 3, GemBank.w(3,5,3,0,3), CardLevel.L2)
    private val R4_G7 = Card(Gem.R, 4, GemBank.g(7), CardLevel.L2)
    val R4_U3G6R3 = Card(Gem.R, 4, GemBank.u(3,6,3), CardLevel.L2)
    private val R5_G7R3 = Card(Gem.R, 5, GemBank.g(7,3), CardLevel.L2)

    private val B4_R7 = Card(Gem.B, 4, GemBank.r(7), CardLevel.L2)
    private val B5_R7B3 = Card(Gem.B, 5, GemBank.r(7,3), CardLevel.L2)
    private val B4_G3R6B3 = Card(Gem.B, 4, GemBank.g(3,6,3), CardLevel.L2)
    private val B3_W3U3G5R3 = Card(Gem.B, 3, GemBank.w(3,3,5,3), CardLevel.L2)

    val level2: List<Card> = Arrays.asList(
            W4_B7, W5_W3B7, W4_W3R3B6, W3_U3G3R5B3,
            U4_W7, U5_W7U3, U4_W3U6G3, U3_W3G3R3B5,
            G4_U7, G5_U7G3, G4_W3U6G3, G3_W5U3R3B3,
            R4_G7, R5_G7R3, R4_U3G6R3, R3_W3U5G3B3,
            B4_R7, B5_R7B3, B4_G3R6B3, B3_W3U3G5R3
    )

    val N3_WUB = Noble(3, GemBank.w(3,3,0,0,3))
    private val N3_UGR = Noble(3, GemBank.u(3,3,3))
    val N3_WRB = Noble(3, GemBank.w(3, 0, 0,3,3))
    private val N3_WUG = Noble(3, GemBank.w(3, 3, 3))
    private val N3_GRB = Noble(3, GemBank.g(3, 3, 3))
    val N4_GR = Noble(4, GemBank.g(4, 4))
    private val N4_UG = Noble(4, GemBank.u(4, 4))
    private val N4_RB = Noble(4, GemBank.r(4, 4))
    val N4_WB = Noble(4, GemBank.w(4, 0, 0, 0, 4))
    private val N4_WU = Noble(4, GemBank.w(4, 4))

    val nobles: List<Noble> = Arrays.asList(N3_WUB, N3_UGR, N3_WRB, N3_WUG, N3_GRB, N4_GR, N4_UG, N4_RB, N4_WB, N4_WU)
}