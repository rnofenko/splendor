package rn.splendor

import rn.splendor.card.*
import rn.splendor.entity.Game
import java.util.stream.Collectors

class GameFactory {
    fun create(): Game {
        val deck = Deck(SequencedCardMagazine(), CardSet.allLevel0, CardSet.allLevel1, CardSet.allLevel2)
        return create(deck, Gc.nobles.stream().limit(CardSet.initialNoblesCount).collect(Collectors.toList()))
    }

    fun create(deck: Deck, nobles: List<Noble>): Game {
        val cards = deck.getInitial()
        return Game(cards, deck, nobles, CardSet.initialGoldCount)
    }
}