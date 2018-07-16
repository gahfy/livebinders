package net.gahfy.livebinders.databinding

import android.content.Context
import android.text.util.Linkify
import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import net.gahfy.livebinders.testutils.mockTextView
import net.gahfy.livebinders.testutils.resetTextView
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
    fun textview_mutableautosizemax_nonnull() {
        val textView = mockTextView

        val mutableAutoSizeMax = MutableLiveData<Int>()

        setMutableAutoSizeMaxTextSize(textView, mutableAutoSizeMax)
        mutableAutoSizeMax.value = 100

        assertEquals("Autolink value must change", 100, textView.autoSizeMaxTextSize)

        mutableAutoSizeMax.value = null

        assertEquals("Autolink value must change", 2000, textView.autoSizeMaxTextSize)
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
}