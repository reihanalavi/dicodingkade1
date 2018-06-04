package com.reihanalavi.hellokotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.reihanalavi.hellokotlin.R.array.*
import com.reihanalavi.hellokotlin.adapter.Adapter
import com.reihanalavi.hellokotlin.model.Item
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    //private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MainActivityUI().setContentView(this)

        private val clubs: MutableList<Item> = mutableListOf()

        private lateinit val name = resources.getStringArray(club_name)
        private lateinit val image = resources.obtainTypedArray(club_image)
        private lateinit val desc = resources.getStringArray(club_desc)

        clubs.clear()

        for(i in name.indices) {
            clubs.add(Item(name[i], image.getResourceId(i, 0), desc[i]))
        }

        image.recycle()

        verticalLayout() {
            recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = Adapter(context, clubs) {
                    startActivity<DetailActivity>(
                            "name" to "${it.name}",
                            "image" to it.image,
                            "desc" to "${it.desc}"
                    )
                }
            }

        }

    }

    /**
    class MainActivityUI: AnkoComponent<MainActivity> {

        var clubs: MutableList<Item> = mutableListOf()

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

            val name = resources.getStringArray(club_name)
            val image = resources.obtainTypedArray(club_image)
            val desc = resources.getStringArray(club_desc)

            clubs.clear()

            for (i in name.indices) {
                clubs.add(Item(name[i], image.getResourceId(i, 0), desc[i]))
            }

            image.recycle()

            verticalLayout() {
                recyclerView {
                    lparams(width = matchParent, height = matchParent)
                    layoutManager = LinearLayoutManager(context)
                    adapter = Adapter(context, clubs) {
                        startActivity<DetailActivity>(
                                "name" to "${it.name}",
                                "image" to it.image,
                                "desc" to "${it.desc}"
                        )
                    }
                }
            }

        }

    }
    **/

}
