package com.example.quizdapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.quizdapp.util.PreferenceManager
import com.google.android.material.button.MaterialButton
import org.web3j.crypto.Credentials
import java.util.prefs.Preferences

class DeployContractActivity : AppCompatActivity() {
    private var deployedSmartContractAddress: String? = null
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var preferenceManager: PreferenceManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deploy_contract)

        quizViewModel = ViewModelProvider(this)[QuizViewModel::class.java]


        preferenceManager = PreferenceManager(this)
        findViewById<MaterialButton>(R.id.btn_deploy_contract).setOnClickListener {
            deployedSmartContractAddress =
                preferenceManager.getString("deployedSmartContractAddress")

            if (deployedSmartContractAddress.isNullOrEmpty() || deployedSmartContractAddress=="-1") {
                quizViewModel.deploySmartContract(getCredentialsFromPrivateKey())
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }

        }

        observers()
    }

    private fun observers() {
        quizViewModel.contractAddress.observe(this) {
            if (it != "-1") {
                preferenceManager.putString("deployedSmartContractAddress", it)
                Toast.makeText(this, "Smart Contract Deployed", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {

                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun getCredentialsFromPrivateKey(): Credentials {
        val privateKey = "5ab6b0e9ff7d33b1c3e269f285c2eaa76cefe8725eef2e6ae8bfb257749e7b4c"
        return Credentials.create(privateKey)
    }
}