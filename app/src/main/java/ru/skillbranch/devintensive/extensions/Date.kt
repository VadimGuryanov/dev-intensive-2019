package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, timeUnits: TimeUnits): Date {
    this.time += when (timeUnits) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    return this
}

fun Date.humanizeDiff(): String {
    val time = Date().time - this.time
    if (time > 0) {
        return when (time) {
            in 0..SECOND -> "только что"
            in SECOND..(45* SECOND) -> "несколько секунд назад"
            in (45* SECOND)..(75* SECOND) -> "минуту назад"
            in (75* SECOND)..(45* MINUTE) -> "${time / MINUTE} минут назад"
            in (45* MINUTE)..(75* MINUTE) -> "час назад"
            in (75* MINUTE)..(22* HOUR) -> "${time / HOUR} часов назад"
            in (22* HOUR)..(26* HOUR) -> "день назад"
            in (26* HOUR)..(360* DAY) -> "${time / DAY} дней назад"
            else -> "более года назад"
        }
    } else {
        return when (-time) {
            in SECOND..(45* SECOND) -> "через несколько секунд"
            in (45* SECOND)..(75* SECOND) -> "через минуту"
            in (75* SECOND)..(45* MINUTE) -> "через ${-time / MINUTE} минут"
            in (45* MINUTE)..(75* MINUTE) -> "через час"
            in (75* MINUTE)..(22* HOUR) -> "через ${-time / HOUR} часов"
            in (22* HOUR)..(26* HOUR) -> "через день"
            in (26* HOUR)..(360* DAY) -> "через ${-time / DAY} дней"
            else -> "более чем через год"
        }
    }
}

enum class TimeUnits {
    SECOND, MINUTE, HOUR, DAY
}

fun TimeUnits.plural(value: Int): String = when(this.ordinal) {
    0 -> "$value секунду"
    1 -> "$value минут"
    2 -> "$value часов"
    else -> "$value дня"
}
