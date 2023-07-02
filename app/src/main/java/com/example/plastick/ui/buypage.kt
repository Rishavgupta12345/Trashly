package com.example.plastick.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.plastick.R
import com.example.plastick.ui.dashboard.DashboardFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class buypage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_buypage, container, false)

        val bt = v.findViewById<TextView>(R.id.button_ok)
        bt.setOnClickListener {
            val secondFragment = DashboardFragment()
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()

            transaction.replace(R.id.nav_host_fragment_activity_main,secondFragment)
            transaction.commit()

            val text = "Thanks for Uploading Trader will reach to you Soon !!!"
            val duration = Toast.LENGTH_LONG

            Toast.makeText(context, text, duration).show()

        }
        return v
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            buypage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}