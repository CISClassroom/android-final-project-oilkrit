package th.ac.kku.cis.mobileapp.Car

import android.content.Context
import android.content.Context as Context1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView

class commentAdapter(context: android.content.Context, toDoItemList: MutableList<write>) : BaseAdapter() {

        private val mInflater: LayoutInflater = LayoutInflater.from(context)
        private var itemList = toDoItemList


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            // create object from view
            val InforDB: String = itemList.get(position).Comment as String
           val InforDB1: String = itemList.get(position).Nametype as String
            val view: View
            val vh: ListRowHolder

            // get list view
            if (convertView == null) {
                view = mInflater.inflate(R.layout.manage_show_com, parent, false)
                vh = ListRowHolder(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolder
            }
            // add text to view
            vh.label2.text = InforDB
            vh.label3.text = InforDB1

            return view
        }

        override fun getItem(index: Int): Any {
            return itemList.get(index)
        }

        override fun getItemId(index: Int): Long {
            return index.toLong()
        }

        override fun getCount(): Int {
            return itemList.size
        }

        private class ListRowHolder(row: View?) {
            val label2: TextView = row!!.findViewById<TextView>(R.id.textView4) as TextView
            val label3: TextView = row!!.findViewById<TextView>(R.id.textView3) as TextView

        }
    }

class ListAdapter(var mCtx: Context1, var resource:Int, var items:List<cartype>)
    : ArrayAdapter<cartype>( mCtx , resource , items ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //super.getView(position, convertView, parent)

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

        val view: View = layoutInflater.inflate(resource, null)
        var tvStudentName : TextView = view.findViewById(R.id.textView5)


        var student: cartype = items[position]
        tvStudentName.text = student.nametype
        return view
    }
}