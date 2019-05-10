package rn.splendor

import rn.splendor.card.CardSet
import rn.splendor.card.Deck
import rn.splendor.card.SequencedCardMagazine
import rn.splendor.entity.Game

class GameFactory {
    fun create(): Game {
        val deck = Deck(SequencedCardMagazine(), CardSet.allLevel0, CardSet.allLevel1, CardSet.allLevel2)
        return create(deck)
    }

    fun create(deck: Deck): Game {
        val cards = deck.getInitial()
        return Game(cards, deck)
    }
}