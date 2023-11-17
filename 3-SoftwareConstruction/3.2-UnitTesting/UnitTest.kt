package com.example.safeco.unitTest

import com.example.safeco.LightActivity
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LightParamsTest {
    @Test
    fun testCase1_1() {
        val tcResult = LightActivity.setLightParams(checkTime = 1, minBrightness = 0.75f)
        assertEquals(1, tcResult)
    }

    @Test
    fun testCase1_2() {
        val tcResult = LightActivity.setLightParams(checkTime = -1, minBrightness = 0.5f)
        assertEquals(-1, tcResult)
    }

    @Test
    fun testCase1_3() {
        val tcResult = LightActivity.setLightParams(checkTime = 1, minBrightness = -2f)
        assertEquals(-2, tcResult)
    }
}
