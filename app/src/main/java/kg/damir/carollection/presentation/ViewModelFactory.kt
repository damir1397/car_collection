package kg.damir.carollection.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelAdd::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ViewModelAdd(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}