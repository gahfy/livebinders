package net.gahfy.livebinders.extension

import android.os.Build
import android.text.InputType
import android.text.Layout
import android.text.method.TextKeyListener
import android.text.util.Linkify
import android.util.TypedValue
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Adds a live autolink mask of the text. See [Linkify.ALL] and peers for possible
 * values.
 *
 * Avoid using [Linkify.MAP_ADDRESSES] as value as this value is deprecated.
 *
 * __Related XML attribute:__ app:liveAutoLink
 * @param mask the live autolink mask. The value must be one of null, [Linkify.ALL],
 * [Linkify.EMAIL_ADDRESSES], [Linkify.MAP_ADDRESSES], [Linkify.PHONE_NUMBERS],
 * [Linkify.WEB_URLS], or 0
 */
@BindingAdapter("liveAutoLink")
fun TextView.addLiveAutoLinkMask(mask: LiveData<Int>?) {
    addLiveData(mask, Observer { value -> setAutoLinkMask(this, value) })
}

/**
 * Adds a live min text size when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:liveAutoSizeMinTextSize
 * @param size the live min scaling text size. If the value is null, then 1 will be set.
 */
@BindingAdapter("liveAutoSizeMinTextSize")
fun TextView.addLiveAutoSizeMinTextSize(size: LiveData<Int>?) {
    addLiveData(size, Observer { value -> setAutoSizeMinTextSize(value) })
}

/**
 * Adds a live max text size when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:liveAutoSizeMaxTextSize
 * @param size the live max scaling text size. If the value is null, then 2000 will be set.
 */
@BindingAdapter("liveAutoSizeMaxTextSize")
fun TextView.addLiveAutoSizeMaxTextSize(size: LiveData<Int>?) {
    addLiveData(size, Observer { value -> setAutoSizeMaxTextSize(value) })
}

/**
 * Adds a live auto-size step size (in pixels).
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:liveAutoSizeStepGranularity
 * @param granularity the live auto-step size.
 */
@BindingAdapter("liveAutoSizeStepGranularity")
fun TextView.addLiveAutoSizeStepGranularity(granularity: LiveData<Int>?) {
    addLiveData(granularity, Observer { value -> setAutoSizeStepGranularity(value) })
}

/**
 * Adds a live preset sizes (in pixels) when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:liveAutoSizePresetSizes
 * @param sizes a live int array of sizes in pixels.
 */
@BindingAdapter("liveAutoSizePresetSizes")
fun TextView.addLiveAutoSizeTextTypeUniformWithPresetSizes(sizes: LiveData<IntArray>?) {
    addLiveData(sizes, Observer { value -> setAutoSizeTextTypeUniformWithPresetSizes(value) })
}

/**
 * Adds a live text scaling type, [TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE] or
 * [TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM]
 *
 * __Related XML attribute:__ app:liveAutoSizeTextType
 * @param textType the live text type
 */
@BindingAdapter("liveAutoSizeTextType")
fun TextView.addLiveAutoSizeTextTypeWithDefaults(textType: LiveData<Int>?) {
    addLiveData(textType, Observer { value -> setAutoSizeTextType(value) })
}

/**
 * Specifies that this [TextView] has a textual input method and adds the specified live auto
 * correct method
 *
 * __Related XML attribute:__ app:liveAutoText
 * @param autoText the live auto correct to apply on the [TextView]
 */
@BindingAdapter("liveAutoText")
fun TextView.addLiveAutoText(autoText: LiveData<Boolean>?) {
    addLiveData(autoText, Observer { value -> setAutoText(value) })
}

/**
 * Adds a live break strategy for breaking paragraphs into lines.
 *
 * The value must be one of [Layout.BREAK_STRATEGY_SIMPLE], [Layout.BREAK_STRATEGY_HIGH_QUALITY] or
 * [Layout.BREAK_STRATEGY_BALANCED].
 *
 * __Related XML attribute:__ app:liveBreakStrategy
 * @param breakStrategy the live break strategy to apply on the [TextView]
 */
