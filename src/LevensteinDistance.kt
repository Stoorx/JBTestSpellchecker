object LevensteinDistance {

    fun getDistance(s1: String, s2: String): Int = calculateFast(s1, s2)

    private fun calculate(s1: String, s2: String, i: Int, j: Int): Int =
        if (i == 0 && j == 0) 0
        else if (j == 0) i
        else if (i == 0) j
        else minOf(
            calculate(s1, s2, i, j - 1) + 1,
            calculate(s1, s2, i - 1, j) + 1,
            calculate(s1, s2, i - 1, j - 1) + cost(s1[i - 1], s2[j - 1])
        )

    private fun calculateFast(s1: String, s2: String) =
        Array(s1.length + 1) {
            IntArray(s2.length + 1)
        }.let { matrix ->
            matrix.forEachIndexed { i, subArr ->
                subArr.forEachIndexed { j, _ ->
                    matrix[i][j] = element(matrix, s1, s2, i, j)
                }
            }
            matrix.last().last()
        }


    private fun element(arr: Array<IntArray>, s1: String, s2: String, i: Int, j: Int) =
        if (i == 0 && j == 0) 0
        else if (j == 0) i
        else if (i == 0) j
        else minOf(
            arr[i][j - 1] + 1,
            arr[i - 1][j] + 1,
            arr[i - 1][j - 1] + cost(s1[i - 1], s2[j - 1])
        )

    private fun cost(c1: Char, c2: Char): Int =
        if (c1 == c2) 0
        else 1
}