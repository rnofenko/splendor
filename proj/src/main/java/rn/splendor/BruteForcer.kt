package rn.splendor

class BruteForcer {
    fun start(table: Table) {
        var root = State(table)
    }

    private fun next(state: State) {
        getAvailableChoices(state.table)
    }

    private fun getAvailableChoices(table: Table) {
        val actions = ArrayList<IAction>()
        actions.addAll(getAvailableGemActions(table))
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