package com.example.zvent.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.example.zvent.R
import com.example.zvent.viewmodels.AddGuestViewModel
import com.example.zvent.viewmodels.InvitedListViewModel

class HomeFragment : Fragment() {

    private lateinit var viewModelInvited: InvitedListViewModel
    private lateinit var viewModelGuests: AddGuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        /*val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)*/
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val inicioB: Button = root.findViewById(R.id.start_b)


        viewModelGuests = ViewModelProvider(activity!!).get(AddGuestViewModel::class.java)
        viewModelInvited = ViewModelProvider(activity!!).get(InvitedListViewModel::class.java)

        viewModelGuests.onStart()
        viewModelInvited.invitedList = viewModelGuests.guestsList

        inicioB.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_nav_home_to_registerFragment)
        }
        setHasOptionsMenu(true)
        return root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())

    }
}