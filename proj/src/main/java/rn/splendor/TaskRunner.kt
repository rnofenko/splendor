package rn.splendor

import org.springframework.stereotype.Component

@Component
class TaskRunner {
    fun run() {
        System.out.println("DDDDDDDDDDDDDDD")

        val cardSet = CardSet()
        val tableFactory = TableFactory()
        val table = tableFactory.create(cardSet)
    }
}

