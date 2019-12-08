package com.sdvstark.ststest.model

import com.sdvstark.ststest.abstraction.EntityInfoModel
import com.sdvstark.ststest.util.*
import java.io.Serializable
import java.util.*

class Event : EntityInfoModel, Serializable {

    var startTime: Date? = null

    var endTime: Date? = null

    var name: String? = null


    override val shortDescription: String
            by lazy {
                stringBuilder {
                    append("Название - Event")
                    returnCarriage()
                    startTime?.let {
                        append("startTime")
                    }
                    returnCarriage()
                    endTime?.let {
                        append("endTime")
                    }
                    returnCarriage()
                    name?.let {
                        append("name")
                    }
                }
            }
    override val detailedDescription: String by lazy {
        stringBuilder {
            append("Название - Notice")
            returnCarriage()
            name?.let {
                append("name = $name")
            }
            returnCarriage()
            if (endTime != null) {
                append("endTime = ${endTime!!.toStringPattern(DEFAULT_PATTERN)}")
            }
            returnCarriage()
            name?.let {
                append("name = $name")
            }
        }
    }

    companion object{
        const val ORDINAL = 1
    }

}

fun Event.Companion.newInstance(): Event {
    return Event().apply {
        val (start, end) = generateRandomDateRange()
        startTime = start
        endTime = end
        name = eventList.random()
    }
}

val eventList = listOf(
    "celebration",
    "sadness",
    "disaster",
    "happiness",
    "birth"
)