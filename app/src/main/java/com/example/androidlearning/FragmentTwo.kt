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

class FragmentTwo: Fragment(R.layout.frgamnet_two) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentTwo","onAttach")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentTwo","onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FragmentTwo","onCreateView")

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentTwo","onViewCreated")

        button.setOnClickListener {
           // findNavController().navigate(R.id.action_fragmenttwo_to_fragmentthree)
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("FragmentTwo","onActivityCreated")

    }

    override fun onStart() {
        super.onStart()
        Log.d("FragmentTwo","onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentTwo","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentTwo","onPause")

    }




    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentTwo","onDestroy")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentTwo","onDestroyView")

    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        Log.d("FragmentTwo","onDestroyOptionsMenu")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentTwo","onDetach")

    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("FragmentTwo","onConfigurationChanged")

    }
}