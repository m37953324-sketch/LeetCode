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