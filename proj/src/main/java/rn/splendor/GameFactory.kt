package rn.splendor

import rn.splendor.card.*
import rn.splendor.entity.Game
import java.util.stream.Collectors

class GameFactory {
    fun create(cards: List<Card>, nobles: List<Noble>): Game {
        val deck = Deck(SequencedCardMagazine(), CardSet.allLevel0, CardSet.allLevel1, CardSet.allLevel2)
        return create(deck, cards, nobles)
    }

    fun create(): Game {
        val deck = Deck(SequencedCardMagazine(), CardSet.allLevel0, CardSet.allLevel1, CardSet.allLevel2)
        return create(deck, Gc.nobles.stream().limit(CardSet.initialNoblesCount).collect(Collectors.toList()))
    }

    fun create(deck: Deck, nobles: List<Noble>): Game {
        val cards = deck.getInitial()
        return create(deck, cards, nobles)
    }

    private fun create(deck: Deck, initialCards: List<Card>, nobles: List<Noble>): Game {

        for (initialCard in initialCards) {
            deck.remove(initialCard)
        }

        return Game(initialCards, deck, nobles, CardSet.initialGoldCount)
    }
}