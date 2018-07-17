package net.gahfy.livebinders.databinding

import android.text.util.Linkify
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.TextViewCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import net.gahfy.livebinders.extension.parentActivity

/**
 * Sets the mutable autolink mask of the text. See [Linkify.ALL] and peers for possible
 * values.
 *
 * Avoid using [Linkify.MAP_ADDRESSES] as value as this value is deprecated.
 *
 * __Related XML attribute:__ app:mutableAutoLink
 * @param textView the TextView on which to apply the mutable autolink mask
 * @param mask the mutable autolink mask. The value must be one of null, [Linkify.ALL],
 * [Linkify.EMAIL_ADDRESSES], [Linkify.EMAIL_ADDRESSES], [Linkify.PHONE_NUMBERS], [Linkify.WEB_URLS]
 * @see TextView.setAutoLinkMask
 */
@BindingAdapter("mutableAutoLink")
fun setMutableAutoLinkMask(textView: TextView, mask: MutableLiveData<Int>?){
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if(parentActivity != null && mask != null) {
        mask.observe(parentActivity, Observer {
            value ->
                textView.autoLinkMask = value?:0
                // We have to set the text again to apply autolink
                textView.text = textView.text.toString()
        })
    }
}

/**
 * Specifies the mutable min text size (in pixels) when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizeMinTextSize
 * @param textView the TextView on which to apply the mutable min scaling text size.
 * @param size the mutable min scaling text size. If the value is null, then 1 will be set.
 * @throws IllegalArgumentException if the value of size is equal or lower than 0
 * @see TextView.setAutoSizeTextTypeUniformWithConfiguration
 */
@BindingAdapter("mutableAutoSizeMinTextSize")
fun setMutableAutoSizeMinTextSize(textView: TextView, size: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if (parentActivity != null && size != null) {
        size.observe(parentActivity, Observer { value ->
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                    textView,
                    getSettableAutoSizeMinTextSize(value),
                    getSettableAutoSizeMaxTextSize(TextViewCompat.getAutoSizeMaxTextSize(textView)),
                    getSettableAutoSizeGranularity(TextViewCompat.getAutoSizeStepGranularity(textView)),
                    TypedValue.COMPLEX_UNIT_PX
            )
        })
    }
}

/**
 * Specifies the mutable max text size (in pixels) when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizeMaxTextSize
 * @param textView the TextView on which to apply the mutable max scaling text size.
 * @param size the mutable max scaling text size. If the value is null, then 2000 will be set.
 * @throws IllegalArgumentException if the value of size is equal or lower than 0
 * @see TextView.setAutoSizeTextTypeUniformWithConfiguration
 */
@BindingAdapter("mutableAutoSizeMaxTextSize")
fun setMutableAutoSizeMaxTextSize(textView: TextView, size:MutableLiveData<Int>?){
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if(parentActivity != null && size != null) {
        size.observe(parentActivity, Observer { value ->
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                    textView,
                    getSettableAutoSizeMinTextSize(TextViewCompat.getAutoSizeMinTextSize(textView)),
                    getSettableAutoSizeMaxTextSize(value),
                    getSettableAutoSizeGranularity(TextViewCompat.getAutoSizeStepGranularity(textView)),
                TypedValue.COMPLEX_UNIT_PX
        )})
    }
}

/**
 * Specifies the mutable preset sizes (in pixels) when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizePresetSizes
 * @param textView the TextView on which to apply the mutable preset sizes.
 * @param sizes a mutable int array of sizes in pixels.
 * @see TextView.setAutoSizeTextTypeUniformWithPresetSizes
 */
@BindingAdapter("mutableAutoSizePresetSizes")
fun setMutableAutoSizePresetSizes(textView: TextView, sizes: MutableLiveData<IntArray>?) {
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if (parentActivity != null && sizes != null) {
        sizes.observe(parentActivity, Observer { value ->
            if (value != null) {
                TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(
                        textView,
                        value,
                        TypedValue.COMPLEX_UNIT_PX
                )
            }
        })
    }
}

/**
 * Specifies the auto-size step size (in pixels). Overwrites autoSizePresetSizes if set.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizeStepGranularity
 * @param textView the TextView on which to apply the mutable preset sizes.
 * @param granularity the mutable auto-step size.
 * @see TextView.setAutoSizeTextTypeUniformWithConfiguration
 */
@BindingAdapter("mutableAutoSizeStepGranularity")
fun setMutableAutoSizeStepGranularity(textView: TextView, granularity: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if (parentActivity != null && granularity != null) {
        granularity.observe(parentActivity, Observer { value ->
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                    textView,
                    getSettableAutoSizeMinTextSize(TextViewCompat.getAutoSizeMinTextSize(textView)),
                    getSettableAutoSizeMaxTextSize(TextViewCompat.getAutoSizeMaxTextSize(textView)),
                    getSettableAutoSizeGranularity(value),
                    TypedValue.COMPLEX_UNIT_PX
            )
        })
    }
}

/**
 * Specifies a mutable text scaling type, [TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE] or
 * [TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM]
 *
 * __Related XML attribute:__ app:mutableAutoSizeTextType
 * @param textView the TextView on which to apply the mutable preset sizes.
 * @param textType the mutable text type
 */
@BindingAdapter("mutableAutoSizeTextType")
fun setMutableAutoSizeTextType(textView: TextView, textType: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if (parentActivity != null && textType != null) {
        textType.observe(parentActivity, Observer { value ->
            TextViewCompat.setAutoSizeTextTypeWithDefaults(
                    textView,
                    getSettableAutoSizeTextType(value)
            )
        })
    }
}

/**
 * Returns a settable auto size min text size value from a value which may be not correct.
 *
 * Will return 1 if value is not correct
 * @param size the value to set, whatever it is
 * @return a settable auto size min text size value from a value which may be not correct
 */
private fun getSettableAutoSizeMinTextSize(size: Int?): Int = if (size == null || size <= 1) 1 else size

/**
 * Returns a settable auto size max text size value from a value which may be not correct.
 *
 * Will return 2000 if value is not correct
 * @param size the value to set, whatever it is
 * @return a settable auto size max text size value from a value which may be not correct
 */
private fun getSettableAutoSizeMaxTextSize(size: Int?): Int = if (size == null || size < 1) 2000 else size

/**
 * Returns a settable granularity value from a value which may be not correct.
 *
 * Will return 1 if value is not correct
 * @param granularity the value to set, whatever it is
 * @return a settable granularity value from a value which may be not correct
 */
private fun getSettableAutoSizeGranularity(granularity: Int?): Int = if (granularity == null || granularity <= 1) 1 else granularity

/**
 * Returns a settable auto size text type value from a value which may be not correct.
 *
 * Will return 1 if value is not correct
 * @param textType the value to set, whatever it is
 * @return a settable auto size text type value from a value which may be not correct
 */
private fun getSettableAutoSizeTextType(textType: Int?): Int = if (textType == TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM) TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM else TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE



