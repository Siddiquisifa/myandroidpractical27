package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    lateinit var etname:EditText
    lateinit var etemail:EditText
    lateinit var etpassword:EditText
    lateinit var etrepass:EditText
    lateinit var etdob:EditText
    lateinit var etmobileno:EditText
    lateinit var etcity:EditText
    lateinit var etstate:EditText
    lateinit var etcountry:EditText
    lateinit var rbmale:RadioButton
    lateinit var rbfemale:RadioButton
    lateinit var btnsub:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etname=view.findViewById(R.id.et_name)
        etemail=view.findViewById(R.id.et_email1)
        etpassword=view.findViewById(R.id.et_password1)
        etrepass=view.findViewById(R.id.et_repass)
        etdob=view.findViewById(R.id.et_dob)
        etmobileno=view.findViewById(R.id.et_mobileno)
        etcity=view.findViewById(R.id.et_city)
       etstate=view.findViewById(R.id.et_state)
        etcountry=view.findViewById(R.id.et_country)
        rbmale=view.findViewById(R.id.radio_male)
        rbfemale=view.findViewById(R.id.radio_female)

        btnsub=view.findViewById(R.id.btn_submit)

        btnsub.setOnClickListener {

                 var fragment=FirstFragment()

             val commit = requireActivity().supportFragmentManager
                 .beginTransaction()
                 .replace(R.id.fragment_container, fragment)
                 .addToBackStack(null)
                 .commit()
            Toast.makeText(requireActivity(),"Create Account Sucessfully...",Toast.LENGTH_SHORT).show()
        }





    }
}