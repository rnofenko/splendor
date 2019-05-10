package rn.splendor.card

import java.time.LocalDateTime
import kotlin.random.Random

class RandCardMagazine : ICardMagazine {

    private val rand: Random = Random(LocalDateTime.now().nano)

    override fun pop(list: ArrayList<Card>) : Card {
        if(list.isEmpty()) {
            return Card.blank
        }
        val index = rand.nextInt(list.size)
        val card = list[index]
        list.removeAt(index)
        return card
    }
}