package leetcode

import java.util.*

/*
给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。

进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 
示例：
输入：root = [1,2,3,4,5,6,7]
输出：[1,#,2,3,#,4,5,6,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 
提示：
树中节点的数量少于 4096
-1000 <= node.val <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class Node116(var `val`: Int) {
    var left: Node116? = null
    var right: Node116? = null
    var next: Node116? = null

    constructor(v0: Int, vararg v: Int?) : this(v0) {
        val queue = LinkedList<Node116?>()
        var index = -1
        queue.offer(this)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val temp = queue.pop()
                if (temp != null) {
                    index++
                    if (index < v.size && v[index] != null) {
                        temp.left = Node116(v[index]!!)
                    }
                    index++
                    if (index < v.size && v[index] != null) {
                        temp.right = Node116(v[index]!!)
                    }
                    queue.offer(temp.left)
                    queue.offer(temp.right)
                }
            }
        }
    }
}

private fun connect(root: Node116?): Node116? {
    val queue = LinkedList<Node116>()
    root?.let(queue::offer)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val node = queue.pop()
            if (i != size) {
                node.next = queue.peek()
            }
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
    }
    return root
}

fun main() {
    val node = connect(Node116(1, 2, 3, 4, 5, 6, 7))
    fun dfs(node: Node116?) {
        if (node== null) return
        println("${node.`val`} -> ${node.next?.`val`}")
        dfs(node.left)
        dfs(node.right)
    }
    dfs(node)
}