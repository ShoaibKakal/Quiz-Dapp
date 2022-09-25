package com.example.quizdapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.quizdapp.util.PreferenceManager
import org.web3j.crypto.Credentials


const val TAG = "testTag"

class MainActivity : AppCompatActivity() {

    private lateinit var deployedSmartContractAddress: String
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var preferenceManager: PreferenceManager
    private lateinit var rvMCQs:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizViewModel = ViewModelProvider(this)[QuizViewModel::class.java]
        preferenceManager = PreferenceManager(this)
        rvMCQs = findViewById(R.id.rv_mcqs)

        deployedSmartContractAddress = preferenceManager.getString("deployedSmartContractAddress")!!
        quizViewModel.loadSmartContractData(
            getCredentialsFromPrivateKey(),
            deployedSmartContractAddress
        )
        observers()
    }

    private fun observers() {

        quizViewModel.questions.observe(this) {
            rvMCQs.adapter = QuestionsAdapter(it)
        }
    }


    private fun getCredentialsFromPrivateKey(): Credentials {
        val privateKey = "5ab6b0e9ff7d33b1c3e269f285c2eaa76cefe8725eef2e6ae8bfb257749e7b4c"
        return Credentials.create(privateKey)
    }
}