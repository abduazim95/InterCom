package almaty.igd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_conversation.*

class ConversationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)
        val arguments = intent.extras
        val typeArg = arguments!!.get("type")!!.toString()
        val nameArg = arguments!!.get("name")!!.toString()
        val phoneArg = arguments!!.get("phone")!!.toString()

        type.text = typeArg
        name.text = nameArg
        phone.text = phoneArg

    }
}
