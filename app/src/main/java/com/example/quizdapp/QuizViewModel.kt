package com.example.quizdapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizdapp.data.Question
import com.example.quizdapp.data.Quiz_sol_Quiz
import com.example.quizdapp.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.tx.gas.StaticGasProvider

class QuizViewModel : ViewModel() {

    private var _questions = MutableLiveData<ArrayList<Question>>()
    val questions: LiveData<ArrayList<Question>> = _questions
    private var _contractAddress = MutableLiveData<String>()
    val contractAddress: LiveData<String> = _contractAddress



    private val gasProvider =
        StaticGasProvider(DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT)


    fun deploySmartContract(credentials: Credentials) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val web3j =
                        Web3j.build(HttpService(Constants.GOERLI_TESTNET))
                    val contractAddress =
                        Quiz_sol_Quiz.deploy(web3j, credentials, gasProvider).send().contractAddress
                    _contractAddress.postValue(contractAddress)
                } catch (e: Exception) {
                    _contractAddress.postValue("-1")
                    Log.d(TAG, "deploySmartContract: Exception: ${e.message}")
                }
            }
        }
    }


    fun loadSmartContractData(credentials: Credentials, deployedContractAddress: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                try {
                    val web3j =
                        Web3j.build(HttpService(Constants.GOERLI_TESTNET))
                    val quiz =
                        Quiz_sol_Quiz.load(deployedContractAddress, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT)
                    Log.d(TAG, "loadSmartContractData: Is Contract Valid: ${quiz.isValid}")
                    val questions = quiz.questions.send() as ArrayList<Question>
                    _questions.postValue(questions)
                } catch (e: Exception) {
                    Log.d(TAG, "loadSmartContractData: Exception: ${e.message}")
                }

            }
        }
    }

}