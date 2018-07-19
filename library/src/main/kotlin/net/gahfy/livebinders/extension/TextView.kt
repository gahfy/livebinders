package net.gahfy.livebinders.extension

import android.annotation.TargetApi
import android.os.Build
import android.text.Layout
import android.text.method.TextKeyListener
import android.text.util.Linkify
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.lifecycle.MutableLiveData
import net.gahfy.livebinders.databinding.*

/**
 * Sets the mutable autolink mask of the text. See [Linkify.ALL] and peers for possible
 * values.
 *
 * Avoid using [Linkify.MAP_ADDRESSES] as value as this value is deprecated.
 *
 * __Related XML attribute:__ app:mutableAutoLink
 * @param mask the mutable autolink mask. The value must be one of null, [Linkify.ALL],
 * [Linkify.EMAIL_ADDRESSES], [Linkify.EMAIL_ADDRESSES], [Linkify.PHONE_NUMBERS], [Linkify.WEB_URLS]
 */
fun TextView.setMutableAutoLinkMask(mask: MutableLiveData<Int>?){
    setMutableAutoLinkMask(this, mask)
}

/**
 * Specifies the mutable min text size when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizeMinTextSize
 * @param size the mutable min scaling text size. If the value is null, then 1 will be set.
 */
fun TextView.setMutableAutoSizeMinTextSize(size: MutableLiveData<Int>?) {
    setMutableAutoSizeMinTextSize(this, size)
}

/**
 * Specifies the mutable max text size when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizeMaxTextSize
 * @param size the mutable max scaling text size. If the value is null, then 2000 will be set.
 */
fun TextView.setMutableAutoSizeMaxTextSize(size:MutableLiveData<Int>?){
    setMutableAutoSizeMaxTextSize(this, size)
}

/**
 * Specifies the mutable preset sizes (in pixels) when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizePresetSizes
 * @param sizes a mutable int array of sizes in pixels.
 */
fun TextView.setMutableAutoSizeTextTypeUniformWithPresetSizes(sizes: MutableLiveData<IntArray>?) {
    setMutableAutoSizePresetSizes(this, sizes)
}

/**
 * Specifies the auto-size step size (in pixels). Overwrites autoSizePresetSizes if set.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizeStepGranularity
 * @param granularity the mutable auto-step size.
 */
fun TextView.setMutableAutoSizeStepGranularity(granularity: MutableLiveData<Int>?) {
    setMutableAutoSizeStepGranularity(this, granularity)
}

/**
 * Specifies a mutable text scaling type, [TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE] or
 * [TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM]
 *
 * __Related XML attribute:__ app:mutableAutoSizeTextType
 * @param autoSizeTextType the mutable text type
 */
fun TextView.setMutableAutoSizeTextTypeWithDefaults(autoSizeTextType: MutableLiveData<Int>?) {
    setMutableAutoSizeTextType(this, autoSizeTextType)
}

/**
 * Specifies that this [TextView] has a textual input method and whether it automatically corrects
 * some common spelling errors.
 *
 * __Related XML attribute:__ app:mutableAutoText
 * @param autoText the mutable auto correct to apply on the [TextView]
 */
fun TextView.setMutableAutoText(autoText: MutableLiveData<Boolean>?) {
    setMutableAutoText(this, autoText)
}

/**
 * Sets the mutable break strategy for breaking paragraphs into lines.
 *
 * The value must be one of [Layout.BREAK_STRATEGY_SIMPLE], [Layout.BREAK_STRATEGY_HIGH_QUALITY] or
 * [Layout.BREAK_STRATEGY_BALANCED].
 *
 * __Related XML attribute:__ app:mutableBreakStrategy
 * @param breakStrategy the mutable break strategy to apply on the [TextView]
 */
@TargetApi(Build.VERSION_CODES.M)
fun TextView.setMutableBreakStrategy(breakStrategy: MutableLiveData<Int>?) {
    setMutableBreakStrategy(this, breakStrategy)
}

/**
 * Sets the minimum mutable type that getText() will return.
 *
 * __Related XML attribute:__ app:mutableBufferType
 * @param bufferType the mutable type to set to the [TextView]
 */
fun TextView.setMutableBufferType(bufferType: MutableLiveData<TextView.BufferType>?) {
    setMutableBufferType(this, bufferType)
}

/**
 * Specifies that this [TextView] has a textual input method and should automatically apply the
 * value of the specified mutable capitalize method when the user types.
 *
 * __Related XML attribute:__ app:mutableCapitalize
 * @param capitalize the mutable capitalize method to apply on the [TextView]
 */
fun TextView.setMutableCapitalize(capitalize: MutableLiveData<TextKeyListener.Capitalize>?) {
    setMutableCapitalize(this, capitalize)
}
