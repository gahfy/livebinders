package net.gahfy.livebinders.extension

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Editable
import android.text.InputType
import android.text.Layout
import android.text.Spannable
import android.text.method.DigitsKeyListener
import android.text.method.TextKeyListener
import android.text.util.Linkify
import android.util.TypedValue
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.core.widget.TextViewCompat
import androidx.lifecycle.MutableLiveData
import net.gahfy.livebinders.testutils.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.mock


class TextViewUnitTest{
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        setFinalStatic(Build.VERSION::class.java.getField("SDK_INT"), 28)
        resetTextView()
        resetEditText()
    }

    @Test
    fun textview_addLiveAutolinkMask() {
        // Given
        val textView = mockTextView
        val liveAutoLink = MutableLiveData<Int>()

        // When
        textView.addLiveAutoLinkMask(liveAutoLink)

        // Then
        liveAutoLink.value = Linkify.ALL
        assertEquals("Autolink mask of TextView should have been updated", Linkify.ALL, textView.autoLinkMask)
        liveAutoLink.value = 100
        assertEquals("Autolink mask of TextView should have been updated", 0, textView.autoLinkMask)
        liveAutoLink.value = Linkify.EMAIL_ADDRESSES
        assertEquals("Autolink mask of TextView should have been updated", Linkify.EMAIL_ADDRESSES, textView.autoLinkMask)
        liveAutoLink.value = Linkify.PHONE_NUMBERS
        assertEquals("Autolink mask of TextView should have been updated", Linkify.PHONE_NUMBERS, textView.autoLinkMask)
        // Safe as it is here only for tests
        @Suppress("DEPRECATION")
        liveAutoLink.value = Linkify.MAP_ADDRESSES
        // Safe as it is here only for tests
        @Suppress("DEPRECATION")
        assertEquals("Autolink mask of TextView should have been updated", Linkify.MAP_ADDRESSES, textView.autoLinkMask)
        liveAutoLink.value = Linkify.WEB_URLS
        assertEquals("Autolink mask of TextView should have been updated", Linkify.WEB_URLS, textView.autoLinkMask)
        liveAutoLink.value = null
        assertEquals("Autolink mask of TextView should have been updated", 0, textView.autoLinkMask)
    }

    @Test
    fun textview_addLiveAutoSizeMinTextSize() {
        // Given
        val textView = mockTextView
        val liveAutoSizeMinTextSize = MutableLiveData<Int>()

        // When
        textView.addLiveAutoSizeMinTextSize(liveAutoSizeMinTextSize)

        // Then
        liveAutoSizeMinTextSize.value = 0
        assertEquals("Min text size of TextView should have been updated", 1, textView.autoSizeMinTextSize)
        textView.setAutoSizeTextTypeUniformWithConfiguration(10, 5, 1, TypedValue.COMPLEX_UNIT_PX)
        liveAutoSizeMinTextSize.value = 20
        assertEquals("Min text size of TextView should have been updated", 20, textView.autoSizeMinTextSize)
        assertEquals("Max text size of TextView should have been updated", 21, textView.autoSizeMaxTextSize)
        liveAutoSizeMinTextSize.value = null
        assertEquals("Min text size of TextView should have been updated", 1, textView.autoSizeMinTextSize)
    }

    @Test
    fun textview_addLiveAutoSizeMaxTextSize() {
        // Given
        val textView = mockTextView
        val liveAutoSizeMaxTextSize = MutableLiveData<Int>()

        // When
        textView.addLiveAutoSizeMaxTextSize(liveAutoSizeMaxTextSize)

        // Then
        liveAutoSizeMaxTextSize.value = 0
        assertEquals("Max text size of TextView should have been updated", 2000, textView.autoSizeMaxTextSize)
        textView.setAutoSizeTextTypeUniformWithConfiguration(30, 50, 1, TypedValue.COMPLEX_UNIT_PX)
        liveAutoSizeMaxTextSize.value = 20
        assertEquals("Max text size of TextView should have been updated", 20, textView.autoSizeMaxTextSize)
        assertEquals("Min text size of TextView should have been updated", 19, textView.autoSizeMinTextSize)
        liveAutoSizeMaxTextSize.value = null
        assertEquals("Max text size of TextView should have been updated", 2000, textView.autoSizeMaxTextSize)
    }

    @Test
    fun textview_addLiveAutoSizeStepGranularity() {
        // Given
        val textView = mockTextView
        val liveAutoSizeStepGranularity = MutableLiveData<Int>()

        // When
        textView.addLiveAutoSizeStepGranularity(liveAutoSizeStepGranularity)

        // Then
        liveAutoSizeStepGranularity.value = 0
        assertEquals("Granularity of TextView should have been updated", 1, textView.autoSizeStepGranularity)
        liveAutoSizeStepGranularity.value = 20
        assertEquals("Granularity of TextView should have been updated", 20, textView.autoSizeStepGranularity)
        liveAutoSizeStepGranularity.value = null
        assertEquals("Granularity of TextView should have been updated", 1, textView.autoSizeStepGranularity)
    }

    @Test
    fun textview_addLiveAutoSizeTextTypeUniformWithPresetSizes() {
        // Given
        val textView = mockTextView
        val liveAutoSizeTextTypeUniformWithPresetSizes = MutableLiveData<IntArray>()

        // When
        textView.addLiveAutoSizeTextTypeUniformWithPresetSizes(liveAutoSizeTextTypeUniformWithPresetSizes)

        // Then
        liveAutoSizeTextTypeUniformWithPresetSizes.value = intArrayOf(1, 2, 3)
        assertArrayEquals("Available sizes of TextView should have been updated", intArrayOf(1, 2, 3), textView.autoSizeTextAvailableSizes)
        liveAutoSizeTextTypeUniformWithPresetSizes.value = intArrayOf(-1, -2, 3)
        assertArrayEquals("Available sizes of TextView should have been updated", intArrayOf(3), textView.autoSizeTextAvailableSizes)
        liveAutoSizeTextTypeUniformWithPresetSizes.value = null
        assertArrayEquals("Available sizes of TextView should have been updated", intArrayOf(3), textView.autoSizeTextAvailableSizes)

        var exceptionThrown = false
        try {
            liveAutoSizeTextTypeUniformWithPresetSizes.value = intArrayOf(-1, -2, -3)
        } catch (e: IllegalArgumentException) {
            exceptionThrown = true
        }
        assertTrue("Exception must have been thrown with invalid preset sizes", exceptionThrown)
        assertArrayEquals("Available sizes of TextView should have not been updated", intArrayOf(3), textView.autoSizeTextAvailableSizes)
    }

    @Test
    fun textview_addLiveAutoSizeTextTypeWithDefaults() {
        // Given
        val textView = mockTextView
        val liveAutoSizeTextTypeWithDefaults = MutableLiveData<Int>()

        // When
        textView.addLiveAutoSizeTextTypeWithDefaults(liveAutoSizeTextTypeWithDefaults)

        // Then
        liveAutoSizeTextTypeWithDefaults.value = 100
        assertEquals("Text type of TextView should have been updated", TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE, textView.autoSizeTextType)
        liveAutoSizeTextTypeWithDefaults.value = TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM
        assertEquals("Text type of TextView should have been updated", TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM, textView.autoSizeTextType)
        liveAutoSizeTextTypeWithDefaults.value = null
        assertEquals("Text type of TextView should have been updated", TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE, textView.autoSizeTextType)
    }

    @Test
    fun textview_addLiveAutoText() {
        // Given
        val textView = mockTextView
        val liveAutoText = MutableLiveData<Boolean>()

        // When
        textView.addLiveAutoText(liveAutoText)

        // Then
        // Null Key Listener
        liveAutoText.value = false
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)
        liveAutoText.value = true
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT), textView.inputType)
        liveAutoText.value = null
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)

        // Not Text Key Listener
        val digitsKeyListener = mock(DigitsKeyListener::class.java)
        textView.keyListener = digitsKeyListener
        liveAutoText.value = false
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)

        // TextKeyListener and Words
        resetTextView()
        val textKeyListener = mock(TextKeyListener::class.java)
        textView.inputType = textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_WORDS)
        textView.keyListener = textKeyListener
        liveAutoText.value = false
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_FLAG_CAP_WORDS), textView.inputType)

        // TextKeyListener and Sentences
        resetTextView()
        textView.inputType = textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES)
        textView.keyListener = textKeyListener
        liveAutoText.value = false
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES), textView.inputType)

        // TextKeyListener and Character
        resetTextView()
        textView.inputType = textView.inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS)
        textView.keyListener = textKeyListener
        liveAutoText.value = false
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)

        // TextKeyListener and Nothing
        resetTextView()
        textView.keyListener = textKeyListener
        liveAutoText.value = false
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)
    }

    @Test
    fun textView_addLiveBreakStrategy() {
        // Given
        val textView = mockTextView
        val editText = mockEditText
        val liveBreakStrategy = MutableLiveData<Int>()

        // When
        textView.addLiveBreakStrategy(liveBreakStrategy)
        editText.addLiveBreakStrategy(liveBreakStrategy)

        // Then
        liveBreakStrategy.value = 300
        assertEquals("Break strategy of TextView should have been updated", Layout.BREAK_STRATEGY_HIGH_QUALITY, textView.breakStrategy)
        assertEquals("Break strategy of EditText should have been updated", Layout.BREAK_STRATEGY_SIMPLE, editText.breakStrategy)
        liveBreakStrategy.value = Layout.BREAK_STRATEGY_BALANCED
        assertEquals("Break strategy of TextView should have been updated", Layout.BREAK_STRATEGY_BALANCED, textView.breakStrategy)
        assertEquals("Break strategy of EditText should have been updated", Layout.BREAK_STRATEGY_BALANCED, editText.breakStrategy)
        liveBreakStrategy.value = Layout.BREAK_STRATEGY_HIGH_QUALITY
        assertEquals("Break strategy of TextView should have been updated", Layout.BREAK_STRATEGY_HIGH_QUALITY, textView.breakStrategy)
        assertEquals("Break strategy of EditText should have been updated", Layout.BREAK_STRATEGY_HIGH_QUALITY, editText.breakStrategy)
        liveBreakStrategy.value = Layout.BREAK_STRATEGY_SIMPLE
        assertEquals("Break strategy of TextView should have been updated", Layout.BREAK_STRATEGY_SIMPLE, textView.breakStrategy)
        assertEquals("Break strategy of EditText should have been updated", Layout.BREAK_STRATEGY_SIMPLE, editText.breakStrategy)
        liveBreakStrategy.value = Layout.BREAK_STRATEGY_BALANCED
        assertEquals("Break strategy of TextView should have been updated", Layout.BREAK_STRATEGY_BALANCED, textView.breakStrategy)
        assertEquals("Break strategy of EditText should have been updated", Layout.BREAK_STRATEGY_BALANCED, editText.breakStrategy)
        liveBreakStrategy.value = null
        assertEquals("Break strategy of TextView should have been updated", Layout.BREAK_STRATEGY_HIGH_QUALITY, textView.breakStrategy)
        assertEquals("Break strategy of EditText should have been updated", Layout.BREAK_STRATEGY_SIMPLE, editText.breakStrategy)

        setFinalStatic(Build.VERSION::class.java.getField("SDK_INT"), 22)
        resetTextView()
        resetEditText()
        textView.addLiveBreakStrategy(liveBreakStrategy)
        editText.addLiveBreakStrategy(liveBreakStrategy)
        liveBreakStrategy.value = 300
        assertEquals("Break strategy of TextView should have not been updated", -1, textView.breakStrategy)
        assertEquals("Break strategy of EditText should have not been updated", -1, editText.breakStrategy)
    }

    @Test
    fun textview_addLiveBufferType() {
        // Given
        val textView = mockTextView
        val liveBufferType = MutableLiveData<TextView.BufferType>()

        // When
        textView.addLiveBufferType(liveBufferType)

        // Then
        liveBufferType.value = TextView.BufferType.NORMAL
        assertTrue("Buffer type should have been considered", textView.text is CharSequence)
        assertFalse("Buffer type should have been considered", textView.text is Spannable)
        assertFalse("Buffer type should have been considered", textView.text is Editable)
        liveBufferType.value = TextView.BufferType.SPANNABLE
        assertTrue("Buffer type should have been considered", textView.text is Spannable)
        assertFalse("Buffer type should have been considered", textView.text is Editable)
        liveBufferType.value = TextView.BufferType.EDITABLE
        assertTrue("Buffer type should have been considered", textView.text is Editable)
        liveBufferType.value = null
        assertTrue("Buffer type should have been considered", textView.text is CharSequence)
        assertFalse("Buffer type should have been considered", textView.text is Spannable)
        assertFalse("Buffer type should have been considered", textView.text is Editable)
    }

    @Test
    fun textview_addCapitalize() {
        // Given
        val textView = mockTextView
        val liveCapitalize = MutableLiveData<TextKeyListener.Capitalize>()

        // When
        textView.addLiveCapitalize(liveCapitalize)

        // Then
        // Null Key Listener
        liveCapitalize.value = TextKeyListener.Capitalize.NONE
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)
        liveCapitalize.value = TextKeyListener.Capitalize.CHARACTERS
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS), textView.inputType)
        liveCapitalize.value = TextKeyListener.Capitalize.WORDS
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_FLAG_CAP_WORDS), textView.inputType)
        liveCapitalize.value = TextKeyListener.Capitalize.SENTENCES
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES), textView.inputType)
        liveCapitalize.value = null
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)

        // Not Text Key Listener
        val digitsKeyListener = mock(DigitsKeyListener::class.java)
        textView.keyListener = digitsKeyListener
        liveCapitalize.value = TextKeyListener.Capitalize.NONE
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)

        // TextKeyListener and AutoCorrect
        resetTextView()
        val textKeyListener = mock(TextKeyListener::class.java)
        textView.inputType = textView.inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT)
        textView.keyListener = textKeyListener
        liveCapitalize.value = TextKeyListener.Capitalize.NONE
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT), textView.inputType)

        // TextKeyListener and No Auto Correct
        resetTextView()
        textView.inputType = textView.inputType.and(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT.inv())
        textView.keyListener = textKeyListener
        liveCapitalize.value = TextKeyListener.Capitalize.NONE
        assertEquals("Input type of TextView should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)
    }

    @Test
    fun textview_addLiveCursorVisible() {
        // Given
        val textView = mockTextView
        val liveCursorVisible = MutableLiveData<Boolean>()

        // When
        textView.addLiveCursorVisible(liveCursorVisible)

        // Then
        liveCursorVisible.value = false
        assertEquals("Cursor visible must have been updated", false, textView.isCursorVisible)
        liveCursorVisible.value = true
        assertEquals("Cursor visible must have been updated", true, textView.isCursorVisible)
        liveCursorVisible.value = null
        assertEquals("Cursor visible must have been updated", false, textView.isCursorVisible)
    }

    @Test
    fun textview_addLiveDigits() {
        // Given
        val textView = mockTextView
        val liveDigits = MutableLiveData<String>()

        // When
        textView.addLiveDigits(liveDigits)

        // Then
        liveDigits.value = null
        assertEquals("Input type must have not been updated", textView.inputType, InputType.TYPE_NULL)
        liveDigits.value = "123"
        assertEquals("Input type must have been updated", textView.inputType, InputType.TYPE_CLASS_TEXT)
        textView.inputType = InputType.TYPE_CLASS_NUMBER
        liveDigits.value = "12345"
        assertEquals("Input type must have not been updated", textView.inputType, InputType.TYPE_CLASS_NUMBER)
    }

    @Test
    fun textview_addLiveDrawableBottom(){
        // Given
        val textView = mockTextView
        val liveDrawableBottom = MutableLiveData<Drawable>()

        // When
        textView.addLiveDrawableBottom(liveDrawableBottom)

        // Then
        val currentDrawableBottom = getMockDrawable()
        liveDrawableBottom.value = currentDrawableBottom
        assertSame("Drawable bottom should have been updated", textView.compoundDrawables[3], currentDrawableBottom)
        assertNotSame("Drawable left should have not been updated", textView.compoundDrawables[0], currentDrawableBottom)
        assertNotSame("Drawable top should have not been updated", textView.compoundDrawables[1], currentDrawableBottom)
        assertNotSame("Drawable right should have not been updated", textView.compoundDrawables[2], currentDrawableBottom)
    }

    @Test
    fun textview_addLiveDrawableResIdBottom(){
        // Given
        val textView = mockTextView
        val liveDrawableResIdBottom = MutableLiveData<Int>()

        // When
        textView.addLiveDrawableResIdBottom(liveDrawableResIdBottom)

        // Then
        liveDrawableResIdBottom.value = null
        assertNull("Drawable bottom should have not been updated", textView.compoundDrawables[3])
        liveDrawableResIdBottom.value = 0
        assertNull("Drawable bottom should have not been updated", textView.compoundDrawables[3])
        liveDrawableResIdBottom.value = 123
        assertNotNull("Drawable bottom should have been updated", textView.compoundDrawables[3])
    }

    @Test
    fun textview_addLiveDrawableEnd(){
        // Given
        val textView = mockTextView
        val liveDrawableEnd = MutableLiveData<Drawable>()

        // When
        textView.addLiveDrawableEnd(liveDrawableEnd)

        // Then
        val currentDrawableEnd = getMockDrawable()
        liveDrawableEnd.value = currentDrawableEnd
        assertSame("Drawable end should have been updated", textView.compoundDrawablesRelative[2], currentDrawableEnd)
        assertNotSame("Drawable start should have not been updated", textView.compoundDrawablesRelative[0], currentDrawableEnd)
        assertNotSame("Drawable top should have not been updated", textView.compoundDrawablesRelative[1], currentDrawableEnd)
        assertNotSame("Drawable bottom should have not been updated", textView.compoundDrawablesRelative[3], currentDrawableEnd)
    }

    @Test
    fun textview_addLiveDrawableResIdEnd(){
        // Given
        val textView = mockTextView
        val liveDrawableResIdEnd = MutableLiveData<Int>()

        // When
        textView.addLiveDrawableResIdEnd(liveDrawableResIdEnd)

        // Then
        liveDrawableResIdEnd.value = null
        assertNull("Drawable end should have not been updated", textView.compoundDrawablesRelative[2])
        liveDrawableResIdEnd.value = 0
        assertNull("Drawable end should have not been updated", textView.compoundDrawablesRelative[2])
        liveDrawableResIdEnd.value = 123
        assertNotNull("Drawable end should have been updated", textView.compoundDrawablesRelative[2])
    }

    @Test
    fun textview_addLiveDrawableLeft(){
        // Given
        val textView = mockTextView
        val liveDrawableLeft = MutableLiveData<Drawable>()

        // When
        textView.addLiveDrawableLeft(liveDrawableLeft)

        // Then
        val currentDrawableLeft = getMockDrawable()
        liveDrawableLeft.value = currentDrawableLeft
        assertSame("Drawable left should have been updated", textView.compoundDrawables[0], currentDrawableLeft)
        assertNotSame("Drawable top should have not been updated", textView.compoundDrawables[1], currentDrawableLeft)
        assertNotSame("Drawable right should have not been updated", textView.compoundDrawables[2], currentDrawableLeft)
        assertNotSame("Drawable bottom should have not been updated", textView.compoundDrawables[3], currentDrawableLeft)
    }

    @Test
    fun textview_addLiveDrawableResIdLeft(){
        // Given
        val textView = mockTextView
        val liveDrawableResIdLeft = MutableLiveData<Int>()

        // When
        textView.addLiveDrawableResIdLeft(liveDrawableResIdLeft)

        // Then
        liveDrawableResIdLeft.value = null
        assertNull("Drawable left should have not been updated", textView.compoundDrawables[0])
        liveDrawableResIdLeft.value = 0
        assertNull("Drawable left should have not been updated", textView.compoundDrawables[0])
        liveDrawableResIdLeft.value = 123
        assertNotNull("Drawable left should have been updated", textView.compoundDrawables[0])
    }

    @Test
    fun textview_addLiveDrawablePadding(){
        // Given
        val textView = mockTextView
        val liveDrawablePadding = MutableLiveData<Int>()

        // When
        textView.addLiveDrawablePadding(liveDrawablePadding)

        // Then
        liveDrawablePadding.value = 123
        assertEquals("Drawable padding should have been updated", textView.compoundDrawablePadding, 123)
        liveDrawablePadding.value = null
        assertEquals("Drawable padding should have not been updated", textView.compoundDrawablePadding, 123)
        liveDrawablePadding.value = 12
        assertEquals("Drawable padding should have been updated", textView.compoundDrawablePadding, 12)
    }

    @Test
    fun textview_addLiveDrawableRight(){
        // Given
        val textView = mockTextView
        val liveDrawableRight = MutableLiveData<Drawable>()

        // When
        textView.addLiveDrawableRight(liveDrawableRight)

        // Then
        val currentDrawableRight = getMockDrawable()
        liveDrawableRight.value = currentDrawableRight
        assertSame("Drawable right should have been updated", textView.compoundDrawables[2], currentDrawableRight)
        assertNotSame("Drawable left should have not been updated", textView.compoundDrawables[0], currentDrawableRight)
        assertNotSame("Drawable top should have not been updated", textView.compoundDrawables[1], currentDrawableRight)
        assertNotSame("Drawable bottom should have not been updated", textView.compoundDrawables[3], currentDrawableRight)
    }

    @Test
    fun textview_addLiveDrawableResIdRight(){
        // Given
        val textView = mockTextView
        val liveDrawableResIdRight = MutableLiveData<Int>()

        // When
        textView.addLiveDrawableResIdRight(liveDrawableResIdRight)

        // Then
        liveDrawableResIdRight.value = null
        assertNull("Drawable left should have not been updated", textView.compoundDrawables[2])
        liveDrawableResIdRight.value = 0
        assertNull("Drawable left should have not been updated", textView.compoundDrawables[2])
        liveDrawableResIdRight.value = 123
        assertNotNull("Drawable left should have been updated", textView.compoundDrawables[2])
    }

    @Test
    fun textview_addLiveDrawableStart(){
        // Given
        val textView = mockTextView
        val liveDrawableStart = MutableLiveData<Drawable>()

        // When
        textView.addLiveDrawableStart(liveDrawableStart)

        // Then
        val currentDrawableStart = getMockDrawable()
        liveDrawableStart.value = currentDrawableStart
        assertSame("Drawable start should have been updated", textView.compoundDrawablesRelative[0], currentDrawableStart)
        assertNotSame("Drawable top should have not been updated", textView.compoundDrawablesRelative[1], currentDrawableStart)
        assertNotSame("Drawable end should have not been updated", textView.compoundDrawablesRelative[2], currentDrawableStart)
        assertNotSame("Drawable bottom should have not been updated", textView.compoundDrawablesRelative[3], currentDrawableStart)
    }

    @Test
    fun textview_addLiveDrawableResIdStart(){
        // Given
        val textView = mockTextView
        val liveDrawableResIdStart = MutableLiveData<Int>()

        // When
        textView.addLiveDrawableResIdStart(liveDrawableResIdStart)

        // Then
        liveDrawableResIdStart.value = null
        assertNull("Drawable start should have not been updated", textView.compoundDrawablesRelative[0])
        liveDrawableResIdStart.value = 0
        assertNull("Drawable start should have not been updated", textView.compoundDrawablesRelative[0])
        liveDrawableResIdStart.value = 123
        assertNotNull("Drawable start should have been updated", textView.compoundDrawablesRelative[0])
    }

    @Test
    fun textview_addLiveDrawableTint(){
        // Given
        val textView = mockTextView
        val liveDrawableTint = MutableLiveData<ColorStateList>()

        // When
        textView.addLiveDrawableTint(liveDrawableTint)

        val drawableLeft = getMockDrawable()
        val drawableTop = getMockDrawable()
        val drawableRight = getMockDrawable()
        val drawableBottom = getMockDrawable()

        val appliedColorStateList = mock(ColorStateList::class.java)

        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)

        // Then
        liveDrawableTint.value = appliedColorStateList
        assertSame("Drawable left tint should have been updated", appliedColorStateList, (textView.compoundDrawables[0] as CustomDrawable).getTintList())
        assertSame("Drawable top tint should have been updated", appliedColorStateList, (textView.compoundDrawables[1] as CustomDrawable).getTintList())
        assertSame("Drawable right tint should have been updated", appliedColorStateList, (textView.compoundDrawables[2] as CustomDrawable).getTintList())
        assertSame("Drawable bottom tint should have been updated", appliedColorStateList, (textView.compoundDrawables[3] as CustomDrawable).getTintList())
    }

    @Test
    fun textview_addLiveDrawableTintBelowM(){
        // Given
        setFinalStatic(Build.VERSION::class.java.getField("SDK_INT"), 22)
        val textView = mockTextView
        val liveDrawableTint = MutableLiveData<ColorStateList>()

        // When
        textView.addLiveDrawableTint(liveDrawableTint)

        val drawableLeft = getMockDrawable()
        val drawableTop = getMockDrawable()
        val drawableRight = getMockDrawable()
        val drawableBottom = getMockDrawable()

        val appliedColorStateList = mock(ColorStateList::class.java)

        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)

        // Then
        liveDrawableTint.value = appliedColorStateList
        assertSame("Drawable left tint should have been updated", appliedColorStateList, (textView.compoundDrawables[0] as CustomDrawable).getTintList())
        assertSame("Drawable top tint should have been updated", appliedColorStateList, (textView.compoundDrawables[1] as CustomDrawable).getTintList())
        assertSame("Drawable right tint should have been updated", appliedColorStateList, (textView.compoundDrawables[2] as CustomDrawable).getTintList())
        assertSame("Drawable bottom tint should have been updated", appliedColorStateList, (textView.compoundDrawables[3] as CustomDrawable).getTintList())

        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        var noException = true
        try{
            liveDrawableTint.value = appliedColorStateList
        }
        catch(e:Exception){
            noException = false
        }

        assertTrue("No exception should have occurred", noException)

    }

    @Test
    fun textview_addLiveDrawableTintResId(){
        // Given
        val textView = mockTextView
        val liveDrawableTintResId = MutableLiveData<Int>()

        // When
        textView.addLiveDrawableTintResId(liveDrawableTintResId)

        val drawableLeft = getMockDrawable()
        val drawableTop = getMockDrawable()
        val drawableRight = getMockDrawable()
        val drawableBottom = getMockDrawable()

        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)

        // Then
        liveDrawableTintResId.value = 123
        assertNotNull("Drawable left tint should have been updated", (textView.compoundDrawables[0] as CustomDrawable).getTintList())
        assertNotNull("Drawable top tint should have been updated", (textView.compoundDrawables[1] as CustomDrawable).getTintList())
        assertNotNull("Drawable right tint should have been updated", (textView.compoundDrawables[2] as CustomDrawable).getTintList())
        assertNotNull("Drawable bottom tint should have been updated", (textView.compoundDrawables[3] as CustomDrawable).getTintList())
        liveDrawableTintResId.value = null
        assertNull("Drawable left tint should have been updated", (textView.compoundDrawables[0] as CustomDrawable).getTintList())
        assertNull("Drawable top tint should have been updated", (textView.compoundDrawables[1] as CustomDrawable).getTintList())
        assertNull("Drawable right tint should have been updated", (textView.compoundDrawables[2] as CustomDrawable).getTintList())
        assertNull("Drawable bottom tint should have been updated", (textView.compoundDrawables[3] as CustomDrawable).getTintList())
    }

    @Test
    fun textview_addLiveDrawableTintMode(){
        // Given
        val textView = mockTextView
        val liveDrawableTintMode = MutableLiveData<PorterDuff.Mode>()

        // When
        textView.addLiveDrawableTintMode(liveDrawableTintMode)

        val drawableLeft = getMockDrawable()
        val drawableTop = getMockDrawable()
        val drawableRight = getMockDrawable()
        val drawableBottom = getMockDrawable()

        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)

        // Then
        liveDrawableTintMode.value = PorterDuff.Mode.ADD
        assertEquals("Drawable left tint should have been updated", PorterDuff.Mode.ADD, (textView.compoundDrawables[0] as CustomDrawable).getTintMode())
        assertEquals("Drawable top tint should have been updated", PorterDuff.Mode.ADD, (textView.compoundDrawables[1] as CustomDrawable).getTintMode())
        assertEquals("Drawable right tint should have been updated", PorterDuff.Mode.ADD, (textView.compoundDrawables[2] as CustomDrawable).getTintMode())
        assertEquals("Drawable bottom tint should have been updated", PorterDuff.Mode.ADD, (textView.compoundDrawables[3] as CustomDrawable).getTintMode())
    }

    @Test
    fun textview_addLiveDrawableTintModeBelowM(){
        // Given
        setFinalStatic(Build.VERSION::class.java.getField("SDK_INT"), 22)
        val textView = mockTextView
        val liveDrawableTintMode = MutableLiveData<PorterDuff.Mode>()

        // When
        textView.addLiveDrawableTintMode(liveDrawableTintMode)

        val drawableLeft = getMockDrawable()
        val drawableTop = getMockDrawable()
        val drawableRight = getMockDrawable()
        val drawableBottom = getMockDrawable()

        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)

        // Then
        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)
        liveDrawableTintMode.value = PorterDuff.Mode.ADD
        assertEquals("Drawable left tint should have been updated", PorterDuff.Mode.ADD, (textView.compoundDrawables[0] as CustomDrawable).getTintMode())
        assertEquals("Drawable top tint should have been updated", PorterDuff.Mode.ADD, (textView.compoundDrawables[1] as CustomDrawable).getTintMode())
        assertEquals("Drawable right tint should have been updated", PorterDuff.Mode.ADD, (textView.compoundDrawables[2] as CustomDrawable).getTintMode())
        assertEquals("Drawable bottom tint should have been updated", PorterDuff.Mode.ADD, (textView.compoundDrawables[3] as CustomDrawable).getTintMode())

        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        var noException = true
        try{
            liveDrawableTintMode.value = PorterDuff.Mode.ADD
        }
        catch(e:Exception){
            noException = false
        }
        assertTrue("No exception should occur", noException)

        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)
        textView.compoundDrawableTintList = mock(ColorStateList::class.java)
        liveDrawableTintMode.value = null
        assertNull("Drawable left tint should have been updated", (textView.compoundDrawables[0] as CustomDrawable).getTintList())
        assertNull("Drawable top tint should have been updated", (textView.compoundDrawables[1] as CustomDrawable).getTintList())
        assertNull("Drawable right tint should have been updated", (textView.compoundDrawables[2] as CustomDrawable).getTintList())
        assertNull("Drawable bottom tint should have been updated", (textView.compoundDrawables[3] as CustomDrawable).getTintList())

        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        noException = true
        try{
            liveDrawableTintMode.value = null
        }
        catch(e:Exception){
            noException = false
        }
        assertTrue("No exception should occur", noException)
    }

    @Test
    fun textview_addLiveDrawableTop(){
        // Given
        val textView = mockTextView
        val liveDrawableTop = MutableLiveData<Drawable>()

        // When
        textView.addLiveDrawableTop(liveDrawableTop)

        // Then
        val currentDrawableTop = getMockDrawable()
        liveDrawableTop.value = currentDrawableTop
        assertSame("Drawable top should have been updated", textView.compoundDrawables[1], currentDrawableTop)
        assertNotSame("Drawable left should have not been updated", textView.compoundDrawables[0], currentDrawableTop)
        assertNotSame("Drawable right should have not been updated", textView.compoundDrawables[2], currentDrawableTop)
        assertNotSame("Drawable bottom should have not been updated", textView.compoundDrawables[3], currentDrawableTop)
    }

    @Test
    fun textview_addLiveDrawableResIdTop(){
        // Given
        val textView = mockTextView
        val liveDrawableResIdTop = MutableLiveData<Int>()

        // When
        textView.addLiveDrawableResIdTop(liveDrawableResIdTop)

        // Then
        liveDrawableResIdTop.value = null
        assertNull("Drawable top should have not been updated", textView.compoundDrawables[1])
        liveDrawableResIdTop.value = 0
        assertNull("Drawable top should have not been updated", textView.compoundDrawables[1])
        liveDrawableResIdTop.value = 123
        assertNotNull("Drawable top should have been updated", textView.compoundDrawables[1])
    }

    @Test
    fun textview_addLiveEditable() {
        // Given
        val textView = mockTextView
        val liveEditable = MutableLiveData<Boolean>()

        // When
        textView.addLiveEditable(liveEditable)

        // Then
        liveEditable.value = false
        assertEquals("Input type should have been updated", InputType.TYPE_NULL, textView.inputType)
        liveEditable.value = true
        assertEquals("Input type should have been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)
        liveEditable.value = null
        assertEquals("Input type should have not been updated", EditorInfo.TYPE_CLASS_TEXT, textView.inputType)
    }

    @Test
    fun textview_addLiveInputExtras() {
        // Given
        val textView = mockTextView
        val liveInputExtras = MutableLiveData<Int>()

        // When
        textView.addLiveInputExtras(liveInputExtras)

        // Then
        liveInputExtras.value = null
        assertNull("Input extras should have not been updated", textView.getInputExtras(false))
        liveInputExtras.value = 0
        assertNull("Input extras should have not been updated", textView.getInputExtras(false))
        liveInputExtras.value = 123
        assertNotNull("Input extras should have been updated", textView.getInputExtras(false))
    }
}