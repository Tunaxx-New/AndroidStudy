package com.nik.diceassignment

import com.nik.diceassignment.Dice
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DiceUnitTest {

    @Test
    fun whenDiceConstructorIsValid() {
        val dice: Dice = Dice(100)
        val number: Int = dice.roll()
        print(number)
        assert(number > 0)
    }

    @Test
    fun whenNumberIsLucky() {
        val dice: Dice = Dice()
        var iteration = 0
        while (!dice.isLucky() && iteration < 100) {
            println(dice.roll())
            iteration++
        }
        println(dice.result())
        assert(iteration < 100)
    }

}
