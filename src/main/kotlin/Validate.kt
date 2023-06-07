class Validate {
    fun String.validatePin(): Boolean {
        return this.checkLength() && this.checkTripleDuplicate() && this.checkTripleOrder() && this.checkSetDuplicate()
    }

    fun String.checkLength(): Boolean {
        return this.length >= 6
    }

    fun String.checkTripleDuplicate(): Boolean {
        val max = this.lastIndex
        val list = arrayListOf<Boolean>()
        this.forEachIndexed { index, c ->
            if (index + 1 <= max && index + 2 <= max) {
                list.add(c == this[index + 1] && c == this[index + 2])
            }
        }.also {
            return  list.all { !it }
        }
    }

    fun String.checkTripleOrder(): Boolean {
        val max = this.lastIndex
        val list = arrayListOf<Boolean>()
        this.forEachIndexed { index, c ->
            if (index + 1 <= max && index + 2 <= max) {
                list.add(
                    (c.toInteger() == this[index + 1].toInteger() + 1 ||
                            c.toInteger() == this[index + 1].toInteger() - 1) &&
                            (c.toInteger() == this[index + 2].toInteger() + 2 ||
                                    c.toInteger() == this[index + 2].toInteger() - 2)
                )
            }
        }.also {
            return  list.all { !it }
        }
    }

    fun String.checkSetDuplicate(): Boolean {
        val max = this.lastIndex
        val set = arrayListOf<Boolean>()
        this.forEachIndexed { index, c ->
            if (index + 1 <= max && c == this[index + 1]) {
                set.add(true)
            } else {
                set.add(false)
            }
        }
        return set.count { it } <= 2
    }

    fun Char.toInteger() = this.toString().toInt()
}