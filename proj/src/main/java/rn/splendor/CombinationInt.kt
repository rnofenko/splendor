package rn.splendor

class CombinationInt {
    fun build(size: Int, valueSetSize: Int): List<IntArray> {
        val list = ArrayList<IntArray>()
        val indices = IntArray(size) { i -> i }

        list.add(indices)
        while (inc(indices, valueSetSize)) {
            list.add(indices)
        }

        return list
    }

    private fun inc(indices: IntArray, valueSetSize: Int): Boolean {
        var index = indices.size
        do {
            index--
            if(index < 0) {
                return false
            }
            indices[index]++
        } while (valueSetSize == indices[index])

        for (i in index until indices.size) {
            indices[i+1] = indices[i] + 1
        }

        return true
    }
}