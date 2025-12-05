fun main() {
    fun maxSubsequence(s: String, maxLength: Int): Long {
        val n = s.length
        val dp = Array(n + 1) { arrayOfNulls<Long>(maxLength + 1) }

        for (i in 0..n) {
            dp[i][0] = 0L
        }

        for (i in 1..n) {
            val c = (s[i - 1] - '0').toLong()

            for (k in 0..maxLength) {

                // pomijam cyfrę
                dp[i][k] = dp[i - 1][k]

                // dokładam cyfrę
                if (k > 0 && dp[i - 1][k - 1] != null) {
                    val value = dp[i - 1][k - 1]!! * 10L + c
                    if (dp[i][k] == null || value > dp[i][k]!!) {
                        dp[i][k] = value
                    }
                }
            }
        }

        return dp[n][maxLength]!!
    }

    fun part1(input: List<String>): Long {
        var result = 0L
        for (line in input) {
            result += maxSubsequence(line, 2)
        }
        return result
    }

    fun part2(input: List<String>): Long {
        var result2 = 0L
        for (line in input) {
            result2 += maxSubsequence(line, 12)
        }
        return result2
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