@BindingAdapter("liveBreakStrategy")
fun TextView.addLiveBreakStrategy(breakStrategy: LiveData<Int>?) {
    addLiveData(breakStrategy, Observer { value -> setNullableBreakStrategyForAllVersions(value) })
}

/**
 * Adds a minimum live type that getText() will return.
 *
 * __Related XML attribute:__ app:liveBufferType
 * @param bufferType the live type to set to the [TextView]
 */
@BindingAdapter("liveBufferType")
fun TextView.addLiveBufferType(bufferType: LiveData<TextView.BufferType>?) {
    addLiveData(bufferType, Observer { value -> setNullableBufferType(value) })
}

/**
 * Specifies that this [TextView] has a textual input method and should automatically apply the
 * value of the specified live capitalize method when the user types.
 *
 * __Related XML attribute:__ app:liveCapitalize
 * @param capitalize the live capitalize method to apply on the [TextView]
 */
@BindingAdapter("liveCapitalize")
fun TextView.addLiveCapitalize(capitalize: LiveData<TextKeyListener.Capitalize>?) {
    addLiveData(capitalize, Observer { value -> setCapitalize(value) })
}

/**
 * Sets a live visibility for the cursor.
 *
 * __Related XML attribute:__ app:liveCursorVisible
 * @param cursorVisible the live visibility method to apply on the cursor of this [TextView]
 */
@BindingAdapter("liveCursorVisible")
fun TextView.addLiveCursorVisible(cursorVisible: LiveData<Boolean>?) {
    addLiveData(cursorVisible, Observer { value -> setNullableCursorVisible(value) })
}


/** The minimum min text size that can be set without error */
private const val MIN_SETTABLE_AUTO_SIZE_MIN_TEXT_SIZE = 1
/** The default min text size */
private const val DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE = 1


/** The minimum max text size that can be set without error */
private const val MIN_SETTABLE_AUTO_SIZE_MAX_TEXT_SIZE = 1
/** The default max text size */
private const val DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE = 2000

/** The minimum granularity that can be set without error */
private const val MIN_SETTABLE_AUTO_SIZE_GRANULARITY = 1
/** The default granularity */
private const val DEFAULT_AUTO_SIZE_GRANULARITY = 1

/**
 * Sets the autolink mask of the text. See [Linkify.ALL] and peers for possible values.
 * @param textView the TextView with the text on which to apply the autolink mask
 * @param mask the autolink mask to apply on the TextView
 */
private fun setAutoLinkMask(textView: TextView, mask: Int?) {
    // Safe as we want to be compatible with deprecated code
    @Suppress("DEPRECATION")
    textView.autoLinkMask = when (mask) {
        Linkify.ALL -> Linkify.ALL
        Linkify.EMAIL_ADDRESSES -> Linkify.EMAIL_ADDRESSES
        Linkify.PHONE_NUMBERS -> Linkify.PHONE_NUMBERS
        Linkify.MAP_ADDRESSES -> Linkify.MAP_ADDRESSES
        Linkify.WEB_URLS -> Linkify.WEB_URLS
        else -> 0
    }
    // We have to set the text again to apply autolink
    textView.text = textView.text.toString()
}

/**
 * Specifies the min text size when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * @param size the min scaling text size. If the value is null or below 1, then 1 will be set.
 */
private fun TextView.setAutoSizeMinTextSize(size: Int?) {
    val minTextSize = getSettableAutoSizeMinTextSize(size)
    val maxTextSize = Math.max(minTextSize + 1, getSettableAutoSizeMaxTextSize(TextViewCompat.getAutoSizeMaxTextSize(this)))

    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
            this,
            minTextSize,
            maxTextSize,
            getSettableAutoSizeGranularity(TextViewCompat.getAutoSizeStepGranularity(this)),
            TypedValue.COMPLEX_UNIT_PX
    )
}

