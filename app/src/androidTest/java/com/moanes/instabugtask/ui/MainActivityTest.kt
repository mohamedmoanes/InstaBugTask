package com.moanes.instabugtask.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.moanes.instabugtask.R
import com.moanes.instabugtask.testutils.CustomAssertions.Companion.hasItemCount
import com.moanes.instabugtask.testutils.CustomMatchers.Companion.withItemCount
import com.moanes.instabugtask.testutils.FakeWordsList
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
       activityRule.scenario.onActivity{
           val adapter=WordsAdapter()
           it.wordsListRV.adapter=adapter
           it.wordsListRV.layoutManager= LinearLayoutManager(it)
           adapter.submitList(FakeWordsList.wordsList)
       }
    }

    @Test
    fun test_isListVisible_onAppLaunch() {
        onView(withId(R.id.wordsListRV)).check(matches(isDisplayed()))
    }


    @Test
    fun countPrograms() {
        onView(withId(R.id.wordsListRV))
            .check(matches(withItemCount(4)))
    }

    @Test
    fun countProgramsWithViewAssertion() {
        onView(withId(R.id.wordsListRV))
            .check(hasItemCount(4))
    }
}