package almaty.igd


import almaty.igd.adapters.MessagesAdapter
import almaty.igd.data.Message
import almaty.igd.viewmodel.MessagesViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import almaty.igd.databinding.MessagesFragmentBinding
import android.graphics.drawable.ClipDrawable
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


open class MessagesFragment : Fragment() {

    private lateinit var binding : MessagesFragmentBinding
    private lateinit var viewModel : MessagesViewModel
    private lateinit var viewAdapter : MessagesAdapter
    private val navController: NavController by lazy { binding.root.findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val messagesViewModel = ViewModelProviders.of(this).get(MessagesViewModel::class.java)
        binding = DataBindingUtil.inflate<MessagesFragmentBinding>(
            inflater, R.layout.messages_fragment, container, false
        ).apply{
            this.setLifecycleOwner(this@MessagesFragment)
            this.viewModel = messagesViewModel
        }

        // Enable to manage Toolbar with Fragment
        setHasOptionsMenu(true)

        //Initiate contacts List
        initMessagesRecycleView()
        return binding.root
    }

    private fun initMessagesRecycleView(){
        viewModel = ViewModelProviders.of(this)[MessagesViewModel::class.java]
        val viewManager = LinearLayoutManager(activity)
        viewAdapter = MessagesAdapter(recycleViewCallbacks())

        binding.root.findViewById<RecyclerView>(R.id.messages_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(this.context,  ClipDrawable.HORIZONTAL))
        }
    }

    private fun recycleViewCallbacks() : MessagesAdapter.OnItemClickListener{
        return object : MessagesAdapter.OnItemClickListener {
            override fun onItemClick(item: Message) {
                //Snackbar.make(binding.root, "${item.message} от ${item.name}", Snackbar.LENGTH_LONG).show()
                val bundle = Bundle().apply{
                    this.putString("name", item.message)
                }
                navController.navigate(R.id.action_destination_messages_to_destination_chat, bundle)
            }
        }
    }

}
