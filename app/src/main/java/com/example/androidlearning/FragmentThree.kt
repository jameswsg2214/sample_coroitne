package com.example.androidlearning

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fargment_one.*
import kotlinx.android.synthetic.main.fargment_one.view.*

class FragmentThree: Fragment(R.layout.fragment_three) {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentThree","onAttach")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentThree","onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FragmentThree","onCreateView")

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentThree","onViewCreated")

        button.setOnClickListener {
           // findNavController().navigate(R.id.action_fragmentthree_to_fragmentOne)
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("FragmentThree","onActivityCreated")

    }

    override fun onStart() {
        super.onStart()
        Log.d("FragmentThree","onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentThree","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentThree","onPause")

    }




    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentThree","onDestroy")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentThree","onDestroyView")

    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        Log.d("FragmentThree","onDestroyOptionsMenu")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentThree","onDetach")

    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("FragmentThree","onConfigurationChanged")

    }

}