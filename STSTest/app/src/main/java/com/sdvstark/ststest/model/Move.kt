package com.sdvstark.ststest.model

import com.sdvstark.ststest.abstraction.EntityInfoModel
import com.sdvstark.ststest.util.*
import java.io.Serializable
import java.util.*


class Move : EntityInfoModel, Serializable {

    var fromPlace: String? = null

    var toPlace: String? = null

    var estimateTime: TimeInterval? = null

    override val shortDescription: String
            by lazy {
                stringBuilder {
                    append("Название - Event")
                    returnCarriage()
                    fromPlace?.let {
                        append("fromPlace")
                    }
                    returnCarriage()
                    toPlace?.let {
                        append("toPlace")
                    }
                    returnCarriage()
                    estimateTime?.let {
                        append("estimateTime")
                    }
                }
            }

    override val detailedDescription: String
            by lazy {
                stringBuilder {
                    append("Название - Notice")
                    returnCarriage()
                    fromPlace?.let {
                        append("fromPlace = $fromPlace")
                    }
                    returnCarriage()
                    if (toPlace != null) {
                        append("toPlace = $toPlace")
                    }
                    returnCarriage()
                    estimateTime?.let {
                        append(
                            "estimateTime:start = ${estimateTime!!.startDate.toStringPattern(
                                DEFAULT_PATTERN
                            )}"
                        )
                        returnCarriage()
                        append(
                            "estimateTime:end = ${estimateTime!!.endDate.toStringPattern(
                                DEFAULT_PATTERN
                            )}"
                        )
                    }
                }
            }


    companion object {
        const val ORDINAL = 2
    }
}

data class TimeInterval(val startDate: Date, val endDate: Date): Serializable

fun Move.Companion.newInstance(): Move {
    return Move().apply {
        fromPlace = getRandonCity()
        toPlace = getRandonCity()
        estimateTime = run {
            val (start, end) = generateRandomDateRange()
            TimeInterval(start, end)
        }
    }
}

fun getRandonCity(): String {
    return mCitiesList.random()
}

private val mCitiesList = listOf(
    "Moscow",
    "Milano",
    "Saint-Petersberg",
    "Warsow",
    "Los-Angeles",
    "Boston",
    "New-York",
    "Mexico",
    "Lion",
    "Budapest",
    "Prague",
    "London",
    "Barcelona",
    "Madrid",
    "Rome",
    "Berlin",
    "Paris",
    "Vienna"
)

