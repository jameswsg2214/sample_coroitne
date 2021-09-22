package com.example.androidlearning

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.androidlearning.Network.ApiClient
import com.example.androidlearning.Network.Resource
import com.example.androidlearning.model.RequestPayload
import com.example.androidlearning.model.RequestPayloadItem
import kotlinx.android.synthetic.main.fargment_one.*

class FragmentOne:Fragment(R.layout.fargment_one) {

   lateinit var viewModelLiveData: LiveDataViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentOne","onAttach")


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentOne","onCreate")
        viewModelLiveData = ViewModelProviders.of(
            this,
            LiveDataViewModelFactory(ApiClient.apiService,requireContext())
        ).get(LiveDataViewModel::class.java)

    }



    private fun setupViewModel(){
        viewModelLiveData.getLiveData()


        viewModelLiveData.resultMy.observe(viewLifecycleOwner,{

            when(it.status){
                Resource.Status.SUCCESS->{
                    Log.d("test3","resultMy")
                    Log.d("test3",Thread.currentThread().name)


                }
                Resource.Status.NOINTERNET->{
                    Log.d("internet", it.message.toString())
                }
                else -> {

                }
            }

        })


    }

    private fun createNotes(toString: String) {
        val requestPayload = RequestPayload()
        val requestPayloadItem = RequestPayloadItem(
            captured_by =  "28869",
            captured_on ="2021-09-17T05:34:04.156Z",
            encounter_uuid = 71583,
            encounter_type_uuid = "1",
            patient_uuid = 92367,
            facility_uuid = "12612",
            department_uuid = "27" ,
            consultation_uuid = 0 ,
            note_type_uuid = 1,
            progressnote_type_uuid = 0,
            daily_note = toString,
            special_note = "",
            note_status_uuid = 0,
            is_ventilator = false,
            is_apap = false,
            is_bipap = false,
            is_cpap = false,
            is_o2 = false,
            is_o2_con = false
        )
        requestPayload.add(requestPayloadItem)
        viewModelLiveData.createNotes(requestPayload)

        viewModelLiveData.createClinicalNotes.observe(requireActivity(),{
            when(it.status){
                Resource.Status.SUCCESS->{
                    Toast.makeText(requireContext(),it.data?.body()?.message,Toast.LENGTH_LONG).show()
                    my_notes.setText("")



                }
                Resource.Status.NOINTERNET->{
                    Log.d("internet", it.message.toString())
                }

                Resource.Status.DATAINSETED->{
                    Toast.makeText(requireContext(),it.message,Toast.LENGTH_LONG).show()
                }
                else -> {

                }
            }
        })

    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FragmentOne","onCreateView")

       // setupViewModel()

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentOne","onViewCreated")

        button.setOnClickListener {
           // findNavController().navigate(R.id.action_fragmentOne_to_fragmenttwo)
        }

        createNotes.setOnClickListener {
            createNotes(my_notes.text.toString())
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("FragmentOne","onActivityCreated")

    }

    override fun onStart() {
        super.onStart()
        Log.d("FragmentOne","onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentOne","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentOne","onPause")

    }




    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentOne","onDestroy")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentOne","onDestroyView")

    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        Log.d("FragmentOne","onDestroyOptionsMenu")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentOne","onDetach")

    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("FragmentOne","onConfigurationChanged")

    }




}


