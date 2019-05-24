package rn.splendor.game

import org.junit.jupiter.api.Test
import rn.splendor.GameFactory
import rn.splendor.card.Gc
import rn.splendor.solver.BruteForcer
import java.util.*

class GameTests {

    @Test
    fun start1() {
        val gameFactory = GameFactory()
        val cards = Arrays.asList(Gc.B0_G2R, Gc.B0_W2U2R, Gc.U1_R4, Gc.B0_WU2GR,
                Gc.W2_R5B3, Gc.G2_W4U2B, Gc.B2_W5, Gc.B1_W3G3B2,
                Gc.G4_W3U6G3, Gc.R3_W3U5G3B3, Gc.G3_W5U3R3B3, Gc.R4_U3G6R3)

        val nobles = Arrays.asList(Gc.N3_WUB, Gc.N4_GR, Gc.N3_WRB)
        val game = gameFactory.create(cards, nobles)

        val forcer = BruteForcer()
        forcer.start(game)
    }
}