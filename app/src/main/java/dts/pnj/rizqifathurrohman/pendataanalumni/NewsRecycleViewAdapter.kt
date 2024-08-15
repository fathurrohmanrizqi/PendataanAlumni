package dts.pnj.rizqifathurrohman.pendataanalumni

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dts.pnj.rizqifathurrohman.databinding.FragmentBeritaBinding

class NewsRecycleViewAdapter(
    private val values: List<NewsItem>
) : RecyclerView.Adapter<NewsRecycleViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentBeritaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title
        holder.content.text = item.content

        // Load the image from drawable resource
        val imageResource = when (item.pathImage) {
            "drawable/tech_update" -> R.drawable.w15
            "drawable/sports_highlights" -> R.drawable.ferrari
            "drawable/world_news" -> R.drawable.redbull
            else -> R.drawable.ic_berita // Placeholder or default image
        }
        holder.image.setImageResource(imageResource)

        // Set up click listener
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailNewsAct::class.java).apply {
                putExtra("EXTRA_TITLE", item.title)
                putExtra("EXTRA_CONTENT", item.content)
                putExtra("EXTRA_IMAGE_PATH", item.pathImage)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentBeritaBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val content = binding.content
        val image = binding.itemImage

        override fun toString(): String {
            return super.toString() + " '" + content.text + "'"
        }
    }
}