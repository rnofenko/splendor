package rn.splendor

import org.springframework.stereotype.Component
import rn.splendor.card.CardSet
import rn.splendor.card.RandCardMagazine
import rn.splendor.solver.BruteForcer

@Component
class TaskRunner {
    fun run() {
        val magazine = RandCardMagazine()
        val tableFactory = TableFactory()
        val table = tableFactory.create(magazine)

        val forcer = BruteForcer()
        forcer.start(table)
    }
}

