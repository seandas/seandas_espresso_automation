package com.logindemotest.uitests

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.logindemotest.pageObjects.LoginPage
import com.logindemotest.testUtils.Utilities
import com.sourcey.materiallogindemo.MainActivity
import junit.framework.Assert.assertFalse
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InvalidLoginTests : Utilities() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    private val loginPage = LoginPage()


    @Test
    fun testLoginWithInvalidEmail() {
        loginPage.enterEmail("test@testcom")
            .enterPassword("a12@sa#")
            .clickLoginButton()

        // wait 1 sec for toast msg to appear(may not need)
        Thread.sleep(1000)
        // validate login failed toast msg is displayed
        onView(withText("Login failed")).inRoot(isToast()).check(matches(isDisplayed()))

        // validate user failed to proceed to next screen
        assertFalse("Invalid login succeeded!", isElementVisible(onView(withText("Hello world!"))))
    }


    @Test
    fun testLoginWithInvalidPassword() {
        loginPage.enterEmail("test@test.com")
            .enterPassword("a12@sa#adfafdafd")
            .clickLoginButton()

        // wait 1 sec for toast msg to appear(may not need)
        Thread.sleep(1000)
        // validate login failed toast msg is displayed
        onView(withText("Login failed")).inRoot(isToast()).check(matches(isDisplayed()))

        // validate user failed to proceed to next screen
        assertFalse("Invalid login succeeded!", isElementVisible(onView(withText("Hello world!"))))
    }
}
