package it.nova.scanner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/** Due pagine di presentazione; dalla seconda si avvia la scansione. */
class IntroActivity : AppCompatActivity() {

    private var page = 0
    private lateinit var page1: View
    private lateinit var page2: View
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        page1 = findViewById(R.id.page1)
        page2 = findViewById(R.id.page2)
        button = findViewById(R.id.introButton)
        page = savedInstanceState?.getInt("page") ?: 0
        show()
        page1.setOnClickListener { page = 1; show() }
        button.setOnClickListener {
            if (page == 0) { page = 1; show() }
            else startActivity(Intent(this, ScanActivity::class.java))
        }
    }

    private fun show() {
        page1.visibility = if (page == 0) View.VISIBLE else View.GONE
        page2.visibility = if (page == 1) View.VISIBLE else View.GONE
        button.text = if (page == 0) "Avanti  ›" else "START"
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (page == 1) { page = 0; show() } else super.onBackPressed()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("page", page)
    }
}
