package id.co.iconpln.worldleadersapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter(val context: Context, val listWorldLeaders: ArrayList<WorldLeaders>):BaseAdapter() {
    override fun getView(index: Int, view: View?, viewGroup: ViewGroup?): View {
        val viewLayout = LayoutInflater.from(context)
            .inflate(R.layout.item_list_leaders, viewGroup, false)

        val viewHolder = ViewHolder(viewLayout)
        val leaders = getItem(index) as WorldLeaders
        viewHolder.bind(context, leaders)

        return viewLayout
    }

    override fun getItem(index: Int): Any {
        return listWorldLeaders[index]
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getCount(): Int {
        return listWorldLeaders.size
    }

    private inner class ViewHolder(view: View) {
        private val tvLeadersName: TextView = view.findViewById(R.id.tvTitle)
        private val tvLeadersDesciption: TextView = view.findViewById(R.id.tvDescription)
        private val ivLeadersPhoto: ImageView = view.findViewById(R.id.ivImage)

        fun bind(context: Context, hero: WorldLeaders) {
            tvLeadersName.text = hero.name
            tvLeadersDesciption.text = hero.desc
        }
    }
}