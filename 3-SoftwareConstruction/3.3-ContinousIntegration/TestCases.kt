const val SUCCESS = 1
const val PERIOD_ERROR = -1
const val BRIGHTNESS_ERROR = -2

fun setLightParams(checkTime: Int?, minBrightness: Float?): Int {
    if (checkTime == null || checkTime < 0 || checkTime > 99) return PERIOD_ERROR;
    if (minBrightness == null || minBrightness < 0 || minBrightness > 1) return BRIGHTNESS_ERROR

    return SUCCESS;
}

class LightParamsTest {
    fun testCase1_1() : Any {
        println("TC 1.1 (parameters pass validation; (checkTime = 1, minBrightness = 0.75f) = 1)")
        val tcResult = setLightParams(checkTime = 1, minBrightness = 0.75f)
        return if (tcResult == 1) 1 else System.exit(-1)
    }

    fun testCase1_2() : Any {
        println("TC 1.1 (parameters don't pass validation; (checkTime = -1, minBrightness = 0.5f) = -1)")
        val tcResult = setLightParams(checkTime = -1, minBrightness = 0.5f)
        return if (tcResult == -1) -1 else System.exit(-1)
    }

    fun testCase1_3() : Any {
        println("TC 1.1 (parameters don't pass validation; (checkTime = 1, minBrightness = -2f) = -2)")
        val tcResult = setLightParams(checkTime = 1, minBrightness = -2f)
        return if (tcResult == -2) -2 else System.exit(-1)
    }
}

fun main() {
    val lightParamsTest = LightParamsTest()
    
    lightParamsTest.testCase1_1()
    lightParamsTest.testCase1_2()
    lightParamsTest.testCase1_3()

    System.exit(0)
}
