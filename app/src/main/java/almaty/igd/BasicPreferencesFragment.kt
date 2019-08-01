package almaty.igd

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class BasicPreferencesFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.layout.basic_preference_fragment, rootKey)
    }
}