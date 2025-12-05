fun main() {
    fun part1(input: List<String>): Int {
        var result = 0L
        var start = 50

        for (line in input) {
            val c = line[0]
            val i = line.substring(1).toInt()
            Math.floorMod(i, 100)

            start = if (c == 'R') {
                Math.floorMod(start + i, 100)
            } else {
                Math.floorMod(start - i, 100)
            }

            if (start == 0) {
                result++
            }
        }

        return result.toInt()
    }

    fun part2(input: List<String>): Int {
        var result2 = 0L
        var start = 50

        for (line in input) {
            val c = line[0]
            val i = line.substring(1).toInt()

            result2 += (i / 100)
            val x = Math.floorMod(i, 100)

            if (c == 'R') {
                if (start + x >= 100) result2++
                start = Math.floorMod(start + i, 100)
            } else {
                if (start - x <= 0 && start != 0) result2++
                start = Math.floorMod(start - i, 100)
            }
        }

        return result2.toInt()
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
