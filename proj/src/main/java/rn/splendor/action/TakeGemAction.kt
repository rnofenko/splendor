package rn.splendor.action

import rn.splendor.entity.Bank

class TakeGemAction(override val type: ActionType, val bank: Bank) : IAction