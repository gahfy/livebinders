package net.gahfy.livebinders.testutils

import android.view.View
import org.mockito.Mockito.*

private var onClickListener: View.OnClickListener? = null

fun resetView(){
    onClickListener = null
}

val mockView: View
    get(){
        val view = mock(View::class.java)

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

        return view
    }