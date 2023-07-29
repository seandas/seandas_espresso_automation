package com.sourcey.materiallogindemo.pageObjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.sourcey.materiallogindemo.R
import com.sourcey.materiallogindemo.testUtils.Utilities

class LoginPage : Utilities() {


    fun enterEmail(email: String): LoginPage {
        typeText(onView(withId(R.id.input_email)), email)
        return this
    }


    fun enterPassword(password: String): LoginPage {
        typeText(onView(withId(R.id.input_password)), password)
        return this
    }

    fun clickLoginButton(): LoginPage {
        clickElement(R.id.btn_login)
        return this
    }
}