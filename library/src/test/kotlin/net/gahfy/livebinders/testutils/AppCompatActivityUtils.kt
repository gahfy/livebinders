package net.gahfy.livebinders.testutils

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import org.mockito.Mockito.*

fun getMockAppCompatActivity():AppCompatActivity{
    val activity = mock(AppCompatActivity::class.java)

    val lifecycle = LifecycleRegistry(activity)
    `when`(activity.lifecycle).thenReturn(lifecycle)
    lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

    `when`(activity.getDrawable(anyInt())).thenAnswer { invocation ->
        if(invocation.arguments[0] == 0){
            null
        }
        else{
            getMockDrawable()
        }
    }

    `when`(activity.getColorStateList(anyInt())).thenAnswer { invocation ->
        if(invocation.arguments[0] == 0){
            null
        }
        else{
            mock(ColorStateList::class.java)
        }
    }

    return activity
}