package id.co.iconpln.worldleadersapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list: ArrayList<WorldLeaders> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadListBaseAdapter(this)
    }

    fun loadListBaseAdapter(context: Context) {
        list.addAll(WorldLeadersData.listDataWorldLeaders)

        val baseAdapter = ListViewAdapter(context, list)
        lvListLeader.adapter = baseAdapter
    }

}
