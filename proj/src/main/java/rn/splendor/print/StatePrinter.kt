package rn.splendor.print

import rn.splendor.entity.Bank
import rn.splendor.entity.Gem
import rn.splendor.solver.State

class StatePrinter {
    companion object {
        val gemToColor = mapOf(
                Gem.W to ConsoleColors.WHITE,
                Gem.U to ConsoleColors.BLUE,
                Gem.G to ConsoleColors.GREEN,
                Gem.R to ConsoleColors.RED,
                Gem.B to ConsoleColors.PURPLE
        )
    }

    fun print(state: State) {
        val table = state.table
        val cards = table.deck.cards

        System.out.println(state.stepNo)
        var index = 0
        for (card in cards) {
            index++
            printBank(card.cost)
            System.out.print("-")
            System.out.print(gemToColor[card.reward] + card.points+"  ")
            if(index == 5) {
                System.out.println()
                index=0
            }
        }

        printBank(table.bank, false)
        System.out.println()
        printBank(table.user.bank, false)
        System.out.println()
    }

    private fun printBank(bank: Bank, skipZero: Boolean = true) {
        printBankItem(bank, Gem.W, skipZero)
        printBankItem(bank, Gem.U, skipZero)
        printBankItem(bank, Gem.G, skipZero)
        printBankItem(bank, Gem.R, skipZero)
        printBankItem(bank, Gem.B, skipZero)
    }

    private fun printBankItem(bank: Bank, gem: Gem, skipZero: Boolean) {
        val count = bank.gems[gem.index]
        if(!skipZero || count > 0) {
            System.out.print(gemToColor[gem] + count)
        }
    }
}