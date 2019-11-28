package id.co.iconpln.worldleadersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_leaders.*

class DetailLeadersActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_IMAGE_URL = "extra_image_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_leaders)

        displayLeaderDetail()
    }

    private fun displayLeaderDetail() {
        tvTitleDetail.text = intent.getStringExtra(EXTRA_NAME)
        tvDescDetail.text = intent.getStringExtra(EXTRA_DESC)
        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_IMAGE_URL))
            .apply(
                RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
            )
            .into(ivPictDetail)
    }
}
