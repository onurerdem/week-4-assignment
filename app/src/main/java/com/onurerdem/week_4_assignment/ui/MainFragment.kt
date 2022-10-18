package com.onurerdem.week_4_assignment.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.onurerdem.week_4_assignment.R
import com.onurerdem.week_4_assignment.api.ApiClient
import com.onurerdem.week_4_assignment.model.model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private lateinit var button: Button
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        getEverything()
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun getEverything() {
        ApiClient.getApiService().getWeatherInfo("40.14", "26.40", "minutely").enqueue(object :
            Callback<model> {
            override fun onResponse(call: Call<model>, response: Response<model>) {
                Log.d("deneme1", response.body().toString())

                if (response.isSuccessful) {
                    val everything = response.body()
                    everything?.let {
                        // Log.d("deneme1", it.articles?.size.toString())
                    }
                }
            }

            override fun onFailure(call: Call<model>, t: Throwable) {
                Log.d("deneme1", t.toString())
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_detailFragment, Bundle().apply {
            })
        }
    }
}