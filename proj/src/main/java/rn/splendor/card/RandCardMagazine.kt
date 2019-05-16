package rn.splendor.card

import rn.splendor.tool.AppException
import java.time.LocalDateTime
import kotlin.random.Random

class RandCardMagazine : ICardMagazine {

    private val rand: Random = Random(LocalDateTime.now().nano)

    override fun pop(list: ArrayList<Card>) : Card {
        if(list.isEmpty()) {
            throw AppException("No cards in magazine")
        }
        val index = rand.nextInt(list.size)
        val card = list[index]
        list.removeAt(index)
        return card
    }
}