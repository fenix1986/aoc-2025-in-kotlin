fun main() {
    fun count(l: Long): Long {
        val str = l.toString()
        if (str.length % 2 != 0) return 0

        val half = str.length / 2
        return if (str.substring(0, half) == str.substring(half, half * 2)) l else 0
    }

    fun count2(l: Long): Long {
        val str = l.toString()
        val length = str.length

        for (i in 2..length) {
            if (length % i == 0) {
                val partLen = length / i
                val set = HashSet<String>()

                for (k in 0 until i) {
                    set.add(str.substring(k * partLen, (k + 1) * partLen))
                }

                if (set.size == 1) return l
            }
        }

        return 0
    }

    fun part1(input: List<String>): Long {
        var result = 0L

        for (line in input) {
            for (s in line.split(",")) {
                val (a, b) = s.split("-").map { it.toLong() }

                for (l in a..b) {
                    result += count(l)
                }
            }
        }

        return result
    }

    fun part2(input: List<String>): Long {
        var result2 = 0L

        for (line in input) {
            for (s in line.split(",")) {
                val (a, b) = s.split("-").map { it.toLong() }

                for (l in a..b) {
                    result2 += count2(l)
                }
            }
        }

        return result2
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
