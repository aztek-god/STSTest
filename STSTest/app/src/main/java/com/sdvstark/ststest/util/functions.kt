package com.sdvstark.ststest.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.sdvstark.ststest.abstraction.EntityInfoModel
import com.sdvstark.ststest.model.Event
import com.sdvstark.ststest.model.Move
import com.sdvstark.ststest.model.Notice
import com.sdvstark.ststest.model.newInstance
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.transform.Transformer

val defaultLocale = Locale.ENGLISH

const val DEFAULT_PATTERN = "yyyy-MM-dd"


fun generateRandomDateRange(): Pair<Date, Date> {
    val date1 = Date(kotlin.math.abs(Random(System.currentTimeMillis()).nextInt().toLong()))
    val date2 = Date(kotlin.math.abs(Random(System.currentTimeMillis()).nextInt().toLong()))

    return if (date1 > date2) {
        Pair(date2, date1)
    } else {
        Pair(date1, date2)
    }
}

fun Date.toStringPattern(pattern: String): String? {
    val sdf = SimpleDateFormat(pattern, defaultLocale)

    return try {
        sdf.format(this)
    } catch (ex: IllegalArgumentException) {
        null
    }
}

fun stringBuilder(transformer: StringBuilder.() -> Unit): String {

    val builder = StringBuilder()

    builder.transformer()

    return builder.toString()
}

fun StringBuilder.space() {
    append(" ")
}

fun StringBuilder.returnCarriage() {
    append("\n")
}

val currentTimeMillis get() = System.currentTimeMillis()


// object lifting
private val random = Random()

fun generateEntityList(): List<EntityInfoModel> {

    val mutableList = mutableListOf<EntityInfoModel>()

    val amountOfEntities = random.nextInt(MAX_AMOUNT - MIN_AMOUNT)

    repeat((MIN_AMOUNT..(amountOfEntities + MIN_AMOUNT)).count()) {
        when (random.nextInt(ENTITY_INSTANCE_BOUND)) {
            Notice.ORDINAL -> {
                mutableList.add(Notice.newInstance())
            }
            Event.ORDINAL -> {
                mutableList.add(Event.newInstance())
            }
            Move.ORDINAL -> {
                mutableList.add(Move.newInstance())
            }
        }
    }

    return mutableList
}


private const val ENTITY_INSTANCE_BOUND = 3
private const val MIN_AMOUNT = 10
private const val MAX_AMOUNT = 100


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, attachToRoot)
}
