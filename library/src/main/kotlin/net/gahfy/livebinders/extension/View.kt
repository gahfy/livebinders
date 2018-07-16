package net.gahfy.livebinders.extension

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

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