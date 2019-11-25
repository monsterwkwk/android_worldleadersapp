package id.co.iconpln.worldleadersapp

import android.content.Context
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
            override fun onItemClick(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                Toast.makeText(this@MainActivity, "Show toast event", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun loadListBaseAdapter(context: Context) {
        list.addAll(WorldLeadersData.listDataWorldLeaders)

        val baseAdapter = ListViewAdapter(context, list)
        lvListLeader.adapter = baseAdapter
    }

}
