package almaty.igd

import almaty.igd.databinding.ContactsFragmentBinding
import almaty.igd.viewmodel.ContactsViewModel
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import almaty.igd.adapters.ContactsAdapter
import almaty.igd.data.Contact
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.miguelcatalan.materialsearchview.MaterialSearchView
import android.content.Intent



val ACTION : String = "almaty.igd.CONVERSATION_ACTIVITY"

open class ContactsFragment : Fragment() {

    private lateinit var binding: ContactsFragmentBinding
    private lateinit var viewModel: ContactsViewModel
    private lateinit var viewAdapter: ContactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contactsViewModel = ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        binding = DataBindingUtil.inflate<ContactsFragmentBinding>(
            inflater, R.layout.contacts_fragment, container, false
        ).apply{
            this.setLifecycleOwner(this@ContactsFragment)
            this.viewModel = contactsViewModel
        }

        // Enable to manage Toolbar with Fragment
        setHasOptionsMenu(true)

        //Initiate contacts List
        initContactsRecycleView()
        return binding.root
    }


    private fun initContactsRecycleView(){
        viewModel = ViewModelProviders.of(this)[ContactsViewModel::class.java]

        val viewManager = LinearLayoutManager(activity)
        viewAdapter = ContactsAdapter(recycleViewCallbacks())
        
        binding.root.findViewById<RecyclerView>(R.id.contacts_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(this.context,  HORIZONTAL))
        }
    }

    private fun recycleViewCallbacks() : ContactsAdapter.OnItemClickListener{
        return object : ContactsAdapter.OnItemClickListener {
            override fun onItemClick(item: Contact) {
                val intent = Intent(ACTION)
                intent.putExtra("type", "outgoing")
                intent.putExtra("name", item.name)
                intent.putExtra("phone", item.phone)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }
}
