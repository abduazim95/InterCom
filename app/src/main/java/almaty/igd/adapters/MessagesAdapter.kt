package almaty.igd.adapters

import almaty.igd.R
import almaty.igd.data.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView




class MessagesAdapter(val listener: OnItemClickListener) : RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(item: Message)
    }

    private var myDataset: List<Message> = listOf()

    class MessagesViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val messageName: TextView = v.findViewById(R.id.name)
        val messagePhone: TextView = v.findViewById(R.id.message)

        fun bind(item: Message, listener: OnItemClickListener){
            messageName.text = item.name
            messagePhone.text = item.message
            itemView.setOnClickListener({
                listener.onItemClick(item)
            })

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val messagesRecycleListItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_item, parent, false) as View
        return MessagesViewHolder(messagesRecycleListItem)
    }

    override fun getItemCount(): Int {
        Log.d("MainActivity", myDataset.size.toString())
        return myDataset.size
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.bind(myDataset[position], listener)
    }

    companion object {
        @BindingAdapter("app:items")
        @JvmStatic
        fun RecyclerView.bindItems(items: List<Message>) {
            val adapter = adapter as MessagesAdapter
            adapter.update(items)
        }
    }

    fun update(items: List<Message>) {
        this.myDataset = items
        notifyDataSetChanged()
    }



}