package dataSet

import kotlinx.serialization.Contextual
import javax.management.InvalidAttributeValueException
import java.time.LocalDate;
import kotlinx.serialization.Serializable

@Serializable
class Route {


    constructor(checkId: Long, checkName: String, checkCoordinates: Coordinates, checkCreationDate: LocalDate, checkFrom: Location, checkTo: Location, checkDistance: Long){
        id = checkId
        name = checkName
        coordinates = checkCoordinates
        creationDate = checkCreationDate
        from = checkFrom
        to = checkTo
        distance = checkDistance

    }



    public var id: Long = (1..10000).random().toLong()

    var coordinates: Coordinates

    internal var name: String
        set(value){
            if (value == ""){
                throw InvalidAttributeValueException("Поле не может быть пустым")
            }
            field = value
        }
    @Contextual
    var creationDate: LocalDate = LocalDate.now()
    var from: Location
    var to: Location
    var distance: Long

}