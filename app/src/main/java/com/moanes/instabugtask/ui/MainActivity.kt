package com.moanes.instabugtask.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.moanes.instabugtask.R
import com.moanes.instabugtask.data.MainRepoImpl
import com.moanes.instabugtask.data.Word
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(), MainView {
    private val presenter = MainPresenter(MainRepoImpl(), Executors.newSingleThreadExecutor(),this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        presenter.getHtml("https://instabug.com/")
    }

    private fun initWordListRV(list: List<Word>){
        val adapter=WordsAdapter()
        wordsListRV.adapter=adapter
        wordsListRV.layoutManager=LinearLayoutManager(this)
        adapter.submitList(list)
    }
    override fun setList(list: List<Word>) {
            runOnUiThread {
                initWordListRV(list)
            }
    }

    override fun showLoading() {
        runOnUiThread {
            progressBar.show()
        }
    }

    override fun hideLoading() {
        runOnUiThread {
            progressBar.hide()
        }
    }

    override fun onFailure(msg: String?) {
        runOnUiThread {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clean()
    }


}