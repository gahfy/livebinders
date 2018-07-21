package net.gahfy.livebinders.extension

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Parent activity of the view. Null if the View has no parent Activity
 */
val View.parentActivity:AppCompatActivity?
    get(){
        var context = this.context
        while(context is ContextWrapper){
            if(context is AppCompatActivity){
                return context
            }
            context = context.baseContext
        }
        return null
    }

internal fun <T : Any> View.addLiveData(liveData: LiveData<T>?, observer: Observer<T>) {
    val parentActivity: AppCompatActivity? = this.parentActivity
    if (parentActivity != null && liveData != null) {
        liveData.observe(parentActivity, observer)
    }
}