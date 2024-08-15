package dts.pnj.rizqifathurrohman.pendataanalumni

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailNewsAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val imageView = findViewById<ImageView>(R.id.detail_image)

        val intent = intent
        val title = intent.getStringExtra("EXTRA_TITLE")
        val content = intent.getStringExtra("EXTRA_CONTENT")
        val imagePath = intent.getStringExtra("EXTRA_IMAGE_PATH")

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val titleTextView = findViewById<TextView>(R.id.detail_title)
        val contentTextView = findViewById<TextView>(R.id.detail_content)

        titleTextView.text = title
        contentTextView.text = content

        // Load the image from drawable resource
        val imageResource = when (imagePath) {
            "drawable/w15" -> R.drawable.w15
            "drawable/ferrari" -> R.drawable.ferrari
            "drawable/redbull" -> R.drawable.redbull
            "drawable/charlewis" -> R.drawable.charlewis
            "drawable/rb19" -> R.drawable.rb19
            "drawable/newey" -> R.drawable.newey
            "drawable/wolf" -> R.drawable.wolf
            "drawable/rally" -> R.drawable.rally
            "drawable/fiarules" -> R.drawable.fiarules
            "drawable/vegasgp" -> R.drawable.vegasgp
            "drawable/schumi" -> R.drawable.schumi
            else -> R.drawable.ic_berita
        }
        imageView.setImageResource(imageResource)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}