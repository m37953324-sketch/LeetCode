class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Task21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy

        // Указатели на текущие узлы в каждом списке
        var l1 = list1
        var l2 = list2

        // Проходим по обоим спискам, пока оба не пусты
        while (l1 != null && l2 != null) {
            // Сравниваем значения и добавляем меньший узел в результат
            if (l1.`val` <= l2.`val`) {
                current.next = l1
                l1 = l1.next
            } else {
                current.next = l2
                l2 = l2.next
            }
            current = current.next!!
        }

        // Если остались узлы в 1-ом списке, добавляем их все
        if (l1 != null) {
            current.next = l1
        }

        // Если остались узлы во втором списке, добавляем их все
        if (l2 != null) {
            current.next = l2
        }

        // Возвращаем голову объединенного списка (следующий за фиктивным узлом)
        return dummy.next
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

private fun nodesToList(node: ListNode?): List<Int> {
    val result = mutableListOf<Int>()
    var current = node
    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }
    return result
}

class Task21Test {

    @org.junit.jupiter.api.Test
    fun `example 1`() {
        val list1 = listOfNodes(1, 2, 4)
        val list2 = listOfNodes(1, 3, 4)

        val merged = Task21().mergeTwoLists(list1, list2)

        assert(nodesToList(merged) == listOf(1, 1, 2, 3, 4, 4))
    }

    @org.junit.jupiter.api.Test
    fun `example 2`() {
        val merged = Task21().mergeTwoLists(null, null)

        assert(nodesToList(merged).isEmpty())
    }

    @org.junit.jupiter.api.Test
    fun `example 3`() {
        val list2 = listOfNodes(0)

        val merged = Task21().mergeTwoLists(null, list2)

        assert(nodesToList(merged) == listOf(0))
    }
}