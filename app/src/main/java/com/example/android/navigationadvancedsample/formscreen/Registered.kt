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

package com.example.android.navigationadvancedsample.formscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.navigationadvancedsample.BaseFragment
import com.example.android.navigationadvancedsample.R
import com.example.android.navigationadvancedsample.homescreen.SharedViewModel

/**
 * Shows "Done".
 */
class Registered : BaseFragment() {
    private lateinit var viewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(activity!!).get(SharedViewModel::class.java)
        viewModel.dataToshare.observe(this, Observer { data ->
            Log.d("Nav", "${javaClass.simpleName} shared Data: $data")
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_registered, container, false)

        view.findViewById<Button>(R.id.homeBtn).setOnClickListener {
            findNavController().navigate(R.id.registeredToHome, bundleOf("num" to fragNum + 1))
        }
        view.findViewById<Button>(R.id.leaderBoardBtn).setOnClickListener {
            findNavController().navigate(R.id.registeredToLeader, bundleOf("num" to fragNum + 1))
        }
        view.findViewById<Button>(R.id.registerBtn).setOnClickListener {
            findNavController().navigate(R.id.registeredToRegister, bundleOf("num" to fragNum + 1))
        }
        view.findViewById<Button>(R.id.registeredBtn).setOnClickListener {
            findNavController().navigate(R.id.registeredToRegistered, bundleOf("num" to fragNum + 1))
        }
        view.findViewById<Button>(R.id.aboutBtn).setOnClickListener {
            findNavController().navigate(R.id.registeredToAbout, bundleOf("num" to fragNum + 1))
        }

        view.findViewById<TextView>(R.id.title).setOnClickListener {
            viewModel.updateDate(data = javaClass.simpleName)
        }

        return view
    }
}
