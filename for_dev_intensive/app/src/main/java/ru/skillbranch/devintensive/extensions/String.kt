package ru.skillbranch.devintensive.extensions

import java.lang.StringBuilder

fun String.truncate(length: Int = 16): String {
    val str = this.trimEnd()
    if (str.length <= length) return str
    return str.substring(0, length).trimEnd() + "..."
}

fun String.stripHtml(): String {
    var str = this.substring(this.indexOf('>') + 1, this.length)
    str = str.substring(0, str.indexOf('<')).trimEnd().trimStart()
    var countScape = 0
    val strBulder = StringBuilder()
    for (char in str) {
        if (char == ' ') countScape++ else countScape = 0
        if (countScape <= 1) strBulder.append(char)
    }
    return strBulder.toString()
}
