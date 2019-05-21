object DamerauLevensteinDistance {

    fun getDistance(s1: String, s2: String): Int = calculateFast(s1, s2)

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
        else if (i >= 2 && j >= 2) minOf(
            minOf(
                arr[i][j - 1] + 1,
                arr[i - 1][j] + 1
            ),
            minOf(
                arr[i - 1][j - 1] + cost(s1[i - 1], s2[j - 1]),
                arr[i - 2][j - 2] + damerau(s1[i - 1], s2[j - 2], s1[i - 2], s2[j - 1])
            )
        )
        else minOf(
            arr[i][j - 1] + 1,
            arr[i - 1][j] + 1,
            arr[i - 1][j - 1] + cost(s1[i - 1], s2[j - 1])
        )

    private fun cost(c1: Char, c2: Char): Int =
        if (c1 == c2) 0
        else 1

    private fun damerau(c1: Char, c2: Char, c3: Char, c4: Char) =
        if (c1 == c2 && c3 == c4) 1
        else 1_000_000_000
}