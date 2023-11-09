import android.os.Parcelable
import com.example.safeco.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.parcelize.Parcelize
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.safeco.repos.LightParamsRepo
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

// Клас LightParams використовується для представлення параметрів освітлення
// і позначений анотацією @Parcelize для передачі між активностями.
@Parcelize
data class LightParams(
    val checkTime: Int,
    val minBrightness: Float
) : Parcelable

// Клас LightParamsRepo відповідає за зберігання параметрів освітлення в базі даних Firebase.
class LightParamsRepo {
    private val database = FirebaseDatabase.getInstance()
    private val lightParamsRef = database.reference.child("light_params")

    // Додає параметри освітлення до бази даних за заданим ідентифікатором користувача.
    fun add(uid: String, lightParams: LightParams) {
        lightParamsRef.child(uid).setValue(lightParams)
    }
}

class LightActivity : AppCompatActivity() {
    private lateinit var finishButton: Button
    private lateinit var timePeriod: TextView
    private lateinit var minBrightVal: TextView
    private val currentUser = Firebase.auth.currentUser
    private val lightParamsRepo = LightParamsRepo()

    // Константи для позначення результатів операцій.
    private companion object {
        private const val SUCCESS = 1
        private const val PERIOD_ERROR = -1
        private const val BRIGHTNESS_ERROR = -2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light)

        finishButton = findViewById(R.id.finishAdjustButton)
        timePeriod = findViewById(R.id.editPeriod)
        minBrightVal = findViewById(R.id.editMinBright)

        finishButton.setOnClickListener {
            // Встановлює параметри освітлення та обробляє результати.
            val result = setLightParams(
                checkTime = timePeriod.text.toString().toIntOrNull(),
                minBrightness = minBrightVal.text.toString().toFloatOrNull()
            )

            when (result) {
                PERIOD_ERROR -> {
                    // Обробка помилки некоректного формату періоду.
                    Toast.makeText(this, "Invalid time period format!", Toast.LENGTH_SHORT).show()
                }
                BRIGHTNESS_ERROR -> {
                    // Обробка помилки некоректного формату мінімальної яскравості.
                    Toast.makeText(this, "Invalid minimal brightness format!", Toast.LENGTH_SHORT).show()
                }
                SUCCESS -> {
                    // Успішне завершення налаштування параметрів освітлення.
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Success")
                    builder.setMessage("Light parameters were successfully adjusted.")
                    builder.setPositiveButton("OK") { _, _ ->
                        finish()
                    }
                    builder.create().show()
                }
            }
        }
    }

    // Функція для встановлення параметрів освітлення та збереження їх у базу даних.
    private fun setLightParams(checkTime: Int?, minBrightness: Float?): Int {
        if (checkTime == null || checkTime < 0 || checkTime > 99) return PERIOD_ERROR
        if (minBrightness == null || minBrightness < 0 || minBrightness > 1) return BRIGHTNESS_ERROR

        // Зберігаємо параметри освітлення в базу даних.
        val lightParams = LightParams(checkTime = checkTime, minBrightness = minBrightness)
        lightParamsRepo.add(uid = currentUser!!.uid, lightParams = lightParams)

        return SUCCESS
    }
}
