package almaty.igd.adapters.diffutils
import almaty.igd.data.Contact
import java.nio.file.Files.size
import androidx.recyclerview.widget.DiffUtil


class ContactsDiffUtilCallback(private val oldList: List<Contact>, private val newList: List<Contact>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldContact = oldList[oldItemPosition]
        val newContact = newList[newItemPosition]
        return oldContact.id === newContact.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldProduct = oldList[oldItemPosition]
        val newProduct = newList[newItemPosition]
        return oldProduct.name.equals(newProduct.name) && oldProduct.name === newProduct.name
    }
}