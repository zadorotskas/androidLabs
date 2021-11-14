package com.example.myapplication

import android.content.pm.ActivityInfo
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.NoActivityResumedException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testFirstToSecond() {
        launch()

        moveFromFirstToSecond()
        pressBack()

        exit()
    }

    @Test
    fun testFirstToSecondAndBack() {
        launch()

        moveFromFirstToSecond()
        moveFromSecondToFirst()

        exit()
    }

    @Test
    fun testFirstToThird() {
        launch()

        moveFromFirstToSecond()
        moveFromSecondToThird()

        pressBack()
        pressBack()

        exit()
    }

    @Test
    fun testFirstToThirdAndBack() {
        launch()

        moveFromFirstToSecond()
        moveFromSecondToThird()

        moveFromThirdToSecond()
        moveFromSecondToFirst()

        exit()
    }

    @Test
    fun testAllScreensAfterOrientationChanged() {
        checkScreenAfterOrientationChanged(R.id.fragment1)

        moveFromFirstToSecond()
        checkScreenAfterOrientationChanged(R.id.fragment2)

        moveFromSecondToThird()
        checkScreenAfterOrientationChanged(R.id.fragment3)

        openAbout()
        checkScreenAfterOrientationChanged(R.id.activity_about)
    }

    @Test
    fun testAboutFromFirst() {
        launch()
        moveToAbout()

        pressBack()
        exit()
    }

    @Test
    fun testAboutFromSecond() {
        launch()

        moveFromFirstToSecond()
        moveToAbout()

        pressBack()
        pressBack()

        exit()
    }

    @Test
    fun testAboutFromThird() {
        launch()

        moveFromFirstToSecond()
        moveFromSecondToThird()
        moveToAbout()

        pressBack()
        pressBack()
        pressBack()

        exit()
    }

    @Test
    fun testNavigationUpFromSecond() {
        launch()

        moveFromFirstToSecond()
        navigateUp(R.id.fragment1)

        exit()
    }

    @Test
    fun testNavigationUpFromThird() {
        launch()

        moveFromFirstToSecond()
        moveFromSecondToThird()

        navigateUp(R.id.fragment2)
        navigateUp(R.id.fragment1)

        exit()
    }


    @Test
    fun testNavigationUpFromAbout() {
        launch()

        moveFromFirstToSecond()
        moveFromSecondToThird()
        moveToAbout()

        navigateUp(R.id.fragment3)
        navigateUp(R.id.fragment2)
        navigateUp(R.id.fragment1)

        exit()
    }

    private fun moveFromFirstToSecond() {
        move(R.id.bnToSecond, R.id.fragment2)
    }

    private fun moveFromSecondToFirst() {
        move(R.id.bnToFirst, R.id.fragment1)
    }

    private fun moveFromSecondToThird() {
        move(R.id.bnToThird, R.id.fragment3)
    }

    private fun moveFromThirdToSecond() {
        move(R.id.bnToSecond, R.id.fragment2)
    }

    private fun move(buttonId: Int, destinationId: Int) {
        onView(withId(buttonId)).perform(click())
        onView(withId(destinationId)).check(matches(isDisplayed()))
    }

    private fun navigateUp(destinationId: Int) {
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(destinationId)).check(matches(isDisplayed()))
    }

    private fun moveToAbout() {
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    private fun checkScreenAfterOrientationChanged(id: Int) {
        onView(withId(id)).check(matches(isDisplayed()))

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(300)

        onView(withId(id)).check(matches(isDisplayed()))

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(300)

        onView(withId(id)).check(matches(isDisplayed()))
    }

    private fun exit() {
        try {
            pressBack()
            fail()
        } catch (e: NoActivityResumedException) {
            // it's good, app was closed
        }
    }

    private fun launch() {
        launchActivity<MainActivity>()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }
}