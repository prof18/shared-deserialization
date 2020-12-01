package com.prof18.sharedserialization.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import com.google.android.material.button.MaterialButton
import kotlinx.serialization.ExperimentalSerializationApi


@ExperimentalSerializationApi
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text_view)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val button = findViewById<MaterialButton>(R.id.button)

        viewModel.appState.observe(this) {
            it?.let { appState ->
                when (appState) {
                    is AppState.Loading -> {
                        textView.visibility  = View.GONE
                        button.visibility  = View.GONE
                        progressBar.visibility  = View.VISIBLE
                    }
                    is AppState.Success -> {
                        textView.visibility  = View.VISIBLE
                        button.visibility  = View.VISIBLE
                        progressBar.visibility  = View.GONE

                        textView.text = appState.data
                    }
                }
            }
        }

        button.setOnClickListener {
            viewModel.loadData()
        }
    }
}
