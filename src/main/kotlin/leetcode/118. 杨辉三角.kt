package leetcode

/*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun generate(numRows: Int): List<List<Int>> {
    if (numRows == 0) return emptyList()
    if (numRows == 1) return listOf(listOf(1))
    val res = mutableListOf(listOf(1))
    for (i in 2..numRows) {
        val last = res.last()
        val next = List(last.size + 1) { index ->
            when (index) {
                0, last.size -> 1
                else -> last[index] + last[index - 1]
            }
        }
        res.add(next)
    }
    return res
}

fun main() {
    println(generate(10))
}