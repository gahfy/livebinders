package net.gahfy.livebinders.extension

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
 * @see TextView.setAutoLinkMask
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
 * @throws IllegalArgumentException if the value of size is equal or lower than 0
 * @see TextView.setAutoSizeTextTypeUniformWithConfiguration
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
 * @throws IllegalArgumentException if the value of size is equal or lower than 0
 * @see TextView.setAutoSizeTextTypeUniformWithConfiguration
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
 * @see TextView.setAutoSizeTextTypeUniformWithPresetSizes
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
 * @see TextView.setAutoSizeTextTypeUniformWithConfiguration
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
