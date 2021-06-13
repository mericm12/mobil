package com.meric.madanoglu.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.ListView
import android.widget.ArrayAdapter
import com.meric.madanoglu.models.Student
import androidx.navigation.findNavController
import androidx.fragment.app.Fragment
import com.meric.madanoglu.R

class MainFragment : Fragment() {

    private lateinit var listview : ListView
    private lateinit var studentList: ArrayList<Student>
    private lateinit var studentNamesList: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeVariables()
        setListViewVariables()
        setRecyclerViewAdapter()
        listViewOnClickListener()
    }

    private fun initializeVariables(){
        listview = requireView().findViewById(R.id.listView)
    }

    private fun setListViewVariables(){
        studentList = ArrayList()
        studentNamesList = ArrayList()

        val std1 = Student("Çağla", 22,4417)
        val std2 = Student("Sıla", 28,2468)
        val std3 = Student("Gürbüz", 30,410)
        val std4 = Student("Yavuz", 19,8)
        val std5 = Student("Gözde", 21,77)
        val std6 = Student("Selim", 30,615)

        studentList.add(std1)
        studentList.add(std2)
        studentList.add(std3)
        studentList.add(std4)
        studentList.add(std5)
        studentList.add(std6)

        studentNamesList.add(std1.name)
        studentNamesList.add(std2.name)
        studentNamesList.add(std3.name)
        studentNamesList.add(std4.name)
        studentNamesList.add(std5.name)
        studentNamesList.add(std6.name)
    }

    private fun setRecyclerViewAdapter(){
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, studentNamesList)

        listview.adapter = adapter
    }

    private fun listViewOnClickListener(){

        listview.setOnItemClickListener{_,_,position,_ ->
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(
                studentList[position].name,
                studentList[position].age,
                studentList[position].number
            )

            requireView().findNavController().navigate(action)
        }

    }
}