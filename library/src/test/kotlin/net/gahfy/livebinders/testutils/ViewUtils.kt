package net.gahfy.livebinders.testutils

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import org.mockito.Mockito
import org.mockito.Mockito.*

private var onClickListener: View.OnClickListener? = null

fun resetView(){
    onClickListener = null
}

val mockView: View
    get(){
        val parentActivity = Mockito.mock(AppCompatActivity::class.java)
        val view = mock(View::class.java)

        `when`(view.context).thenReturn(parentActivity)

        `when`(view.setOnClickListener(any(View.OnClickListener::class.java))).thenAnswer {
            invocation ->
            if(invocation.arguments[0] is View.OnClickListener) {
                onClickListener = invocation.arguments[0] as View.OnClickListener
            }
            null
        }

        `when`(view.callOnClick()).thenAnswer {
            onClickListener?.onClick(view)
            onClickListener != null
        }

        val lifecycle = LifecycleRegistry(parentActivity)
        `when`(parentActivity.lifecycle).thenReturn(lifecycle)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        return view
    }