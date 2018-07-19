package net.gahfy.livebinders.databinding

import android.content.Context
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
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TextViewUnitTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        setFinalStatic(Build.VERSION::class.java.getField("SDK_INT"), 28)
        resetTextView()
    }

    @Test
    fun textview_mutableautolink_nonnull() {
        val textView = mockTextView

        val mutableAutoLinkMask = MutableLiveData<Int>()

        setMutableAutoLinkMask(textView, mutableAutoLinkMask)
        mutableAutoLinkMask.value = Linkify.PHONE_NUMBERS

        assertEquals("Autolink value must change", Linkify.PHONE_NUMBERS, textView.autoLinkMask)

        mutableAutoLinkMask.value = null

        assertEquals("Autolink value must change", 0, textView.autoLinkMask)
    }

    @Test
    fun textview_mutableautolink_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoLinkMask = MutableLiveData<Int>()

        setMutableAutoLinkMask(textView, mutableAutoLinkMask)
        mutableAutoLinkMask.value = 100
    }

    @Test
    fun textview_mutableautolink_nullmask() {
        // Assert no exception
        val textView = mockTextView

        val mutableAutoLinkMask:MutableLiveData<Int>? = null

        setMutableAutoLinkMask(textView, mutableAutoLinkMask)
        mutableAutoLinkMask?.value = 100
    }

    @Test
    fun textview_mutableautolink_nullmaskandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoLinkMask:MutableLiveData<Int>? = null

        setMutableAutoLinkMask(textView, mutableAutoLinkMask)
        mutableAutoLinkMask?.value = 100
    }

    @Test
    fun textview_mutableautosizemin_nonnull() {
        val textView = mockTextView

        val mutableAutoSizeMin = MutableLiveData<Int>()

        setMutableAutoSizeMinTextSize(textView, mutableAutoSizeMin)
        mutableAutoSizeMin.value = 100

        assertEquals("Autosizemin value must change", 100, textView.autoSizeMinTextSize)

        mutableAutoSizeMin.value = null

        assertEquals("Autosizemin value must change", 1, textView.autoSizeMinTextSize)
    }

    @Test
    fun textview_mutableautosizemin_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizeMin = MutableLiveData<Int>()

        setMutableAutoSizeMinTextSize(textView, mutableAutoSizeMin)
        mutableAutoSizeMin.value = 100
    }

    @Test
    fun textview_mutableautosizemin_nullautosizemin() {
        // Assert no exception
        val textView = mockTextView

        val mutableAutoSizeMin: MutableLiveData<Int>? = null

        setMutableAutoSizeMinTextSize(textView, mutableAutoSizeMin)
        mutableAutoSizeMin?.value = 100
    }

    @Test
    fun textview_mutableautosizemin_nullautosizeminandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizeMin: MutableLiveData<Int>? = null

        setMutableAutoSizeMinTextSize(textView, mutableAutoSizeMin)
        mutableAutoSizeMin?.value = 100
    }

    @Test
    fun textview_mutableautosizemax_nonnull() {
        val textView = mockTextView

        val mutableAutoSizeMax = MutableLiveData<Int>()

        setMutableAutoSizeMaxTextSize(textView, mutableAutoSizeMax)
        mutableAutoSizeMax.value = 100

        assertEquals("Autosizemax value must change", 100, textView.autoSizeMaxTextSize)

        mutableAutoSizeMax.value = null

        assertEquals("Autosizemax value must change", 2000, textView.autoSizeMaxTextSize)
    }

    @Test
    fun textview_mutableautosizemax_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizeMax = MutableLiveData<Int>()

        setMutableAutoSizeMaxTextSize(textView, mutableAutoSizeMax)
        mutableAutoSizeMax.value = 100
    }

    @Test
    fun textview_mutableautosizemax_nullautosizemax() {
        // Assert no exception
        val textView = mockTextView

        val mutableAutoSizeMax:MutableLiveData<Int>? = null

        setMutableAutoSizeMaxTextSize(textView, mutableAutoSizeMax)
        mutableAutoSizeMax?.value = 100
    }

    @Test
    fun textview_mutableautosizemax_nullautosizemaxandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizeMax:MutableLiveData<Int>? = null

        setMutableAutoSizeMaxTextSize(textView, mutableAutoSizeMax)
        mutableAutoSizeMax?.value = 100
    }

    @Test
    fun textview_mutableautosizepreset_nonnull() {
        val textView = mockTextView

        val mutableAutoSizePresets = MutableLiveData<IntArray>()

        setMutableAutoSizePresetSizes(textView, mutableAutoSizePresets)
        mutableAutoSizePresets.value = intArrayOf(1, 2, 3)

        assertEquals("Autosizemax value must change", 1, textView.autoSizeTextAvailableSizes[0])
        assertEquals("Autosizemax value must change", 2, textView.autoSizeTextAvailableSizes[1])
        assertEquals("Autosizemax value must change", 3, textView.autoSizeTextAvailableSizes[2])
    }

    @Test
    fun textview_mutableautosizepreset_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizePresets = MutableLiveData<IntArray>()

        setMutableAutoSizePresetSizes(textView, mutableAutoSizePresets)
        mutableAutoSizePresets.value = intArrayOf(1, 2, 3)
    }

    @Test
    fun textview_mutableautosizepreset_nullautosizepreset() {
        // Assert no exception
        val textView = mockTextView

        val mutableAutoSizePresets: MutableLiveData<IntArray>? = null

        setMutableAutoSizePresetSizes(textView, mutableAutoSizePresets)
        mutableAutoSizePresets?.value = intArrayOf(1, 2, 3)
    }

    @Test
    fun textview_mutableautosizepreset_nullautosizepresetandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizePresets: MutableLiveData<IntArray>? = null

        setMutableAutoSizePresetSizes(textView, mutableAutoSizePresets)
        mutableAutoSizePresets?.value = intArrayOf(1, 2, 3)
    }

    @Test
    fun textview_mutableautosizegranularity_nonnull() {
        val textView = mockTextView

        val mutableAutoSizeGranularity = MutableLiveData<Int>()

        setMutableAutoSizeStepGranularity(textView, mutableAutoSizeGranularity)
        mutableAutoSizeGranularity.value = 100

        assertEquals("Autosizegranularity value must change", 100, textView.autoSizeStepGranularity)

        mutableAutoSizeGranularity.value = null

        assertEquals("Autosizegranularity value must change", 1, textView.autoSizeStepGranularity)
    }

    @Test
    fun textview_mutableautosizegranularity_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizeGranularity = MutableLiveData<Int>()

        setMutableAutoSizeStepGranularity(textView, mutableAutoSizeGranularity)
        mutableAutoSizeGranularity.value = 100
    }

    @Test
    fun textview_mutableautosizegranularity_nullautosizegranularity() {
        // Assert no exception
        val textView = mockTextView

        val mutableAutoSizeGranularity: MutableLiveData<Int>? = null

        setMutableAutoSizeStepGranularity(textView, mutableAutoSizeGranularity)
        mutableAutoSizeGranularity?.value = 100
    }

    @Test
    fun textview_mutableautosizegranularity_nullautosizegranularityandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizeGranularity: MutableLiveData<Int>? = null

        setMutableAutoSizeStepGranularity(textView, mutableAutoSizeGranularity)
        mutableAutoSizeGranularity?.value = 100
    }

    @Test
    fun textview_mutableautosizetexttype_nonnull() {
        val textView = mockTextView

        val mutableAutoSizeTextType = MutableLiveData<Int>()

        setMutableAutoSizeTextType(textView, mutableAutoSizeTextType)
        mutableAutoSizeTextType.value = 1

        assertEquals("Auto size text type value must change", 1, textView.autoSizeTextType)

        mutableAutoSizeTextType.value = 100

        assertEquals("Auto size text type value must change", 0, textView.autoSizeTextType)

        mutableAutoSizeTextType.value = null

        assertEquals("Auto size text type value must change", 0, textView.autoSizeTextType)
    }

    @Test
    fun textview_mutableautosizetexttype_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizeTextType = MutableLiveData<Int>()

        setMutableAutoSizeTextType(textView, mutableAutoSizeTextType)
        mutableAutoSizeTextType.value = 1
    }

    @Test
    fun textview_mutableautosizetexttype_nullautosizetexttype() {
        // Assert no exception
        val textView = mockTextView

        val mutableAutoSizeTextType: MutableLiveData<Int>? = null

        setMutableAutoSizeTextType(textView, mutableAutoSizeTextType)
        mutableAutoSizeTextType?.value = 1
    }

    @Test
    fun textview_mutableautosizetexttype_nullautosizetexttypeandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoSizeTextType: MutableLiveData<Int>? = null

        setMutableAutoSizeTextType(textView, mutableAutoSizeTextType)
        mutableAutoSizeTextType?.value = 100
    }

    @Test
    fun textview_mutableautotext_nonnull() {
        val textView = mockTextView

        val mutableAutoText = MutableLiveData<Boolean>()
        val mutableCapitalize = MutableLiveData<TextKeyListener.Capitalize>()

        setMutableAutoText(textView, mutableAutoText)
        setMutableCapitalize(textView, mutableCapitalize)

        mutableCapitalize.value = TextKeyListener.Capitalize.NONE
        mutableAutoText.value = false
        assertNotEquals("autotext value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT), textView.inputType)

        mutableCapitalize.value = TextKeyListener.Capitalize.SENTENCES
        mutableAutoText.value = true
        assertEquals("autotext value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT), textView.inputType)

        mutableCapitalize.value = TextKeyListener.Capitalize.WORDS
        mutableAutoText.value = null
        assertNotEquals("autotext value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT), textView.inputType)

        // Assert no crash
        mutableCapitalize.value = TextKeyListener.Capitalize.CHARACTERS
        mutableAutoText.value = null
        mutableCapitalize.value = TextKeyListener.Capitalize.NONE
        mutableAutoText.value = null
    }

    @Test
    fun textview_mutableautotext_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoText = MutableLiveData<Boolean>()

        setMutableAutoText(textView, mutableAutoText)
        mutableAutoText.value = true
    }

    @Test
    fun textview_mutableautotext_nullautotext() {
        // Assert no exception
        val textView = mockTextView

        val mutableAutoText: MutableLiveData<Boolean>? = null

        setMutableAutoText(textView, mutableAutoText)
        mutableAutoText?.value = true
    }

    @Test
    fun textview_mutableautotext_nullautotextandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableAutoText: MutableLiveData<Boolean>? = null

        setMutableAutoText(textView, mutableAutoText)
        mutableAutoText?.value = true
    }

    @Test
    fun textview_mutablebreakingstrategy_nonnull() {
        val textView = mockTextView

        val mutableBreakStrategy = MutableLiveData<Int>()

        setMutableBreakStrategy(textView, mutableBreakStrategy)
        mutableBreakStrategy.value = Layout.BREAK_STRATEGY_BALANCED

        assertEquals("breaking strategy value must change", Layout.BREAK_STRATEGY_BALANCED, textView.breakStrategy)

        mutableBreakStrategy.value = Layout.BREAK_STRATEGY_SIMPLE

        assertEquals("breaking strategy value must change", Layout.BREAK_STRATEGY_SIMPLE, textView.breakStrategy)

        // Assert no exception
        mutableBreakStrategy.value = null
    }

    @Test
    fun textview_mutablebreakingstrategy_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableBreakStrategy = MutableLiveData<Int>()

        setMutableBreakStrategy(textView, mutableBreakStrategy)
        mutableBreakStrategy.value = 1
    }

    @Test
    fun textview_mutablebreakingstrategy_nullbreakingstrategy() {
        // Assert no exception
        val textView = mockTextView

        val mutableBreakStrategy: MutableLiveData<Int>? = null

        setMutableBreakStrategy(textView, mutableBreakStrategy)
        mutableBreakStrategy?.value = 1
    }

    @Test
    fun textview_mutablebreakingstrategy_nullbreakingstrategyandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableBreakStrategy: MutableLiveData<Int>? = null

        setMutableBreakStrategy(textView, mutableBreakStrategy)
        mutableBreakStrategy?.value = 100
    }

    @Test
    fun textview_mutablebuffertype_nonnull() {
        val textView = mockTextView

        val mutableBufferType = MutableLiveData<TextView.BufferType>()

        setMutableBufferType(textView, mutableBufferType)
        mutableBufferType.value = TextView.BufferType.EDITABLE
        Assert.assertTrue("buffertype value must change", textView.text is Editable)
        mutableBufferType.value = TextView.BufferType.SPANNABLE
        Assert.assertFalse("buffertype value must change", textView.text is Editable)
        Assert.assertTrue("buffertype value must change", textView.text is Spannable)

        // Assert no exception
        mutableBufferType.value = null
    }

    @Test
    fun textview_mutablebuffertype_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableBufferType = MutableLiveData<TextView.BufferType>()

        setMutableBufferType(textView, mutableBufferType)
        mutableBufferType.value = TextView.BufferType.SPANNABLE
    }

    @Test
    fun textview_mutablebuffertype_nullbuffertype() {
        // Assert no exception
        val textView = mockTextView

        val mutableBufferType: MutableLiveData<TextView.BufferType>? = null

        setMutableBufferType(textView, mutableBufferType)
        mutableBufferType?.value = TextView.BufferType.SPANNABLE
    }

    @Test
    fun textview_mutablebuffertype_nullbuffertypeandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableBufferType: MutableLiveData<TextView.BufferType>? = null

        setMutableBufferType(textView, mutableBufferType)
        mutableBufferType?.value = TextView.BufferType.SPANNABLE
    }

    @Test
    fun textview_mutablecapitalize_nonnull() {
        val textView = mockTextView

        val mutableCapitalize = MutableLiveData<TextKeyListener.Capitalize>()
        val mutableAutoText = MutableLiveData<Boolean>()

        setMutableCapitalize(textView, mutableCapitalize)
        setMutableAutoText(textView, mutableAutoText)

        mutableAutoText.value = true
        mutableCapitalize.value = TextKeyListener.Capitalize.CHARACTERS
        Assert.assertEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)
        mutableCapitalize.value = TextKeyListener.Capitalize.NONE
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_WORDS), textView.inputType)
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES), textView.inputType)
        mutableCapitalize.value = TextKeyListener.Capitalize.WORDS
        Assert.assertEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_WORDS), textView.inputType)
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)
        mutableCapitalize.value = TextKeyListener.Capitalize.SENTENCES
        Assert.assertEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES), textView.inputType)
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)
        mutableCapitalize.value = null
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_WORDS), textView.inputType)
        Assert.assertNotEquals("capitalize value must change", textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES), textView.inputType)
        // Assert no exception
        mutableAutoText.value = false
        mutableCapitalize.value = null
    }

    @Test
    fun textview_mutablecapitalize_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableCapitalize = MutableLiveData<TextKeyListener.Capitalize>()

        setMutableCapitalize(textView, mutableCapitalize)
        mutableCapitalize.value = TextKeyListener.Capitalize.CHARACTERS
    }

    @Test
    fun textview_mutablecapitalize_nullbuffertype() {
        // Assert no exception
        val textView = mockTextView

        val mutableCapitalize: MutableLiveData<TextKeyListener.Capitalize>? = null

        setMutableCapitalize(textView, mutableCapitalize)
        mutableCapitalize?.value = TextKeyListener.Capitalize.CHARACTERS
    }

    @Test
    fun textview_mutablecapitalize_nullbuffertypeandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableCapitalize: MutableLiveData<TextKeyListener.Capitalize>? = null

        setMutableCapitalize(textView, mutableCapitalize)
        mutableCapitalize?.value = TextKeyListener.Capitalize.CHARACTERS
    }


    @Test
    fun textview_mutablecursorvisible_nonnull() {
        val textView = mockTextView

        val mutableCursorVisibility = MutableLiveData<Boolean>()

        setMutableCursorVisible(textView, mutableCursorVisibility)

        mutableCursorVisibility.value = true
        assertEquals("cursor visibility value must change", true, textView.isCursorVisible)

        mutableCursorVisibility.value = false
        assertEquals("cursor visibility value must change", false, textView.isCursorVisible)

        mutableCursorVisibility.value = null
        assertEquals("cursor visibility value must change", false, textView.isCursorVisible)
    }

    @Test
    fun textview_mutablecursorvisible_nullparentactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableCursorVisibility = MutableLiveData<Boolean>()

        setMutableCursorVisible(textView, mutableCursorVisibility)
        mutableCursorVisibility.value = true
    }

    @Test
    fun textview_mutablecursorvisible_nullcursorvisible() {
        // Assert no exception
        val textView = mockTextView

        val mutableCursorVisibility: MutableLiveData<Boolean>? = null

        setMutableCursorVisible(textView, mutableCursorVisibility)
        mutableCursorVisibility?.value = true
    }

    @Test
    fun textview_mutablecursorvisible_nullcursorvisibleandactivity() {
        // Assert no exception
        val textView = mock(TextView::class.java)
        `when`(textView.context).thenReturn(mock(Context::class.java))

        val mutableCursorVisibility: MutableLiveData<Boolean>? = null

        setMutableCursorVisible(textView, mutableCursorVisibility)
        mutableCursorVisibility?.value = true
    }
}