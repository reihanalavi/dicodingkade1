package com.reihanalavi.hellokotlin.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.reihanalavi.hellokotlin.model.Item
import com.reihanalavi.hellokotlin.R
import com.reihanalavi.hellokotlin.R.id.img_club
import com.reihanalavi.hellokotlin.R.id.txt_club
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by rehan on 5/17/2018.
 */
class Adapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItem(items[position], listener)

    }

    class ClubUI: AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout() {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.img_club
                    }.lparams {
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = R.id.txt_club
                        textSize = 16f
                    }.lparams {
                        margin = dip(16)
                    }

                }
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val name: TextView = view.find(txt_club)
        private val image: ImageView = view.find(img_club)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)
            itemView.onClick { listener(items) }

        }

    }

}