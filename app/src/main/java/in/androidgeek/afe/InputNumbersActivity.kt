package `in`.androidgeek.afe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_input_numbers.*

class InputNumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_numbers)

        send.setOnClickListener {

            val pair = isInputValid()
            if (pair != null) {
                sendDataToFlutterModule(pair.first, pair.second)
            }
        }
    }

    private fun sendDataToFlutterModule(first: Int, second: Int) {
        FlutterViewActivity.startActivity(this)
    }

    private fun isInputValid(): Pair<Int, Int>? {
        val number1 = et_number_1.text.toString()
        val number2 = et_number_2.text.toString()

        when {
            number1.isBlank() -> showToast("Please enter first number")
            number2.isBlank() -> showToast("Please enter second number")
            else -> return Pair(number1.toInt(), number2.toInt())
        }

        return null
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}
