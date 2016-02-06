package com.kiodev.exercismkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_leap_year.*

/**
 * Leap Year Activity
 *
 * Write a program that will take a year and report if it is a leap year.
 * The tricky thing here is that a leap year in the Gregorian calendar occurs:
 *          on every year that is evenly divisible by 4
 *          except every year that is evenly divisible by 100
 *          unless the year is also evenly divisible by 400
 *
 * For example, 1997 is not a leap year, but 1996 is. 1900 is not a leap year, but 2000 is.
 *
 * http://exercism.io/exercises/go/leap
 */
class LeapYearActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leap_year)

        button_check_year.setOnClickListener{
            var responseToUser = validateInput(edit_year.text.toString())
            text_comment.text = responseToUser
        }
    }

    fun validateInput(input: String): String{
        var response = getString(R.string.bad_data)

        if(input.length > 0 && input.length <= 4)
            response = checkIfLeapYear(input)

        return response
    }

    fun checkIfLeapYear(input: String): String {
        var intYear: Int = input.toInt()
        var isLeapYear = false
        var response = getString(R.string.non_leap_year)

        if(intYear % 4 == 0){
            isLeapYear = true
            if(intYear % 100 == 0) {
                isLeapYear = false
                if(intYear % 400 == 0) {
                    isLeapYear = true
                }
            }
        }

        if(isLeapYear){
            response = getString(R.string.leap_year)
        }

        return response
    }

}