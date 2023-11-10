package com.example.safeco

import android.widget.Toast
import androidx.appcompat.app.AlertDialog

// Функція `programMethodsUsingExmpl` демонструє приклади використання методів програмних класів і взаємодії
fun programMethodsUsingExmpl() {
    // Приклад успішної взаємодії з `LightActivity`. Метод `setLightParams` викликається з правильними значеннями,
    // які успішно проходять перевірки в класі. Результат `SUCCESS` вказує на успішне налаштування параметрів освітлення.
    when (LightActivity().setLightParams(checkTime = 1, minBrightness = 0.75f)) {
        LightActivity.SUCCESS -> {
            // Відображається сповіщення про успішну операцію з можливістю завершення активності.
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Success")
            builder.setMessage("Light parameters were successfully adjusted.")
            builder.setPositiveButton("OK") { _, _ ->
                finish()
            }
            builder.create().show()
        }
    }

    // Приклад неуспішної взаємодії з `LightActivity`. Метод `setLightParams` викликається з неправильними значеннями,
    // які не проходять перевірки в класі. Результат `PERIOD_ERROR` вказує на помилковий період часу.
    when (LightActivity().setLightParams(checkTime = -1, minBrightness = 0.5f)) {
        LightActivity.PERIOD_ERROR -> {
            // Відображається сповіщення про помилковий формат періоду.
            Toast.makeText(this, "Invalid time period format!", Toast.LENGTH_SHORT).show()
        }
    }

    // Аналогічні приклади неуспішної взаємодії з `LightActivity`, де метод `setLightParams` викликається з
    // неправильними значеннями, що не проходять перевірки. Результат `BRIGHTNESS_ERROR` вказує
    // на помилковий формат мінімальної яскравості.
    when (LightActivity().setLightParams(checkTime = 15, minBrightness = 1.5f)) {
        LightActivity.BRIGHTNESS_ERROR -> {
            Toast.makeText(this, "Invalid minimal brightness format!", Toast.LENGTH_SHORT).show()
        }
    }

    // Приклад неуспішної взаємодії з `LightActivity`. Метод `setLightParams` викликається з неправильними значеннями,
    // які не проходять перевірки в класі. Результат `PERIOD_ERROR` вказує на помилковий період часу.
    when (LightActivity().setLightParams(checkTime = 101, minBrightness = 0.7f)) {
        LightActivity.PERIOD_ERROR -> {
            Toast.makeText(this, "Invalid time period format!", Toast.LENGTH_SHORT).show()
        }
    }
}
