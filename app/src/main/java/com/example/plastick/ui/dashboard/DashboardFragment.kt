package com.example.plastick.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plastick.R
import com.example.plastick.dataBase.buy.ListAdapter
import com.example.plastick.dataBase.buy.User
import com.example.plastick.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var adapter : ListAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var userArrayList : ArrayList<User>


    lateinit var price : Array<String>
    lateinit var item : Array<String>
    lateinit var brand : Array<String>
    lateinit var imageId : Array<Int>

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
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
        recyclerView = view.findViewById(R.id.rv_categories)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ListAdapter(userArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitializer()
    {
        userArrayList = arrayListOf<User>()

        price = arrayOf(
            "Rs 60","Rs 200","Rs 20","Rs 400","Rs 40","Rs 70"       )

        item = arrayOf(
            "Bottle","Skate Board","Brush","Chair","Night Lamp","Flower Vase")

        brand = arrayOf(
            "Plastick","Plastick","Plastick","Plastick","Plastick","Plastick","Plastick"
        )

        imageId = arrayOf(
            R.drawable.images6,
                    R.drawable.images5,
                    R.drawable.images4,
                    R.drawable.images2,
                    R.drawable.images,
                    R.drawable.download
        )

        for (i in imageId.indices)
        {
            val user = User(price[i],item[i],brand[i],imageId[i])
            userArrayList.add(user)
        }

    }

    }