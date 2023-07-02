package com.example.plastick.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plastick.R
import com.example.plastick.dataBase.sell.Sells
import com.example.plastick.dataBase.sell.sellsAdapter
import com.example.plastick.databinding.FragmentNotificationsBinding
import com.example.plastick.detailsFragment

class NotificationsFragment : Fragment() {

    private lateinit var adapter : sellsAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var userArrayList : ArrayList<Sells>


    lateinit var sellbutton : Array<Int>
    lateinit var name : Array<String>

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitializer()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.sellview)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = sellsAdapter(userArrayList)
        recyclerView.adapter = adapter


        var adapter = sellsAdapter(userArrayList)
        recyclerView.adapter = adapter
        adapter.setOnITemClickListner(object : sellsAdapter.onItemClickListner{
            override fun onItemCLick(position: Int) {

                val secondFragment = detailsFragment()
                val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()

                transaction.replace(R.id.nav_host_fragment_activity_main,secondFragment)
                transaction.commit()


            }

        })


    }

    private fun dataInitializer()
    {
        userArrayList = arrayListOf<Sells>()

        name = arrayOf(
            "Bottle","Bucket","Container","Others"
        )

         sellbutton = arrayOf(
            R.drawable.water,
            R.drawable.bucket,
            R.drawable.box,

            R.drawable.moreicon
        )

        for (i in sellbutton.indices)
        {
            val user = Sells(sellbutton[i],name[i])
            userArrayList.add(user)
        }






    }

}