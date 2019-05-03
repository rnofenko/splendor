package rn.splendor

import org.springframework.stereotype.Component
import rn.splendor.solver.BruteForcer

@Component
class TaskRunner {
    fun run() {
        val cardSet = CardSet()
        val tableFactory = TableFactory()
        val table = tableFactory.create(cardSet)

        val forcer = BruteForcer()
        forcer.start(table)
    }
}

