package leetcode

/*
给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。

示例 1：
输入：n = 234
输出：15
解释：
各位数之积 = 2 * 3 * 4 = 24
各位数之和 = 2 + 3 + 4 = 9
结果 = 24 - 9 = 15

示例 2：
输入：n = 4421
输出：21
解释：
各位数之积 = 4 * 4 * 2 * 1 = 32
各位数之和 = 4 + 4 + 2 + 1 = 11
结果 = 32 - 11 = 21

提示：
1 <= n <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun subtractProductAndSum(n: Int): Int {
    var temp = n
    var a = 1
    var b = 0
    while (temp > 0) {
        val cur = temp % 10
        a *= cur
        b += cur
        temp /= 10
    }
    return a - b
}

fun main() {
    println(subtractProductAndSum(234))
    println(subtractProductAndSum(4421))
}