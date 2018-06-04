package com.reihanalavi.hellokotlin.activity

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var name: String = ""
    private var desc = ""
    private var img = 0

    lateinit var txtName: TextView
    lateinit var txtDesc: TextView
    lateinit var imgClub: ImageView

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout() {
            padding = dip(16)

            imgClub = imageView()
                    .lparams(width = matchParent, height = dip(150)) {
                        gravity = Gravity.CENTER
                    }

            txtName = textView() {
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                textSize = sp(14).toFloat()
                typeface = Typeface.DEFAULT_BOLD
                topPadding = dip(16)
            }

            txtDesc = textView() {
                topPadding = dip(16)
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        }

        val i = intent
        name = i.getStringExtra("name")
        desc = i.getStringExtra("desc")
        img = i.getIntExtra("image", 0)

        txtName.text = name
        txtDesc.text = desc
        imgClub.setImageResource(img)
    }
}
