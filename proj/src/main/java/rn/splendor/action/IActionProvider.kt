package rn.splendor.action

import rn.splendor.entity.Game
import rn.splendor.entity.User

interface IActionProvider {
    fun get(game: Game, user: User): List<IAction>
}