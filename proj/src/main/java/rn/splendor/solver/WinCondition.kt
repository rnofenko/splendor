package rn.splendor.solver

class WinCondition {
    val winPoints = 15

    fun getBest(state1: State, state2: State): State {
        if(state1.user.points < winPoints) {
            return state2
        }
        if(state2.user.points < winPoints) {
            return state1
        }
        if(state1.stepNo == state2.stepNo) {
            if(state1.user.points >= state2.user.points) {
                return state1
            }
            return state2
        }
        if(state1.stepNo <= state2.stepNo) {
            return state1
        }
        return state2
    }
}