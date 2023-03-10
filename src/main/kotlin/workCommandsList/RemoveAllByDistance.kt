package workCommandsList

import controllers.WorkWithCollection
import dataSet.Route
import dataSet.RouteComporator
import usersView.AnswerToUser
import usersView.ConsoleWriter
import java.util.*

/**
 * Class RemoveAllByDistance. Delete all objects with the given distance.
 *
 * @author jutsoNNN
 * @since 1.0.0
 */
class RemoveAllByDistance: Command {
    override fun execute(str: List<Any>, workWithCollection: WorkWithCollection) {
        val answerToUser: AnswerToUser = AnswerToUser()

        val checkDistance = str[0]


        val consoleWriter: ConsoleWriter = ConsoleWriter()
        val collection = PriorityQueue<Route>(RouteComporator())
        collection.addAll(workWithCollection.getCollection())

        if (collection.size == 0){
            consoleWriter.printToConsoleLn("emptyCollection")
        }else if(collection.size == 1){
            if (collection.peek().distance == checkDistance){
                workWithCollection.getCollection().clear()
                consoleWriter.printToConsoleLn("cleared")
            }else{
                consoleWriter.printToConsoleLn("noDistance")
            }
        }else{
            workWithCollection.getCollection().clear()
            for (i in 0..collection.size - 1){
                if (collection.peek().distance == checkDistance){
                    collection.poll()
                    consoleWriter.printToConsoleLn("cleared")
                }else{
                    workWithCollection.getCollection().add(collection.peek())
                    collection.poll()
                }
            }
        }
    }
}