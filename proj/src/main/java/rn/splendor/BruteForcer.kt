package rn.splendor

class BruteForcer {
    fun start(table: Table) {
        val root = State(table)
        next(root)
    }

    private fun next(state: State) {
        val actions = getAvailableActions(state.table)
        for(action in actions) {
            val newState = apply(state, action)
            next(newState)
        }
    }

    private fun apply(state: State, action: IAction): State {
        val newState = state.clone()
        return newState
    }

    private fun getAvailableActions(table: Table): List<IAction> {
        val actions = ArrayList<IAction>()
        actions.addAll(getAvailableGemActions(table))

        return actions
    }

    private fun getAvailableGemActions(table: Table): List<IAction> {
        val gems = getAvailableGemSelections(table.user)

        return gems
                .filter { table.bank.equalOrMore(it) }
                .map { ActionFactory.createTakeGem(it) }
    }

    private fun getAvailableGemSelections(user: User): List<Bank> {
        if(user.hasThreeSpaces) {
            return Choices.gem3AndDuplicate
        }

        if(user.hasTwoSpaces) {
            return Choices.gem2
        }

        return emptyList()
    }
}