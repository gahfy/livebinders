package net.gahfy.livebinders.testutils

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.method.DigitsKeyListener
import android.text.method.KeyListener
import android.text.method.TextKeyListener
import android.widget.TextView
import androidx.core.graphics.drawable.TintAwareDrawable
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
private var inputType = 0
private var keyListener: KeyListener? = null
private var breakStrategy = -1
private var bufferType = TextView.BufferType.NORMAL
private var textContent: CharSequence = ""
private var cursorVisible = false
private var drawableLeft:CustomDrawable? = null
private var drawableStart:CustomDrawable? = null
private var drawableRight:CustomDrawable? = null
private var drawableEnd:CustomDrawable? = null
private var drawableTop:CustomDrawable? = null
private var drawableBottom:CustomDrawable? = null
private var drawablePadding:Int = 0

fun resetTextView(){
    autoLinkValue = 0
    autoSizeMax = -1
    autoSizeMin = -1
    autoSizeGranularity = -1
    autoSizePresets = intArrayOf()
    autoSizeTextType = 0
    inputType = 0
    breakStrategy = -1
    bufferType = TextView.BufferType.NORMAL
    textContent = ""
    cursorVisible = false
    keyListener = null
    drawableLeft = null
    drawableStart = null
    drawableRight = null
    drawableEnd = null
    drawableTop = null
    drawableBottom = null
    drawablePadding = 0
}

val mockTextView:TextView
    get(){
        val parentActivity = getMockAppCompatActivity()
        val textView = Mockito.mock(TextView::class.java)

        `when`(textView.context).thenReturn(parentActivity)

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
            val tempAutoSizePresets = mutableListOf<Int>()
            for (size in (invocation.arguments[0] as IntArray)) {
                if (size >= 1) {
                    tempAutoSizePresets.add(size)
                }
            }
            if (tempAutoSizePresets.size == 0) {
                throw IllegalArgumentException("None of the preset sizes is valid: $tempAutoSizePresets")
            }
            autoSizePresets = tempAutoSizePresets.toIntArray()
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


        // Key Listener
        `when`(textView.setKeyListener(ArgumentMatchers.any(DigitsKeyListener::class.java))).thenAnswer { invocation ->
            keyListener = invocation.arguments[0] as DigitsKeyListener?
            null
        }
        `when`(textView.setKeyListener(ArgumentMatchers.any(TextKeyListener::class.java))).thenAnswer { invocation ->
            keyListener = invocation.arguments[0] as TextKeyListener?
            null
        }
        `when`(textView.keyListener).thenAnswer { keyListener }

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

        // Compound Drawable
        `when`(textView.setCompoundDrawablesWithIntrinsicBounds(nullable(CustomDrawable::class.java), nullable(CustomDrawable::class.java), nullable(CustomDrawable::class.java), nullable(CustomDrawable::class.java))).thenAnswer { invocation ->
            drawableLeft = invocation.arguments[0] as CustomDrawable?
            drawableTop = invocation.arguments[1] as CustomDrawable?
            drawableRight = invocation.arguments[2] as CustomDrawable?
            drawableBottom = invocation.arguments[3] as CustomDrawable?
            null
        }
        `when`(textView.setCompoundDrawablesRelativeWithIntrinsicBounds(nullable(CustomDrawable::class.java), nullable(CustomDrawable::class.java), nullable(CustomDrawable::class.java), nullable(CustomDrawable::class.java))).thenAnswer { invocation ->
            drawableStart = invocation.arguments[0] as CustomDrawable?
            drawableTop = invocation.arguments[1] as CustomDrawable?
            drawableEnd = invocation.arguments[2] as CustomDrawable?
            drawableBottom = invocation.arguments[3] as CustomDrawable?
            null
        }
        `when`(textView.setCompoundDrawableTintList(nullable(ColorStateList::class.java))).thenAnswer { invocation ->
            if(drawableStart is TintAwareDrawable)
                drawableStart?.setTintList(invocation.arguments[0] as ColorStateList?)
            if(drawableLeft is TintAwareDrawable)
                drawableLeft?.setTintList(invocation.arguments[0] as ColorStateList?)
            if(drawableEnd is TintAwareDrawable)
                drawableEnd?.setTintList(invocation.arguments[0] as ColorStateList?)
            if(drawableRight is TintAwareDrawable)
                drawableRight?.setTintList(invocation.arguments[0] as ColorStateList?)
            if(drawableTop is TintAwareDrawable)
                drawableTop?.setTintList(invocation.arguments[0] as ColorStateList?)
            if(drawableBottom is TintAwareDrawable)
                drawableBottom?.setTintList(invocation.arguments[0] as ColorStateList?)
        }
        `when`(textView.setCompoundDrawableTintMode(nullable(PorterDuff.Mode::class.java))).thenAnswer { invocation ->
            if(drawableStart is TintAwareDrawable)
                drawableStart?.setTintMode(invocation.arguments[0] as PorterDuff.Mode?)
            if(drawableLeft is TintAwareDrawable)
                drawableLeft?.setTintMode(invocation.arguments[0] as PorterDuff.Mode?)
            if(drawableEnd is TintAwareDrawable)
                drawableEnd?.setTintMode(invocation.arguments[0] as PorterDuff.Mode?)
            if(drawableRight is TintAwareDrawable)
                drawableRight?.setTintMode(invocation.arguments[0] as PorterDuff.Mode?)
            if(drawableTop is TintAwareDrawable)
                drawableTop?.setTintMode(invocation.arguments[0] as PorterDuff.Mode?)
            if(drawableBottom is TintAwareDrawable)
                drawableBottom?.setTintMode(invocation.arguments[0] as PorterDuff.Mode?)
        }
        `when`(textView.setCompoundDrawablePadding(anyInt())).thenAnswer { invocation ->
            drawablePadding = invocation.arguments[0] as Int
            null
        }
        `when`(textView.compoundDrawables).thenAnswer {
            arrayOf(drawableLeft, drawableTop, drawableRight, drawableBottom)
        }
        `when`(textView.compoundDrawablesRelative).thenAnswer {
            arrayOf(drawableStart, drawableTop, drawableEnd, drawableBottom)
        }
        `when`(textView.compoundDrawablePadding).thenAnswer { drawablePadding }

        return textView
    }

private fun setText(invocation: InvocationOnMock): Void? {
    net.gahfy.livebinders.testutils.textContent = invocation.arguments[0]?.toString()?:""
    net.gahfy.livebinders.testutils.bufferType = invocation.arguments[1] as TextView.BufferType
    return null
}