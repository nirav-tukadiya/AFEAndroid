package `in`.androidgeek.afe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import io.flutter.facade.Flutter


/**
 * Created by Nirav Tukadiya on 20 Jun, 2019.
 */
class FlutterViewActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, FlutterViewActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flutterView = Flutter.createView(
            this@FlutterViewActivity,
            lifecycle, null
        )

        addContentView(
            flutterView,
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        )

    }
}