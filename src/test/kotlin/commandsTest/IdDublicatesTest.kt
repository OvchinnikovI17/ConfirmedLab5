package commandsTest

import controllers.WorkWithCollection
import workCommandsList.Add
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import workCommandsList.RemoveById

internal class IdDublicatesTest {

    @Test
    fun `Check, if there can be double id`() {

        val workWithCollection: WorkWithCollection = WorkWithCollection()
        val add: Add = Add()
        var sendList = mutableListOf<Any>()
        sendList.add(1.toLong())
        sendList.add("Egor 2 2 2 2 2 2 2 2 2")
        var sendList2 = mutableListOf<Any>()
        sendList2.add(1.toLong())
        sendList2.add("Oleg 2 2 2 2 2 2 2 2 2")
        val removeById: RemoveById = RemoveById()
        var sendList4 = mutableListOf<Any>()
        sendList4.add(2)
        removeById.execute(sendList4, workWithCollection)
        var sendList3 = mutableListOf<Any>()
        sendList3.add(1.toLong())
        sendList3.add("Oleg 2 2 2 2 2 2 2 2 2")
        add.execute(sendList, workWithCollection)
        add.execute(sendList2, workWithCollection)

        assertEquals(workWithCollection.getCollection().poll().id, workWithCollection.getCollection().peek().id + 1)
    }

}