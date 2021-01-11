package leetcode

/*
给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
实现 NumArray 类：
NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）

示例：
输入：
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
输出：
[null, 1, -1, -3]
解释：
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 
提示：

0 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= i <= j < nums.length
最多调用 104 次 sumRange 方法

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-query-immutable
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力直接加，每次的时间复杂度为o(n)
 */
private class NumArray1(val nums: IntArray) {

    fun sumRange(i: Int, j: Int): Int {
        return (i..j).fold(0) { acc, k -> acc + nums[k] }
    }

}

/**
 * 初始化的时候计算一个sumArr，每次计算的时候直接sumArr[j] - sumArr[i]就好了
 * 时间复杂度为o(1)
 */
private class NumArray303(val nums: IntArray) {

    private val sumArr: IntArray

    init {
        var sum = 0
        sumArr = IntArray(nums.size)
        for (i in sumArr.indices) {
            sum += nums[i]
            sumArr[i] = sum
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return if (i == 0) sumArr[j] else sumArr[j] - sumArr[i - 1]
    }

}


fun main() {
    NumArray303(intArrayOf(-2, 0, 3, -5, 2, -1)).apply {
        println(sumRange(0, 2))
        println(sumRange(2, 5))
        println(sumRange(0, 5))
    }
}