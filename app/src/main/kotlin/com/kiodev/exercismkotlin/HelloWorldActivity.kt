package com.kiodev.exercismkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hello_world.*

/**
 * Hello World Activity
 *
 * Write a program that greets the user by name, or by saying "Hello, World!" if no name is given.
 *
 * http://exercism.io/exercises/go/hello-world/readme
 */
class HelloWorldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        setTitle(R.string.hello_world)

        var greetingText = formattedGreeting("");
        text_hello_main.setText(greetingText)

        // Really this is the way?
        // https://discuss.kotlinlang.org/t/java-string-format-alternative-in-kotlin/703
        button_greeting.setOnClickListener {
            // Isn't Kotlin supposed to autocast? Why do I need toString()?
            var greeting = formattedGreeting(edit_name.getText().toString())
            text_hello_main.setText(greeting)
        }
    }

    // Note that in Kotlin, parameters are IMMUTABLE, ie, cannot be changed:
    // http://blog.jetbrains.com/kotlin/2013/02/kotlin-m5-1/
    private fun formattedGreeting(name: String): String {
        var greeting: String

        if (name.isEmpty())
            greeting = "World"
        else
            greeting = name

        return getString(R.string.hello_world_formatted).format(greeting)
    }
}