package com.moanes.instabugtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.moanes.instabugtask.R
import com.moanes.instabugtask.data.MainRepoImpl
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(), MainView {
    private val presenter = MainPresenter(MainRepoImpl(), Executors.newSingleThreadExecutor(),this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getHtml("https://instabug.com/")
//        presenter.getHtml("https://istbug.com/")
    }

    override fun setMap(map: Map<String, Int>) {
        runOnUiThread {
            print(map.toString())
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