package com.logindemotest.testUtils

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.Root
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher

open class Utilities {


    fun clickElement(text: String) {
        onView(withText(text)).perform(click())
    }


    fun clickElement(id: Int) {
        onView(withId(id)).perform(click())
    }


    //wait is added during visibility check
    fun isElementVisible(element: ViewInteraction): Boolean {
        var i = 0
        var visible = false
        while (++i <= 5) {
            try {
                element.check(matches(isDisplayed()))
                visible = true
                break
            } catch (e: NoMatchingViewException) {
                // wait 500 millisecond
                Thread.sleep(1000)
            }
        }

        return visible
    }

    fun typeText(element: ViewInteraction, text: String) {
        isElementVisible(element)
        element.perform(click(), replaceText(text))
    }

    fun isToast(): Matcher<Root?> {
        return ToastMatcher()
    }

}