/**
 * Specifies the max text size when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * @param size the max scaling text size. If the value is null or below 1, then 2000 will be set.
 */
private fun TextView.setAutoSizeMaxTextSize(size: Int?) {
    val maxTextSize = getSettableAutoSizeMaxTextSize(size)
    val minTextSize = Math.min(maxTextSize - 1, getSettableAutoSizeMinTextSize(TextViewCompat.getAutoSizeMinTextSize(this)))
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
            this,
            minTextSize,
            maxTextSize,
            getSettableAutoSizeGranularity(TextViewCompat.getAutoSizeStepGranularity(this)),
            TypedValue.COMPLEX_UNIT_PX
    )
}

/**
 * Specifies the auto-size step size (in pixels). Overwrites autoSizePresetSizes if set.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * @param granularity the auto-step size.
 */
private fun TextView.setAutoSizeStepGranularity(granularity: Int?) {
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
            this,
            getSettableAutoSizeMinTextSize(TextViewCompat.getAutoSizeMinTextSize(this)),
            getSettableAutoSizeMaxTextSize(TextViewCompat.getAutoSizeMaxTextSize(this)),
            getSettableAutoSizeGranularity(granularity),
            TypedValue.COMPLEX_UNIT_PX
    )
}

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit
 * within the layout bounds. If at least one value from the `presetSizes` is valid
 * then the type of auto-size is set to [TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * @param sizes an int array of sizes in pixels*
 * @throws IllegalArgumentException if all of the <code>presetSizes</code> are invalid.
 */
private fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(sizes: IntArray?) {
    if (sizes != null) {
        TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(
                this,
                sizes,
                TypedValue.COMPLEX_UNIT_PX
        )
    }
}

/**
 * Specifies a text scaling type, [TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE] or
 * [TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM]
 *
 * @param textType the text type to apply
 */
private fun TextView.setAutoSizeTextType(textType: Int?) {
    TextViewCompat.setAutoSizeTextTypeWithDefaults(
            this,
            getSettableAutoSizeTextType(textType)
    )
}

/**
 * Specifies that this [TextView] has a textual input method and whether it automatically corrects
 * some common spelling errors.
 *
 * @param autoText the auto correct to apply on the [TextView]
 */
private fun TextView.setAutoText(autoText: Boolean?) {
    val capitalize = getCapitalize()
    val capitalizeInputType = getInputTypeForCapitalize(capitalize)

    val inputType = EditorInfo.TYPE_CLASS_TEXT

    if (autoText == true) {
        this.inputType = inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT).or(capitalizeInputType)
    } else {
        this.inputType = inputType.and(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT.inv()).or(capitalizeInputType)
    }
    keyListener = TextKeyListener.getInstance((autoText == true), capitalize)
}

/**
 * Specifies that the [TextView] has a textual input method and should automatically apply the value
 * of the specified capitalize method when the user types.
 *
 * @param capitalize the capitalize method to apply on the [TextView]
 */
private fun TextView.setCapitalize(capitalize: TextKeyListener.Capitalize?) {
    val inputType = EditorInfo.TYPE_CLASS_TEXT
    this.inputType = inputType.or(getInputTypeForCapitalize(capitalize)).or(if (getAutoText()) InputType.TYPE_TEXT_FLAG_AUTO_CORRECT else 0)
    this.keyListener = TextKeyListener.getInstance(getAutoText(), capitalize)
}

/**
 * Returns the capitalize value which is currently applied to TextView
 * @return the capitalize value which is currently applied to TextView
 */
private fun TextView.getCapitalize(): TextKeyListener.Capitalize? {
    if (keyListener != null && keyListener is TextKeyListener) {
        return when (inputType) {
            inputType.or(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS) -> TextKeyListener.Capitalize.CHARACTERS
            inputType.or(InputType.TYPE_TEXT_FLAG_CAP_WORDS) -> TextKeyListener.Capitalize.WORDS
            inputType.or(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES) -> TextKeyListener.Capitalize.SENTENCES
            else -> TextKeyListener.Capitalize.NONE
        }
    }
    return null
}

