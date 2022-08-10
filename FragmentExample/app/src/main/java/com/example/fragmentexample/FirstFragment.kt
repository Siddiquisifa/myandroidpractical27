package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    lateinit var etemail:EditText
    lateinit var etpassword:EditText
    lateinit var btnlogin:Button
    lateinit var btnsignup:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etemail=view.findViewById(R.id.et_email)
        etpassword=view.findViewById(R.id.et_password)
        btnlogin=view.findViewById(R.id.btn_login)
        btnsignup=view.findViewById(R.id.btn_next)

        btnlogin.setOnClickListener {

           var email=etemail.text.toString().trim()
           var password=etpassword.text.toString().trim()

            var bundal=Bundle()
            bundal.putString("EMAIL",email)
            bundal.putString("PASS",password)

            var fragment=SecondFragment()
            fragment.arguments=bundal

            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .addToBackStack(null)
                .commit()
        }

        btnsignup.setOnClickListener {

            var fragment=ThirdFragment()

            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .addToBackStack(null)
                .commit()

            Toast.makeText(requireActivity(),"Create Acount Sucessfully...",Toast.LENGTH_SHORT).show()

        }
    }

}