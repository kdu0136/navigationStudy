package com.example.android.navigationadvancedsample

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel

    protected val fragNum
        get() = arguments?.getInt("num", 0) ?: 0

    override fun onAttach(context: Context) {
        Log.d("Test", "${javaClass.simpleName} onAttach $fragNum")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d("Test", "${javaClass.simpleName} onCreate $fragNum")

        activity?.let {
            viewModel = ViewModelProvider(it).get(SharedViewModel::class.java)
            viewModel.beforFragmentStr.observe(this, Observer { data ->
                Log.d("Nav", "${javaClass.simpleName} shared Data: $data")
            })
            super.onCreate(savedInstanceState)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        Log.d("Test", "${javaClass.simpleName} onCreateView $fragNum")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Test", "${javaClass.simpleName} onViewCreated $fragNum")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        Log.d("Test", "${javaClass.simpleName} onActivityCreated $fragNum")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
//        Log.d("Test", "${javaClass.simpleName} onStart $fragNum")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Test", "${javaClass.simpleName} onResume $fragNum")
        super.onResume()
    }

    override fun onPause() {
//        Log.d("Test", "${javaClass.simpleName} onPause $fragNum")
        super.onPause()
    }

    override fun onStop() {
//        Log.d("Test", "${javaClass.simpleName} onStop $fragNum")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Test", "${javaClass.simpleName} onDestroyView $fragNum")
        super.onDestroyView()
    }

    override fun onDestroy() {
//        Log.d("Test", "${javaClass.simpleName} onDestroy $fragNum")
        viewModel.endFragment(fragName = javaClass.simpleName)
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Test", "${javaClass.simpleName} onDetach $fragNum")
        super.onDetach()
    }
}