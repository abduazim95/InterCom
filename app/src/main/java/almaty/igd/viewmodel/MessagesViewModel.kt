package almaty.igd.viewmodel

import almaty.igd.data.Message
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

open class MessagesViewModel : ViewModel() {
    val _messages = MutableLiveData<MutableList<Message>>()
    var messages: LiveData<MutableList<Message>>
        get() = _messages
        set(value){
            _messages.value = value.value
        }


    public fun addMessage(item: Message){
        if(_messages.value != null) {
            _messages.value?.add(item)
            _messages.value = _messages.value
        }
    }

    init{
        _messages.value = mutableListOf(
            Message(1, "Stephan Serebryakov", "Добрый день"),
            Message(1, "Stephan Serebryakov", "досвидания"),
            Message(1, "Stephan Serebryakov", "пока"),
            Message(1, "Stephan Serebryakov", "я проггер"),
            Message(1, "Stephan Serebryakov", "Дин пэйс")
        )
    }
}
