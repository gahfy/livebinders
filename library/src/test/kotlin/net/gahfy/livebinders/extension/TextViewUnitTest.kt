package net.gahfy.livebinders.extension

import android.text.util.Linkify
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import net.gahfy.livebinders.databinding.setMutableAutoLinkMask
import net.gahfy.livebinders.databinding.setMutableAutoSizeMaxTextSize
import net.gahfy.livebinders.testutils.mockTextView
import net.gahfy.livebinders.testutils.resetTextView
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
    fun textview_setautosizemax() {
        val textView = mockTextView

        val mutableAutoSizeMax = MutableLiveData<Int>()

        textView.setMutableAutoSizeMaxTextSize(mutableAutoSizeMax)
        mutableAutoSizeMax.value = 100

        Assert.assertEquals("Autosizemax value must change", 100, textView.autoSizeMaxTextSize)
    }
}