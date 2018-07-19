package net.gahfy.livebinders.extension

import android.os.Build
import android.text.Editable
import android.text.InputType
import android.text.Layout
import android.text.Spannable
import android.text.method.TextKeyListener
import android.text.util.Linkify
import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import net.gahfy.livebinders.testutils.mockTextView
import net.gahfy.livebinders.testutils.resetTextView
import net.gahfy.livebinders.testutils.setFinalStatic
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class TextViewUnitTest{
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        setFinalStatic(Build.VERSION::class.java.getField("SDK_INT"), 28)
        resetTextView()
    }

    @Test
    fun textview_setautlink() {
        val textView = mockTextView

        val mutableAutoLinkMask = MutableLiveData<Int>()

        textView.setMutableAutoLinkMask(mutableAutoLinkMask)
        mutableAutoLinkMask.value = Linkify.PHONE_NUMBERS

        Assert.assertEquals("Autolink value must change", Linkify.PHONE_NUMBERS, textView.autoLinkMask)
    }

    @Test
    fun textview_setautosizemin() {
        val textView = mockTextView

        val mutableAutoSizeMin = MutableLiveData<Int>()

        textView.setMutableAutoSizeMinTextSize(mutableAutoSizeMin)
        mutableAutoSizeMin.value = 100

        Assert.assertEquals("Autosizemin value must change", 100, textView.autoSizeMinTextSize)
    }

    @Test
    fun textview_setautosizemax() {
        val textView = mockTextView

        val mutableAutoSizeMax = MutableLiveData<Int>()

        textView.setMutableAutoSizeMaxTextSize(mutableAutoSizeMax)
        mutableAutoSizeMax.value = 100

        Assert.assertEquals("Autosizemax value must change", 100, textView.autoSizeMaxTextSize)
    }

    @Test
    fun textview_setautosizepresets() {
        val textView = mockTextView

        val mutableAutoSizePresets = MutableLiveData<IntArray>()

        textView.setMutableAutoSizeTextTypeUniformWithPresetSizes(mutableAutoSizePresets)
        mutableAutoSizePresets.value = intArrayOf(1, 2, 3)

        Assert.assertEquals("Autosizepresets value must change", 1, textView.autoSizeTextAvailableSizes[0])
        Assert.assertEquals("Autosizepresets value must change", 2, textView.autoSizeTextAvailableSizes[1])
        Assert.assertEquals("Autosizepresets value must change", 3, textView.autoSizeTextAvailableSizes[2])
    }

    @Test
    fun textview_setautosizegranularity() {
        val textView = mockTextView

        val mutableGranularity = MutableLiveData<Int>()

        textView.setMutableAutoSizeStepGranularity(mutableGranularity)
        mutableGranularity.value = 100

        Assert.assertEquals("Autosizemax value must change", 100, textView.autoSizeStepGranularity)
    }

    @Test
    fun textview_setautosizetexttype() {
        val textView = mockTextView

        val mutableTextType = MutableLiveData<Int>()

        textView.setMutableAutoSizeTextTypeWithDefaults(mutableTextType)
        mutableTextType.value = 1

        Assert.assertEquals("Autosizemax value must change", 1, textView.autoSizeTextType)
    }

    @Test
    fun textview_setautotext() {
        val textView = mockTextView

        val mutableAutoText = MutableLiveData<Boolean>()

        textView.setMutableAutoText(mutableAutoText)
        mutableAutoText.value = false
        Assert.assertNotEquals("autotext value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT), textView.inputType)
        mutableAutoText.value = true
        Assert.assertEquals("autotext value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT), textView.inputType)
    }

    @Test
    fun textview_setbreakstrategy() {
        val textView = mockTextView

        val mutableBreakStrategy = MutableLiveData<Int>()

        textView.setMutableBreakStrategy(mutableBreakStrategy)
        mutableBreakStrategy.value = Layout.BREAK_STRATEGY_BALANCED

        Assert.assertEquals("breakstrategy value must change", Layout.BREAK_STRATEGY_BALANCED, textView.breakStrategy)
    }

    @Test
    fun textview_setbuffertype() {
        val textView = mockTextView

        val mutableBufferType = MutableLiveData<TextView.BufferType>()

        textView.setMutableBufferType(mutableBufferType)
        mutableBufferType.value = TextView.BufferType.EDITABLE
        Assert.assertTrue("buffertype value must change", textView.text is Editable)
        mutableBufferType.value = TextView.BufferType.SPANNABLE
        Assert.assertFalse("buffertype value must change", textView.text is Editable)
        Assert.assertTrue("buffertype value must change", textView.text is Spannable)
    }

    @Test
    fun textview_setcapitalize() {
        val textView = mockTextView

        val mutableCapitalize = MutableLiveData<TextKeyListener.Capitalize>()

        textView.setMutableCapitalize(mutableCapitalize)
        mutableCapitalize.value = TextKeyListener.Capitalize.CHARACTERS
        Assert.assertEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)
        mutableCapitalize.value = TextKeyListener.Capitalize.NONE
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_WORDS), textView.inputType)
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES), textView.inputType)
    }

    @Test
    fun textview_setcursorvisible() {
        val textView = mockTextView

        val mutableCursorVisible = MutableLiveData<Boolean>()

        textView.setMutableCursorVisible(mutableCursorVisible)
        mutableCursorVisible.value = true
        Assert.assertEquals("cursor visible value must change", true, textView.isCursorVisible)
        mutableCursorVisible.value = false
        Assert.assertEquals("cursor visible value must change", false, textView.isCursorVisible)
        mutableCursorVisible.value = null
        Assert.assertEquals("cursor visible value must change", false, textView.isCursorVisible)
    }
}