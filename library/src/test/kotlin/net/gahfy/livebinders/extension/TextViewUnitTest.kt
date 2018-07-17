package net.gahfy.livebinders.extension

import android.os.Build
import android.text.util.Linkify
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
}