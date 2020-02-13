/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigationadvancedsample.homescreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import com.example.android.navigationadvancedsample.BaseFragment
import com.example.android.navigationadvancedsample.R

class SharedViewModel: ViewModel() {
    val dataToshare = MutableLiveData<String>()

    fun updateDate(data: String) {
        dataToshare.value = data
    }
}

/**
 * Shows the main title screen with a button that navigates to [About].
 */
class Title: BaseFragment() {
    private lateinit var viewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(activity!!).get(SharedViewModel::class.java)
        viewModel.dataToshare.observe(this, Observer { data ->
            Log.d("Nav", "${javaClass.simpleName} shared Data: $data")
        })


//        val callBack = object: OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    Log.d("Navi", "handleOnBackPressed")
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(this, callBack)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_title, container, false)

        view.findViewById<Button>(R.id.homeBtn).setOnClickListener {
            findNavController().navigate(R.id.homeToHome, bundleOf("num" to fragNum + 1))
        }
        view.findViewById<Button>(R.id.leaderBoardBtn).setOnClickListener {
            findNavController().navigate(R.id.homeToLeader, bundleOf("num" to fragNum + 1))
        }
        view.findViewById<Button>(R.id.registerBtn).setOnClickListener {
            findNavController().navigate(R.id.homeToRegister, bundleOf("num" to fragNum + 1))
        }
        view.findViewById<Button>(R.id.registeredBtn).setOnClickListener {
            findNavController().navigate(R.id.homeToRegistered, bundleOf("num" to fragNum + 1))
        }
        view.findViewById<Button>(R.id.aboutBtn).setOnClickListener {
            findNavController().navigate(R.id.homeToAbout, bundleOf("num" to fragNum + 1))
        }

        view.findViewById<TextView>(R.id.title).setOnClickListener {
            viewModel.updateDate(data = javaClass.simpleName)
        }

        return view
    }
}