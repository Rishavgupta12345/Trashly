package com.example.plastick

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.plastick.ui.buypage

class fragmentUploadPhoto : Fragment() {

    val REQUEST_IMAGE_CAPTURE = 100
    lateinit var imgview: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_upload_photo, container, false)

        val bt = v.findViewById<TextView>(R.id.buttonUpload)
        bt.setOnClickListener {
            val secondFragment = buypage()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.nav_host_fragment_activity_main,secondFragment)
            transaction.commit()


        }

       imgview = v.findViewById(R.id.cameraupload)


        val camera = v.findViewById<ImageView>(R.id.imageViewchooserPhoto)
        camera.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            val time : Long = 1500

            Handler().postDelayed(Runnable {

                imgview.setImageResource(R.drawable.verified)
            }, time)


            try {
                startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE)
            }catch (e: ActivityNotFoundException){
                val text = "problem"
                val duration = Toast.LENGTH_SHORT

                Toast.makeText(context, text, duration).show()
            }
        }

        return v

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       if (requestCode == REQUEST_IMAGE_CAPTURE && requestCode == RESULT_OK)
       {

           imgview.setImageResource(R.drawable.verified)
       }
        else
       {
           super.onActivityResult(requestCode, resultCode, data)
       }

    }


}