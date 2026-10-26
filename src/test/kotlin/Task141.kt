class Task141 {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) return true
        }

        return false
    }
}

private fun listOfNodes(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var current = dummy
    for (v in values) {
        current.next = ListNode(v)
        current = current.next!!
    }
    return dummy.next
}

private fun listOfNodesWithCycle(values: IntArray, pos: Int): ListNode? {
    if (values.isEmpty()) return null

    val nodes = ArrayList<ListNode>(values.size)
    for (v in values) {
        nodes.add(ListNode(v))
    }

    for (i in 0 until nodes.size - 1) {
        nodes[i].next = nodes[i + 1]
    }

    if (pos >= 0 && pos < nodes.size) {
        nodes[nodes.size - 1].next = nodes[pos]
    }

    return nodes[0]
}

private fun nodesToList(node: ListNode?): List<Int> {
    val result = mutableListOf<Int>()
    var current = node
    val visited = HashSet<ListNode>()

    while (current != null && !visited.contains(current)) {
        visited.add(current)
        result.add(current.`val`)
        current = current.next
    }

    return result
}

class Task141Test {

    @org.testng.annotations.Test
    fun `example 1`() {
        val head = listOfNodesWithCycle(intArrayOf(3, 2, 0, -4), 1)
        val result = Task141().hasCycle(head)
        org.testng.Assert.assertTrue(result)
    }

    @org.testng.annotations.Test
    fun `example 2`() {
        val head = listOfNodesWithCycle(intArrayOf(1, 2), 0)
        val result = Task141().hasCycle(head)
        org.testng.Assert.assertTrue(result)
    }

    @org.testng.annotations.Test
    fun `example 3`() {
        val head = listOfNodes(1)
        val result = Task141().hasCycle(head)
        org.testng.Assert.assertFalse(result)
    }

    @org.testng.annotations.Test
    fun `empty list`() {
        val result = Task141().hasCycle(null)
        org.testng.Assert.assertFalse(result)
    }

    @org.testng.annotations.Test
    fun `no cycle`() {
        val head = listOfNodes(1, 2, 3, 4)
        val result = Task141().hasCycle(head)
        org.testng.Assert.assertFalse(result)
    }
}