/**
 * Returns whether auto text is currently applied to TextView or not
 * @return whether auto text is currently applied to TextView or not
 */
private fun TextView.getAutoText(): Boolean = (keyListener != null && keyListener is TextKeyListener && inputType == inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT))

/**
 * Sets the break strategy of the TextView even if it's null or below version M.
 *
 * If break strategy is null, or version below M, nothing will be done
 * @param breakStrategy the break strategy to apply to the TextView
 */
private fun TextView.setNullableBreakStrategyForAllVersions(breakStrategy: Int?) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.breakStrategy = when (breakStrategy) {
            Layout.BREAK_STRATEGY_BALANCED -> Layout.BREAK_STRATEGY_BALANCED
            Layout.BREAK_STRATEGY_HIGH_QUALITY -> Layout.BREAK_STRATEGY_HIGH_QUALITY
            Layout.BREAK_STRATEGY_SIMPLE -> Layout.BREAK_STRATEGY_SIMPLE
            else -> if (this is EditText) Layout.BREAK_STRATEGY_SIMPLE else Layout.BREAK_STRATEGY_HIGH_QUALITY
        }
    }
}

/**
 * Sets a BufferType that may be null.
 *
 * @param bufferType the BufferType to set which may be null
 */
private fun TextView.setNullableBufferType(bufferType: TextView.BufferType?) {
    setText(text, bufferType ?: TextView.BufferType.NORMAL)
}

/**
 * Sets a cursor visibility which may be null.
 *
 * @param cursorVisible the cursor visibility to set which may be null
 */
private fun TextView.setNullableCursorVisible(cursorVisible: Boolean?) {
    isCursorVisible = (cursorVisible == true)
}

/**
 * Returns the given size if it is a correct min text size, or a default one otherwise.
 * @param size the min text size, which may be correct or not
 * @return the given size if it is a correct min text size, or a default one otherwise.
 */
private fun getSettableAutoSizeMinTextSize(size: Int?): Int = if (size == null || size <= MIN_SETTABLE_AUTO_SIZE_MIN_TEXT_SIZE) DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE else size

/**
 * Returns the given size if it is a correct max text size, or a default one otherwise.
 * @param size the max text size, which may be correct or not
 * @return the given size if it is a correct max text size, or a default one otherwise.
 */
private fun getSettableAutoSizeMaxTextSize(size: Int?): Int = if (size == null || size < MIN_SETTABLE_AUTO_SIZE_MAX_TEXT_SIZE) DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE else size

/**
 * Returns the given granularity if it is a correct granularity, or a default one otherwise.
 * @param granularity the granularity, which may be correct or not
 * @return the given granularity if it is a correct granularity, or a default one otherwise.
 */
private fun getSettableAutoSizeGranularity(granularity: Int?): Int = if (granularity == null || granularity <= MIN_SETTABLE_AUTO_SIZE_GRANULARITY) DEFAULT_AUTO_SIZE_GRANULARITY else granularity

/**
 * Returns the given text type if it is a correct text type, or
 * [TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE] otherwise.
 * @param textType the text type, which may be correct or not
 * @return the given text type if it is a correct text type, or
 * [TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE] otherwise.
 */
private fun getSettableAutoSizeTextType(textType: Int?): Int = if (textType == TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM) TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM else TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE

/**
 * Returns the Input Type value for a given Capitalize value
 * @param capitalize the Capitalize value for which to get the matching InputType
 * @return the Input Type value for a given Capitalize value
 */
private fun getInputTypeForCapitalize(capitalize: TextKeyListener.Capitalize?): Int = when (capitalize) {
    TextKeyListener.Capitalize.SENTENCES -> InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
    TextKeyListener.Capitalize.WORDS -> InputType.TYPE_TEXT_FLAG_CAP_WORDS
    TextKeyListener.Capitalize.CHARACTERS -> InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
    else -> 0
}