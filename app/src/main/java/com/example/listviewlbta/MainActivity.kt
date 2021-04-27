package com.example.listviewlbta

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView = findViewById<ListView>(R.id.main_listview)
    //    val redColor = Color.parseColor("#FF0000")
    //    listView.setBackgroundColor(redColor)

        listView.adapter = MyCustomAdapter(this) // this needs to be my custom adapter telling my list what to render
    }

    private class MyCustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context

        private val names = arrayListOf<String>(
            "Communication", "Journey", "City", "Accommodation", "Means of communication", "Purchases", "Health", "Leisure", "Slang expressions"

        )

        init {
             mContext = context
        }

        // responsible for how many rows in my list
        override fun getCount(): Int {
            return names.size
        }

        // you can also ignore this
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // you can ignore this for now
        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        // responsible for rendering out each row
        @SuppressLint("SetTextI18n")
        override fun getView(position: Int, convertview: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = names.get(position)

            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "Row number: $position"

            return rowMain


//          val textView = TextView(mContext)
//          textView.text = "HERE is my ROW for my LISTVIEW"
//          return textView
        }
    }
}

