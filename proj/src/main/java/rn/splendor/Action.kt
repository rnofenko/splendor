package rn.splendor

class ActionFactory {
    companion object {
        fun createTakeGem(bank: Bank) : IAction {
            return TakeGemAction(ActionType.TakeGem, bank)
        }
    }
}

interface IAction {
    val type: ActionType
}

enum class ActionType {
    TakeGem
}

class TakeGemAction(override val type: ActionType, val bank: Bank) : IAction