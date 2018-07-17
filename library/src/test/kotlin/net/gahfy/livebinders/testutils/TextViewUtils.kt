package net.gahfy.livebinders.testutils

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito
import org.mockito.Mockito.`when`

private var autoLinkValue = 0
private var autoSizeMax = -1
private var autoSizeMin = -1
private var autoSizeGranularity = -1
private var autoSizePresets = intArrayOf()


fun resetTextView(){
    autoLinkValue = 0
}

val mockTextView:TextView
    get(){
        val parentActivity = Mockito.mock(AppCompatActivity::class.java)
        val textView = Mockito.mock(TextView::class.java)

        `when`(textView.context).thenReturn(parentActivity)
        `when`(textView.text).thenReturn("test")

        // Autolink
        `when`(textView.setAutoLinkMask(ArgumentMatchers.anyInt())).thenAnswer { invocation ->
            autoLinkValue = invocation.arguments[0] as Int
            null
        }
        `when`(textView.autoLinkMask).thenAnswer { autoLinkValue }

        // Autosize min max granularity
        `when`(textView.setAutoSizeTextTypeUniformWithConfiguration(anyInt(), anyInt(), anyInt(), anyInt())).thenAnswer { invocation ->
            autoSizeMin = invocation.arguments[0] as Int
            autoSizeMax = invocation.arguments[1] as Int
            autoSizeGranularity = invocation.arguments[2] as Int
            null
        }
        `when`(textView.autoSizeMinTextSize).thenAnswer { autoSizeMin }
        `when`(textView.autoSizeMaxTextSize).thenAnswer { autoSizeMax }
        `when`(textView.autoSizeStepGranularity).thenAnswer { autoSizeGranularity }

        // Autosize presets
        `when`(textView.setAutoSizeTextTypeUniformWithPresetSizes(any(IntArray::class.java), anyInt())).thenAnswer { invocation ->
            autoSizePresets = invocation.arguments[0] as IntArray
            null
        }
        `when`(textView.autoSizeTextAvailableSizes).thenAnswer { autoSizePresets }

        val lifecycle = LifecycleRegistry(parentActivity)
        `when`(parentActivity.lifecycle).thenReturn(lifecycle)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        return textView
    }