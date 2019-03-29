package rn.splendor

import com.sun.media.sound.InvalidDataException

enum class Gem(val index: Int) {
    W(0),
    U(1),
    G(2),
    R(3),
    B(4);

    companion object {
        private val map = Gem.values().associateBy(Gem::index)
        fun fromInt(index: Int) = map[index] ?: throw InvalidDataException("No gems with index $index")
    }
}