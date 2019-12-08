package com.sdvstark.ststest.model

import android.os.Parcelable
import com.sdvstark.ststest.abstraction.EntityInfoModel
import com.sdvstark.ststest.util.*
import java.io.Serializable
import java.util.*

data class Notice(

    val flightDate: Date? = null,

    val gate: String? = null

) : EntityInfoModel, Serializable {
    override val shortDescription: String by lazy {
        stringBuilder {
            append("Название - Notice")
            returnCarriage()
            flightDate?.let {
                append("flightDate")
            }
            returnCarriage()
            gate?.let {
                append("gate")
            }
        }
    }


    override val detailedDescription: String by lazy {
        stringBuilder {
            append("Название - Notice")
            returnCarriage()
            flightDate?.let {
                append("flightDate = ${flightDate.toStringPattern(DEFAULT_PATTERN)}")
            }
            returnCarriage()
            gate?.let {
                append("gate")
            }
        }
    }

    companion object {
        const val ORDINAL = 0
    }
}


fun Notice.Companion.newInstance(): Notice {
    return Notice(Date(currentTimeMillis), gateList.random())
}


val gateList = listOf(
    "gate - 1",
    "gate - 2",
    "gate - 3",
    "gate - 4",
    "gate - 5",
    "gate - 6"
)