package com.sourcey.materiallogindemo.uitests

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.sourcey.materiallogindemo.MainActivity
import com.sourcey.materiallogindemo.pageObjects.LoginPage
import com.sourcey.materiallogindemo.testUtils.Utilities
import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ValidLoginTests : Utilities() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    val loginPage = LoginPage()

    @Test
    fun testLoginWithValidCredentials() {
        loginPage.enterEmail("test@test.com")
            .enterPassword("a12@sa#")
            .clickLoginButton()

        assertTrue("Valid login failed!", isElementVisible(onView(withText("Hello world!"))))

    }


}
