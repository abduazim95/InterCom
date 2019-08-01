package almaty.igd.viewmodel

import almaty.igd.data.Contact
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

open class ContactsViewModel : ViewModel() {

    val _contacts = MutableLiveData<MutableList<Contact>>()
    var contacts: LiveData<MutableList<Contact>>
        get() = _contacts
        set(value){
            _contacts.value = value.value
        }


    public fun addContact(item: Contact){
        if(_contacts.value != null) {
            _contacts.value?.add(item)
            _contacts.value = _contacts.value
        }
    }

    init{
        _contacts.value = mutableListOf(
            Contact(1, "Stephan Serebryakov", "+asd"),
            Contact(1, "Stephan Serebryakov", "+77011745316"),
            Contact(1, "Stephan Serebryakov", "+77011745316"),
            Contact(1, "Stephan Serebryakov", "+77011745316"),
            Contact(1, "Stephan Serebryakov", "+77011745316")

        )
    }



}
