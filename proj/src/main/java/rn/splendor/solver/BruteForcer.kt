package rn.splendor.solver

import org.slf4j.LoggerFactory
import rn.splendor.action.IAction
import rn.splendor.action.executor.ActionExecutor
import rn.splendor.action.executor.IActionExecutor
import rn.splendor.action.provider.UnitedActionProvider
import rn.splendor.card.CardSet
import rn.splendor.print.StatePrinter
import rn.splendor.entity.Game
import rn.splendor.entity.User
import java.util.*
import kotlin.collections.ArrayList

class BruteForcer {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private var counter = 0
    private val actionExecutor: IActionExecutor = ActionExecutor()
    private val printer = StatePrinter()
    private val actionProvider = UnitedActionProvider()
    private val winCondition = WinCondition()
    private val set = HashSet<String>()

    fun start(game: Game) {
        val root = State(game, User())
        printer.print(root)

        val best = State(game, User().addPoints(CardSet.WIN_POINTS), 100, ArrayList())

        val final = next(root, best)
        printer.print(final)

        log.info("$counter. Best of the best ${final.user.points}/${final.stepNo}")
    }

    private fun next(state: State, initialBest: State): State {
        val actions = actionProvider.get(state.game, state.user)
        if(actions.isEmpty()) {
            return initialBest
        }

        var best = winCondition.getBest(state, initialBest)
        for(action in actions) {
            val newState = execute(state, action)

//            if(!set.add(newState.getUniqueKey())) {
//                return best
//            }

            val oldBest = best
            best = winCondition.getBest(best, newState)
            if(oldBest != best && best.user.points >= CardSet.WIN_POINTS) {
                printer.print(best)
            }

            if(counter % 5000000 == 0) {
                val m = counter / 1000000
                log.info("$m. Current ${newState.user.points}/${newState.stepNo}  Best ${best.user.points}/${best.stepNo}")
            }

            if(newState.stepNo < best.stepNo) {
                best = next(newState, best)
            }
        }

        return best
    }

    private fun execute(state: State, action: IAction): State {
        counter++
        return actionExecutor.execute(state, action)
    }
}