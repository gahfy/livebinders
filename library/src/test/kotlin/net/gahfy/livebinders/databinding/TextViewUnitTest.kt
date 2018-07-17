package net.gahfy.livebinders.databinding

import android.content.Context
import android.os.Build
import android.text.util.Linkify
import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import net.gahfy.livebinders.testutils.mockTextView
import net.gahfy.livebinders.testutils.resetTextView
import net.gahfy.livebinders.testutils.setFinalStatic
import org.junit.Assert.assertEquals
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
}