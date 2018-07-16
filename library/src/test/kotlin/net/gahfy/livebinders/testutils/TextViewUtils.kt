package net.gahfy.livebinders.testutils

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

private var autoLinkValue = 0
private var autoSizeMax = -1
private var autoSizeMin = -1
private var autoSizeGranularity = -1


fun resetTextView(){
    autoLinkValue = 0
}

val mockTextView:TextView
    get(){
        val parentActivity = Mockito.mock(AppCompatActivity::class.java)
        val textView = Mockito.mock(TextView::class.java)

        Mockito.`when`(textView.context).thenReturn(parentActivity)
        Mockito.`when`(textView.text).thenReturn("test")

        // Autolink
        Mockito.`when`(textView.setAutoLinkMask(ArgumentMatchers.anyInt())).thenAnswer { invocation ->
            autoLinkValue = invocation.arguments[0] as Int
            null
        }
        Mockito.`when`(textView.autoLinkMask).thenAnswer { autoLinkValue }

        // Autosize
        Mockito.`when`(textView.setAutoSizeTextTypeUniformWithConfiguration(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenAnswer { invocation ->
            autoSizeMin = invocation.arguments[0] as Int
            autoSizeMax = invocation.arguments[1] as Int
            autoSizeGranularity = invocation.arguments[2] as Int
            null
        }
        Mockito.`when`(textView.autoSizeMinTextSize).thenAnswer { autoSizeMin }
        Mockito.`when`(textView.autoSizeMaxTextSize).thenAnswer { autoSizeMax }
        Mockito.`when`(textView.autoSizeStepGranularity).thenAnswer { autoSizeGranularity }

        val lifecycle = LifecycleRegistry(parentActivity)
        Mockito.`when`(parentActivity.lifecycle).thenReturn(lifecycle)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        return textView
    }