package rn.splendor.card

import rn.splendor.entity.Card

interface ICardMagazine {
    fun getInitial(): Array<Card>

    fun pop(level: CardLevel): Card

    fun clone(): ICardMagazine
}