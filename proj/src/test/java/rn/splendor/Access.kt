package rn.splendor

import rn.splendor.entity.Gem
import rn.splendor.entity.GemBank
import rn.splendor.entity.User

object Access {
    fun getPermanentGems(user: User): GemBank {
        val value = getUserField(user,"permanentGems")
        return value as GemBank
    }

    private fun getTempGems(user: User): GemBank {
        val value = getUserField(user,"tempGems")
        return value as GemBank
    }

    private fun getAllGems(user: User): GemBank {
        val value = getUserField(user,"allGems")
        return value as GemBank
    }

    fun getPermanentGem(user: User, gem: Gem): Int {
        val gems = getPermanentGems(user).gems
        return gems[gem.index]
    }

    fun getTempGem(user: User, gem: Gem): Int {
        val gems = getTempGems(user).gems
        return gems[gem.index]
    }

    fun getAllGem(user: User, gem: Gem): Int {
        val gems = getAllGems(user).gems
        return gems[gem.index]
    }

    private fun getUserField(user: User, name: String): Any? {
        val field = User::class.java.getDeclaredField(name)
        field.isAccessible = true
        return field.get(user)
    }
}