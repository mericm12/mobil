package com.meric.madanoglu.ui.fragments

import android.os.Bundle
import com.meric.madanoglu.R
import android.view.LayoutInflater
import androidx.navigation.fragment.navArgs
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView

class DetailFragment : Fragment() {

    private lateinit var txtName: TextView
    private lateinit var txtAge: TextView
    private lateinit var txtNumber: TextView

    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeVariables(view)
        setVariables()
    }

    private fun initializeVariables(view: View){
        txtName = view.findViewById(R.id.txtStudentName)
        txtAge = view.findViewById(R.id.txtStudentAge)
        txtNumber = view.findViewById(R.id.txtStudentNumber)
    }

    private fun setVariables(){
        var studentName = ""
        var studentAge = ""
        var studentNumber = ""

        studentName = if (args.name == "")
            getString(R.string.unknown)
        else
            args.name

        studentAge = if (args.age <= -1)
            getString(R.string.unknown)
        else
            args.age.toString()

        studentNumber = if (args.number <= -1)
            getString(R.string.unknown)
        else
            args.number.toString()

        txtName.text = getString(R.string.studentName, studentName)
        txtAge.text = getString(R.string.studentAge, studentAge)
        txtNumber.text = getString(R.string.studentNumber, studentNumber)
    }
}