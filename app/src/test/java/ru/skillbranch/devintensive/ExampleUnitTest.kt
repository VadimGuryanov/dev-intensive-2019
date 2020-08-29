package ru.skillbranch.devintensive

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun stripHtml() {
        println("""<p class="title">Образовательное IT-сообщество Skill Branch</p>""".stripHtml())
        println("""Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»""".truncate())
        println("""Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»""".truncate(15))
    }

    @Test
    fun builder() {
        print(
            User.Builder()
            .id("1")
            .firstName("vadim")
            .lastName("guruanov")
            .build().toString())
    }

    @Test
    fun factory() {
        print(User.Factory.makeUser("user"))
        print(User.Factory.makeUser("user1"))
    }

    @Test
    fun date() {
        println(Date())
        println(Date().add(-2, TimeUnits.HOUR))
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff()) //2 часа назад
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff()) //5 дней назад
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff()) //через 2 минуты
        println(Date().add(7, TimeUnits.DAY).humanizeDiff()) //через 7 дней
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff()) //более года назад
        println(Date().add(400, TimeUnits.DAY).humanizeDiff()) //более чем через год
    }

    @Test
    fun dateFormat() {
        println(Date().format())
        println(Date().format("HH:mm"))
        println(Date().format("HH"))
    }

    @Test
    fun utils() {
        println(Utils.parseFullName("Vadim Guruanov"))
        println(Utils.toInitials("vadim", "guruanv"))
        println(Utils.toInitials("vadim", null))
        println(Utils.toInitials(null, "vvv"))
        println(Utils.toInitials(null, null))
        println(Utils.transliteration("вадим гурьянов", "-"))
        println(Utils.transliteration("вадим гурьянов"))
    }

    @Test
    fun plural() {
        println(TimeUnits.SECOND.plural(1)) //1 секунду
        println(TimeUnits.MINUTE.plural(4)) //4 минуты
        println(TimeUnits.HOUR.plural(19)) //19 часов
        println(TimeUnits.DAY.plural(222)) //222 дня
    }
}
