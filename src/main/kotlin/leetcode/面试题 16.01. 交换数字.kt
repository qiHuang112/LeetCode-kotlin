package leetcode

/**
编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。

示例：

输入: numbers = [1,2]
输出: [2,1]
 */
private fun swapNumbers(numbers: IntArray): IntArray {
    numbers[0] = numbers[0] + numbers[1]
    numbers[1] = numbers[0] - numbers[1]
    numbers[0] = numbers[0] - numbers[1]
    return numbers
}

fun main() {
    println(swapNumbers(intArrayOf(33, 2)).contentToString())
}