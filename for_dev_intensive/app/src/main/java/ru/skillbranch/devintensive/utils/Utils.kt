package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

object Utils {

    fun parseFullName(fullName: String?) : Pair<String?, String?>{
        val fullNameList = fullName?.split(" ")
        val firstName = fullNameList?.getOrNull(0)
        val lastName = fullNameList?.getOrNull(1)
        return firstName to lastName
    }

    fun toInitials(fullName: String?, lastName: String?): String? {
        val initalsFullName = supToInitials(fullName)
        val initalsLastName = supToInitials(lastName)
        return when {
            initalsFullName == null -> null
            initalsLastName == null -> initalsFullName.toString()
            else -> "$initalsFullName$initalsLastName"
        }
    }

    private fun supToInitials(str: String?): Char? = str?.let {
        if (it.isEmpty() || it == " ") return@let null
        it[0].toUpperCase()
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val latTrasStr = StringBuilder()
        for (char in payload) {
            latTrasStr.apply {
                trasWhen(char, latTrasStr, divider)
            }
        }
        return latTrasStr.toString()
    }

    private fun trasWhen(char: Char, latTrasStr: StringBuilder, divider: String) {
        latTrasStr.apply {
            when(char) {
                'а' -> append("a")
                'б' -> append("b")
                'в' -> append("v")
                'г' -> append("g")
                'д' -> append("d")
                'е' -> append("e")
                'ё' -> append("e")
                'ж' -> append("zh")
                'з' -> append("z")
                'и' -> append("i")
                'й' -> append("i")
                'к' -> append("k")
                'л' -> append("l")
                'м' -> append("m")
                'н' -> append("n")
                'о' -> append("o")
                'п' -> append("p")
                'р' -> append("r")
                'с' -> append("s")
                'т' -> append("t")
                'у' -> append("u")
                'ф' -> append("f")
                'х' -> append("h")
                'ц' -> append("c")
                'ч' -> append("ch")
                'ш' -> append("sh")
                'щ' -> append("sh'")
                'ъ', 'ь' -> append("")
                'ы' -> append("i")
                'э' -> append("e")
                'ю' -> append("yu")
                'я' -> append("ya")
                else -> append(divider)
            }
        }
    }
}

