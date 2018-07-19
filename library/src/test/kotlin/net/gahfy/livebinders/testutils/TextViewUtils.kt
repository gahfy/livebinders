package net.gahfy.livebinders.testutils

import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.invocation.InvocationOnMock

private var autoLinkValue = 0
private var autoSizeMax = -1
private var autoSizeMin = -1
private var autoSizeGranularity = -1
private var autoSizePresets = intArrayOf()
private var autoSizeTextType = 0
private var inputType = 1
private var breakStrategy = 1
private var bufferType = TextView.BufferType.NORMAL
private var textContent: CharSequence = ""
private var cursorVisible = false

fun resetTextView(){
    autoLinkValue = 0
    autoSizeMax = -1
    autoSizeMin = -1
    autoSizeGranularity = -1
    autoSizePresets = intArrayOf()
    autoSizeTextType = 0
    inputType = 1
    breakStrategy = 1
    bufferType = TextView.BufferType.NORMAL
    textContent = ""
    cursorVisible = false
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

        // Autosize text type
        `when`(textView.setAutoSizeTextTypeWithDefaults(ArgumentMatchers.anyInt())).thenAnswer { invocation ->
            autoSizeTextType = invocation.arguments[0] as Int
            null
        }
        `when`(textView.autoSizeTextType).thenAnswer { autoSizeTextType }

        // Input Type
        `when`(textView.setInputType(ArgumentMatchers.anyInt())).thenAnswer { invocation ->
            inputType = invocation.arguments[0] as Int
            null
        }
        `when`(textView.inputType).thenAnswer { inputType }

        // Break Strategy
        `when`(textView.setBreakStrategy(ArgumentMatchers.anyInt())).thenAnswer { invocation ->
            breakStrategy = invocation.arguments[0] as Int
            null
        }
        `when`(textView.breakStrategy).thenAnswer { breakStrategy }

        // Buffer Type
        `when`(textView.setText(ArgumentMatchers.any(CharSequence::class.java), any(TextView.BufferType::class.java))).thenAnswer { invocation -> setText(invocation) }
        `when`(textView.setText(ArgumentMatchers.any(String::class.java), any(TextView.BufferType::class.java))).thenAnswer { invocation -> setText(invocation) }
        `when`(textView.setText(ArgumentMatchers.any(SpannableString::class.java), any(TextView.BufferType::class.java))).thenAnswer { invocation -> setText(invocation) }
        `when`(textView.setText(ArgumentMatchers.any(SpannableStringBuilder::class.java), any(TextView.BufferType::class.java))).thenAnswer { invocation -> setText(invocation) }
        `when`(textView.text).thenAnswer {
            when (bufferType) {
                TextView.BufferType.NORMAL ->
                    textContent
                TextView.BufferType.SPANNABLE ->
                    SpannableString(textContent)
                TextView.BufferType.EDITABLE ->
                    SpannableStringBuilder(textContent)
            }
        }

        // Cursor Visible
        `when`(textView.setCursorVisible(anyBoolean())).thenAnswer { invocation -> cursorVisible = invocation.arguments[0] as Boolean; null }
        `when`(textView.isCursorVisible).thenAnswer { cursorVisible }

        val lifecycle = LifecycleRegistry(parentActivity)
        `when`(parentActivity.lifecycle).thenReturn(lifecycle)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        return textView
    }

private fun setText(invocation: InvocationOnMock): Void? {
    net.gahfy.livebinders.testutils.textContent = invocation.arguments[0] as CharSequence
    net.gahfy.livebinders.testutils.bufferType = invocation.arguments[1] as TextView.BufferType
    return null
}