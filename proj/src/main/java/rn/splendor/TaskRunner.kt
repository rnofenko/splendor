package rn.splendor

import org.springframework.stereotype.Component
import rn.splendor.solver.BruteForcer

@Component
class TaskRunner {
    fun run() {
        val gameFactory = GameFactory()
        val game = gameFactory.create()

        val forcer = BruteForcer()
        forcer.start(game)
    }
}

