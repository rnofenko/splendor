package rn.splendor.tool

class CombinationInt {
    fun build(size: Int, valueSetSize: Int): List<IntArray> {
        val list = ArrayList<IntArray>()

        val indices = IntArray(size) { i -> i }
        list.add(indices.clone())

        while (inc(indices, valueSetSize)) {
            list.add(indices.clone())
        }

        return list
    }

    private fun inc(indices: IntArray, valueSetSize: Int): Boolean {
        var index = indices.size
        var max = valueSetSize + 1
        do {
            index--
            max--
            if(index < 0) {
                return false
            }
            indices[index]++
        } while (max == indices[index])

        for (i in index until indices.size - 1) {
            indices[i + 1] = indices[i] + 1
        }

        return true
    }
}