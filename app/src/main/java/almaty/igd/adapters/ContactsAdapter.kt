package almaty.igd.adapters
import almaty.igd.R
import almaty.igd.data.Contact
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.databinding.BindingAdapter




class ContactsAdapter(val listener: OnItemClickListener) : RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(item: Contact)
    }

    private var myDataset: List<Contact> = listOf()

    class ContactsViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val contactName: TextView = v.findViewById(R.id.name)
        val contactPhone: TextView = v.findViewById(R.id.phone)

        fun bind(item: Contact, listener: OnItemClickListener){
            contactName.text = item.name
            contactPhone.text = item.phone
            itemView.setOnClickListener({
                listener.onItemClick(item)
            })

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val contactsRecycleListItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.contacts_item, parent, false) as View
        return ContactsViewHolder(contactsRecycleListItem)
    }

    override fun getItemCount(): Int {
        Log.d("MainActivity", myDataset.size.toString())
        return myDataset.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.bind(myDataset[position], listener)
    }

    companion object {
        @BindingAdapter("app:items")
        @JvmStatic
        fun RecyclerView.bindItems(items: List<Contact>) {
            val adapter = adapter as ContactsAdapter
            adapter.update(items)
        }
    }

    fun update(items: List<Contact>) {
        this.myDataset = items
        notifyDataSetChanged()
    }



}