package rn.splendor.solver

import rn.splendor.action.IAction
import rn.splendor.entity.Game
import rn.splendor.entity.User

class State {
    val user: User
    val game: Game
    val stepNo: Int
    val history: List<IAction>

    constructor(game: Game, user: User, stepNo: Int, history: List<IAction>) {
        this.game = game
        this.stepNo = stepNo
        this.history = history
        this.user = user
    }

    constructor(game: Game, user: User) : this(game, user, 0, ArrayList())

    fun next(action: IAction, keepStepNo: Boolean = false): State {
        val newHistory = ArrayList(history)
        newHistory.add(action)
        val newStepNo = if(keepStepNo) stepNo else stepNo + 1
        return State(game.clone(), user.clone(), newStepNo, newHistory)
    }

    override fun toString(): String {
        return "${user.points}/$stepNo"
    }

    fun getUniqueKey(): String {
        return user.getUniqueKey() + game.getUniqueKey() + stepNo
    }
}