package com.example.listsarray

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.list_item_color.view.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    val colors= arrayOf("red", "green", "blue",
        "cyan", "magenta", "yellow",
        "black", "white", "gray",
        "maroon", "fuchsia",
        "navy", "olive", "teal")

    val numlist= arrayListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 1..1000){
            numlist.add(i)
        }

//        val coloradaptor=ArrayAdapter<String>(this,
//            R.layout.list_item_color,
//            R.id.tvcolors,
//            colors)



        val coloradapter=ColorAdapter(this,numlist,colors)
        lvcolors.adapter=coloradapter


        lvcolors.setOnItemClickListener { parent, view, pos, id ->

            Toast.makeText(this,"Clicked on $pos : ${view.tvcolors.text}",Toast.LENGTH_SHORT).show()
        }


    }
    class ColorAdapter(val context:Context,val nums: ArrayList<Int>,val col:Array<String>):BaseAdapter(){



        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val id=nums[position]
            val colorName=col[position%col.size]
            val colname= Color.parseColor(colorName)

            Log.d("LIST","$position:$convertView")

            val li=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemView =(convertView)?:li.inflate(R.layout.list_item_color, parent, false)




            itemView.llcolor.setBackgroundColor(colname)
            itemView.tvcolors.text = colorName
            itemView.tvid.text = id.toString()
            return itemView
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {

            return 0
        }

        override fun getCount(): Int {


            return nums.size
        }

    }
}

