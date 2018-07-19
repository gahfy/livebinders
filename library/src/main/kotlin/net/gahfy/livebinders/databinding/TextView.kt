package net.gahfy.livebinders.databinding

import android.annotation.TargetApi
import android.os.Build
import android.text.InputType
import android.text.Layout
import android.text.method.TextKeyListener
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
 * @param textView the [TextView] on which to apply the mutable autolink mask
 * @param mask the mutable autolink mask to apply to the [TextView]. The value must be one of null,
 * [Linkify.ALL], [Linkify.EMAIL_ADDRESSES], [Linkify.EMAIL_ADDRESSES], [Linkify.PHONE_NUMBERS],
 * [Linkify.WEB_URLS]
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
 * @param textView the [TextView] on which to apply the mutable min scaling text size.
 * @param size the mutable min scaling text size to apply to the [TextView]. If the value is null,
 * then 1 will be set.
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
 * @param textView the [TextView] on which to apply the mutable max scaling text size.
 * @param size the mutable max scaling text size to apply to the [TextView]. If the value is null,
 * then 2000 will be set.
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
 * @param textView the [TextView] on which to apply the mutable preset sizes.
 * @param sizes a mutable int array of sizes in pixels to apply to the [TextView]
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
 * @param textView the [TextView] on which to apply the mutable preset sizes.
 * @param granularity the mutable auto-step size to apply to the [TextView]
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
 * @param textView the [TextView] on which to apply the mutable preset sizes.
 * @param textType the mutable text type to apply to the [TextView]
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
 * Specifies that the specified [TextView] has a textual input method and whether it automatically
 * corrects some common spelling errors.
 *
 * __Related XML attribute:__ app:mutableAutoText
 * @param textView the [TextView] on which to apply the mutable auo correct method.
 * @param autoText the mutable auto correct to apply on the [TextView]
 */
@BindingAdapter("mutableAutoText")
fun setMutableAutoText(textView: TextView, autoText: MutableLiveData<Boolean>?) {
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if (parentActivity != null && autoText != null) {
        autoText.observe(parentActivity, Observer { value ->
            setAutoCorrect(textView, value)
        })
    }
}

/**
 * Sets the mutable break strategy for breaking paragraphs into lines.
 *
 * The value must be one of [Layout.BREAK_STRATEGY_SIMPLE], [Layout.BREAK_STRATEGY_HIGH_QUALITY] or
 * [Layout.BREAK_STRATEGY_BALANCED].
 *
 * __Related XML attribute:__ app:mutableBreakStrategy
 * @param textView the [TextView] on which to apply the mutable break strategy.
 * @param breakStrategy the mutable break strategy to apply on the [TextView]
 */
@BindingAdapter("mutableBreakStrategy")
@TargetApi(Build.VERSION_CODES.M)
fun setMutableBreakStrategy(textView: TextView, breakStrategy: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if (parentActivity != null && breakStrategy != null) {
        breakStrategy.observe(parentActivity, Observer { value ->
            if (value != null) {
                textView.breakStrategy = value
            }
        })
    }
}

/**
 * Sets the minimum mutable type that getText() will return.
 *
 * __Related XML attribute:__ app:mutableBufferType
 * @param textView the [TextView] on which to apply the mutable auo correct method.
 * @param bufferType the mutable type to set to the [TextView]
 */
@BindingAdapter("mutableBufferType")
fun setMutableBufferType(textView: TextView, bufferType: MutableLiveData<TextView.BufferType>?) {
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if (parentActivity != null && bufferType != null) {
        bufferType.observe(parentActivity, Observer { value ->
            if (value != null) {
                textView.setText(textView.text, value)
            }
        })
    }
}

/**
 * Specifies that the specified [TextView] has a textual input method and should automatically apply
 * the value of the specified mutable capitalize method when the user types.
 *
 * __Related XML attribute:__ app:mutableCapitalize
 * @param textView the [TextView] on which to apply the mutable capitalize method.
 * @param capitalize the mutable capitalize method to apply on the [TextView]
 */
@BindingAdapter("mutableCapitalize")
fun setMutableCapitalize(textView: TextView, capitalize: MutableLiveData<TextKeyListener.Capitalize>?) {
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if (parentActivity != null && capitalize != null) {
        capitalize.observe(parentActivity, Observer { value ->
            setCapitalize(textView, value)
        })
    }
}

private fun setAutoCorrect(textView: TextView, autoCorrect: Boolean?) {
    if (autoCorrect == true) {
        textView.inputType = textView.inputType.or(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT)
    } else {
        textView.inputType = textView.inputType.and(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT.inv())
    }
}

private fun setCapitalize(textView: TextView, capitalize: TextKeyListener.Capitalize?) {
    // Safe because when avoids 100% coverage
    @Suppress("CascadeIf")
    textView.inputType = textView.inputType.and(
            InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS.inv()
                    .and(InputType.TYPE_TEXT_FLAG_CAP_WORDS.inv())
                    .and(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES.inv())
    ).or(
            if (capitalize == TextKeyListener.Capitalize.SENTENCES) InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            else if (capitalize == TextKeyListener.Capitalize.WORDS) InputType.TYPE_TEXT_FLAG_CAP_WORDS
            else if (capitalize == TextKeyListener.Capitalize.CHARACTERS) InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
            else if (capitalize == TextKeyListener.Capitalize.NONE) 0
            else 0
    )
}

private fun getSettableAutoSizeMinTextSize(size: Int?): Int = if (size == null || size <= 1) 1 else size

private fun getSettableAutoSizeMaxTextSize(size: Int?): Int = if (size == null || size < 1) 2000 else size

private fun getSettableAutoSizeGranularity(granularity: Int?): Int = if (granularity == null || granularity <= 1) 1 else granularity

private fun getSettableAutoSizeTextType(textType: Int?): Int = if (textType == TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM) TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM else TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE



