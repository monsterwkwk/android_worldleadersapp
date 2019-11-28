package id.co.iconpln.worldleadersapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list: ArrayList<WorldLeaders> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadListBaseAdapter(this)
        setListItemClickListener(lvListLeader)
    }

    private fun setListItemClickListener(listView: ListView) {
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(adapterView: AdapterView<*>?, view: View?, index: Int, l: Long) {
                showDetailLeader(list[index])
            }
        }
    }

    private  fun showDetailLeader(leaders: WorldLeaders) {
        val detailLeadersIntent = Intent(this, DetailLeadersActivity::class.java)
        // sending data
        detailLeadersIntent.putExtra(DetailLeadersActivity.EXTRA_NAME, leaders.name)
        detailLeadersIntent.putExtra(DetailLeadersActivity.EXTRA_DESC, leaders.desc)
        detailLeadersIntent.putExtra(DetailLeadersActivity.EXTRA_IMAGE_URL, leaders.photo)
        startActivity(detailLeadersIntent)
    }

    fun loadListBaseAdapter(context: Context) {
        list.addAll(WorldLeadersData.listDataWorldLeaders)

        val baseAdapter = ListViewAdapter(context, list)
        lvListLeader.adapter = baseAdapter
    }

}
