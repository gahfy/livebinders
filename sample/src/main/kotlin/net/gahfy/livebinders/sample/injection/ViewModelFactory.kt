package net.gahfy.livebinders.sample.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.gahfy.livebinders.sample.textview.TextViewViewModel
import android.util.TypedValue



class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TextViewViewModel::class.java)) {
            val spToPxMultiplier = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 1F, activity.resources.displayMetrics)

            @Suppress("UNCHECKED_CAST")
            return TextViewViewModel(spToPxMultiplier) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}