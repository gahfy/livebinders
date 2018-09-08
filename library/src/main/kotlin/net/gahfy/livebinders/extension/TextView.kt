package net.gahfy.livebinders.extension

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.InputType
import android.text.Layout
import android.text.TextUtils
import android.text.method.DigitsKeyListener
import android.text.method.TextKeyListener
import android.text.util.Linkify
import android.util.TypedValue
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.XmlRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
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
 * Adds a live visibility for the cursor.
 *
 * __Related XML attribute:__ app:liveCursorVisible
 * @param cursorVisible the live visibility method to apply on the cursor of this [TextView]
 */
@BindingAdapter("liveCursorVisible")
fun TextView.addLiveCursorVisible(cursorVisible: LiveData<Boolean>?) {
    addLiveData(cursorVisible, Observer { value -> setNullableCursorVisible(value) })
}

/**
 * Adds a live characters that are accepted for this TextView with numeric method.
 *
 * __Related XML attribute:__ app:liveDigits
 * @param digits the live characters that are accepted for this TextView
 */
@BindingAdapter("liveDigits")
fun TextView.addLiveDigits(digits: LiveData<String>?){
    addLiveData(digits, Observer { value -> setDigits(value) })
}

/**
 * Adds a live resource id of the drawable to appear below the text.
 *
 * __Related XML attribute:__ app:liveDrawableBottom
 * @param drawableBottom the live resource id of the drawable to appear below the text
 */
@BindingAdapter("liveDrawableBottom")
fun TextView.addLiveDrawableResIdBottom(drawableBottom: LiveData<Int>?){
    addLiveData(drawableBottom, Observer { value -> setCompoundDrawableBottom(value) })
}

/**
 * Adds a live drawable to appear below the text.
 *
 * __Related XML attribute:__ app:liveDrawableBottom
 * @param drawableBottom the live drawable to appear below the text
 */
@BindingAdapter("liveDrawableBottom")
fun TextView.addLiveDrawableBottom(drawableBottom: LiveData<Drawable>?){
    addLiveData(drawableBottom, Observer { value -> setCompoundDrawableBottom(value) })
}

/**
 * Adds a live resource id of the drawable to appear to the end of the text.
 *
 * __Related XML attribute:__ app:liveDrawableEnd
 * @param drawableEnd the live resource id of the drawable to appear to the end of the text
 */
@BindingAdapter("liveDrawableEnd")
fun TextView.addLiveDrawableResIdEnd(drawableEnd: LiveData<Int>?){
    addLiveData(drawableEnd, Observer { value -> setCompoundDrawableEnd(value) })
}

/**
 * Adds a live drawable to appear to the end of the text.
 *
 * __Related XML attribute:__ app:liveDrawableEnd
 * @param drawableEnd the live drawable to appear to the end of the text
 */
@BindingAdapter("liveDrawableEnd")
fun TextView.addLiveDrawableEnd(drawableEnd: LiveData<Drawable>?){
    addLiveData(drawableEnd, Observer { value -> setCompoundDrawableEnd(value) })
}

/**
 * Adds a live resource id of the drawable to appear to the left of the text.
 *
 * __Related XML attribute:__ app:liveDrawableLeft
 * @param drawableLeft the live resource id of the drawable to appear to the left of the text
 */
@BindingAdapter("liveDrawableLeft")
fun TextView.addLiveDrawableResIdLeft(drawableLeft: LiveData<Int>?){
    addLiveData(drawableLeft, Observer { value -> setCompoundDrawableLeft(value) })
}

/**
 * Adds a live drawable to appear to the left of the text.
 *
 * __Related XML attribute:__ app:liveDrawableLeft
 * @param drawableLeft the live drawable to appear to the left of the text
 */
@BindingAdapter("liveDrawableLeft")
fun TextView.addLiveDrawableLeft(drawableLeft: LiveData<Drawable>?){
    addLiveData(drawableLeft, Observer { value -> setCompoundDrawableLeft(value) })
}

/**
 * Adds a live padding between the drawable and the text
 *
 * __Related XML attribute:__ app:liveDrawablePadding
 * @param drawablePadding the live padding between the drawable and the text
 */
@BindingAdapter("liveDrawablePadding")
fun TextView.addLiveDrawablePadding(drawablePadding: LiveData<Int>?){
    addLiveData(drawablePadding, Observer { value -> setNullableCompoundDrawablePadding(value) })
}

/**
 * Adds a live resource id of the drawable to appear to the right of the text.
 *
 * __Related XML attribute:__ app:liveDrawableRight
 * @param drawableRight the live resource id of the drawable to appear to the right of the text
 */
@BindingAdapter("liveDrawableRight")
fun TextView.addLiveDrawableResIdRight(drawableRight: LiveData<Int>?){
    addLiveData(drawableRight, Observer { value -> setCompoundDrawableRight(value) })
}

/**
 * Adds a live drawable to appear to the right of the text.
 *
 * __Related XML attribute:__ app:liveDrawableRight
 * @param drawableRight the live drawable to appear to the right of the text
 */
@BindingAdapter("liveDrawableRight")
fun TextView.addLiveDrawableRight(drawableRight: LiveData<Drawable>?){
    addLiveData(drawableRight, Observer { value -> setCompoundDrawableRight(value) })
}

/**
 * Adds a live resource id of the drawable to appear to the start of the text.
 *
 * __Related XML attribute:__ app:liveDrawableStart
 * @param drawableStart the live resource id of the drawable to appear to the start of the text
 */
@BindingAdapter("liveDrawableStart")
fun TextView.addLiveDrawableResIdStart(drawableStart: LiveData<Int>?){
    addLiveData(drawableStart, Observer { value -> setCompoundDrawableStart(value) })
}

/**
 * Adds a live drawable to appear to the start of the text.
 *
 * __Related XML attribute:__ app:liveDrawableStart
 * @param drawableStart the live drawable to appear to the start of the text
 */
@BindingAdapter("liveDrawableStart")
fun TextView.addLiveDrawableStart(drawableStart: LiveData<Drawable>?){
    addLiveData(drawableStart, Observer { value -> setCompoundDrawableStart(value) })
}

/**
 * Adds a live tint list to apply to the compound drawables of the TextView.
 *
 * __Related XML attribute:__ app:liveDrawableTint
 * @param tint the live tint list to apply to the compound drawables of the TextView
 */
@BindingAdapter("liveDrawableTint")
fun TextView.addLiveDrawableTint(tint: LiveData<ColorStateList>?){
    addLiveData(tint, Observer { value -> setAllVersionNullableCompoundDrawableTintList(value) })
}

/**
 * Adds a live tint list to apply to the compound drawables of the TextView.
 *
 * The expected value for the Live Data is the resource id of a Color resource.
 *
 * __Related XML attribute:__ app:liveDrawableTint
 * @param tint the live tint list to apply to the compound drawables of the TextView
 */
@BindingAdapter("liveDrawableTint")
fun TextView.addLiveDrawableTintResId(tint: LiveData<Int>?){
    addLiveData(tint, Observer { value -> setAllVersionCompoundDrawableTintList(value) })
}

/**
 * Specifies the live blending mode used to apply the tint specified by
 * TextView.setCompoundDrawableTintList() to the compound drawables.
 *
 * __Related XML attribute:__ app:liveDrawableTint
 * @param colorTintMode the live blending mode used to apply the tint, value may be null to clear tint
 */
@BindingAdapter("liveDrawableTintMode")
fun TextView.addLiveDrawableTintMode(colorTintMode: LiveData<PorterDuff.Mode>?){
    addLiveData(colorTintMode, Observer { value -> setAllVersionNullableCompoundDrawableTintMode(value) })
}

/**
 * Adds a live resource id of the drawable to appear above the text.
 *
 * __Related XML attribute:__ app:liveDrawableTop
 * @param drawableTop the live resource id of the drawable to appear above the text
 */
@BindingAdapter("liveDrawableTop")
fun TextView.addLiveDrawableResIdTop(drawableTop: LiveData<Int>?){
    addLiveData(drawableTop, Observer { value -> setCompoundDrawableTop(value) })
}

/**
 * Adds a live drawable to appear above the text.
 *
 * __Related XML attribute:__ app:liveDrawableTop
 * @param drawableTop the live drawable to appear above the text
 */
@BindingAdapter("liveDrawableTop")
fun TextView.addLiveDrawableTop(drawableTop: LiveData<Drawable>?){
    addLiveData(drawableTop, Observer { value -> setCompoundDrawableTop(value) })
}

/**
 * Adds a live editable status to the TextView.
 *
 * __Related XML attribute:__ app:liveEditable
 * @param editable the live editable status of the TextView
 */
@BindingAdapter("liveEditable")
fun TextView.addLiveEditable(editable: LiveData<Boolean>?) {
    addLiveData(editable, Observer { value -> setEditable(value) })
}

/**
 * Adds the live extra input data of the text, which is the TextBoxAttribute.extras Bundle that will
 * be filled in when creating an input connection. The given integer value is the resource
 * identifier of an XML resource holding an &lt;input-extras&gt; XML tree.
 *
 * __Related XML attribute:__ app:liveEditorExtras
 * @param xmlResId the live XML resource id holding an &lt;input-extras&gt; XML tree
 */
@BindingAdapter("liveEditorExtras")
fun TextView.addLiveInputExtras(xmlResId: LiveData<Int>?) {
    addLiveData(xmlResId, Observer { value -> setNullableInputExtras(value) })
}

/**
 * Adds a live truncate position if the text is longer than the TextView.
 *
 * __Related XML attribute__ app:liveEllipsize
 * @param where the live truncate position to add to the TextView
 */
@BindingAdapter("liveEllipsize")
fun TextView.addLiveEllipsize(where: LiveData<TextUtils.TruncateAt>?) {
    addLiveData(where, Observer { value -> ellipsize = value })
}

/**
 * Adds a live TextView's elegant height metrics flag.
 *
 * __Related XML attribute:__ app:liveElegantTextHeight
 * @param elegant the live elegant height metrics to add to the TextView
 */
@BindingAdapter("liveElegantTextHeight")
fun TextView.addLiveElegantTextHeight(elegant: LiveData<Boolean>?) {
    addLiveData(elegant, Observer { value -> setNullableElegantTextHeightBeforeLollipop(value) })
}

/**
 * Adds a live width of the TextView to be exactly ems value wide.
 *
 * __Related XML attribute:__ app:liveEms
 * @param ems the live width of the TextView in terms of ems
 */
@BindingAdapter("liveEms")
fun TextView.addLiveEms(ems: LiveData<Int>?) {
    addLiveData(ems, Observer { value -> setNullableEms(value) })
}

/**
 * Adds a live status of fallback line spacing of the TextView
 *
 * __Related XML attribute:__ app:liveFallbackLineSpacing
 * @param fallbackLineSpacing the live status of fallback line spacing of the TextView
 */
@BindingAdapter("liveFallbackLineSpacing")
fun TextView.addLiveFallbackLineSpacing(fallbackLineSpacing: LiveData<Boolean>?) {
    addLiveData(fallbackLineSpacing, Observer { value -> setNullableFallbackLineSpacingBelowP(value) })
}


/**
 * Adds a live padding between top of the view and baseline of the text.
 *
 * __Related XML attribute:__ app:liveFirstBaselineToTopHeight
 * @param firstBaselineToTopHeight the live top padding of the Text
 */
@BindingAdapter("liveFirstBaselineToTopHeight")
fun TextView.addLiveFirstBaselineToTopHeight(firstBaselineToTopHeight: LiveData<Int>?) {
    addLiveData(firstBaselineToTopHeight, Observer { value -> setNullableFirstBaselineToTopHeight(value) })
}

/**
 * Adds a live font family from the identifier of a XML resource describing the font.
 *
 * __Related XML attribute:__ app:liveFontFamily
 * @param fontFamily the live font family to add the TextView
 */
@BindingAdapter("liveFontFamily")
fun TextView.addLiveFontFamily(fontFamily: LiveData<Int>?) {
    addLiveData(fontFamily, Observer { value -> setNullableFontFamilyBelowO(value) })
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
 * Specifies that this TextView has a numeric input method and that these specific characters are
 * the ones that it will accept. If this is set, numeric is implied to be true.
 * @param digits the characters that the TextView will accept
 */
private fun TextView.setDigits(digits: String?){
    if(digits != null){
        this.keyListener = DigitsKeyListener.getInstance(digits)
        this.inputType = if(this.inputType != InputType.TYPE_NULL) this.inputType else EditorInfo.TYPE_CLASS_TEXT
    }
}

/**
 * Sets the drawable to appear below the text.
 * @param drawable the drawable to appear below the text
 */
private fun TextView.setCompoundDrawableBottom(drawable: Drawable?){
    setCompoundDrawablesWithIntrinsicBounds(
            compoundDrawables[0],
            compoundDrawables[1],
            compoundDrawables[2],
            drawable
    )
}

/**
 * Sets the drawable to appear below the text.
 * @param drawableResId the resource id of the drawable to appear below the text
 */
private fun TextView.setCompoundDrawableBottom(@DrawableRes drawableResId: Int?){
    val drawableBottom:Drawable? = ContextCompat.getDrawable(context, drawableResId?:0)
    setCompoundDrawableBottom(drawableBottom)
}

/**
 * Sets the drawable to appear to the end of the text.
 * @param drawable the drawable to appear to the end of the text
 */
private fun TextView.setCompoundDrawableEnd(drawable: Drawable?){
    val currentDrawables = TextViewCompat.getCompoundDrawablesRelative(this)

    TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(
            this,
            currentDrawables[0],
            currentDrawables[1],
            drawable,
            currentDrawables[3]
    )
}

/**
 * Sets the drawable to appear to the end of the text.
 * @param drawableResId the resource id of the drawable to appear to the end of the text
 */
private fun TextView.setCompoundDrawableEnd(@DrawableRes drawableResId: Int?){
    val drawableEnd:Drawable? = ContextCompat.getDrawable(context, drawableResId?:0)
    setCompoundDrawableEnd(drawableEnd)
}

/**
 * Sets the drawable to appear to the left of the text.
 * @param drawable the drawable to appear to the left of the text
 */
private fun TextView.setCompoundDrawableLeft(drawable: Drawable?){
    setCompoundDrawablesWithIntrinsicBounds(
            drawable,
            compoundDrawables[1],
            compoundDrawables[2],
            compoundDrawables[3]
    )
}

/**
 * Sets the drawable to appear to the left of the text.
 * @param drawableResId the resource id of the drawable to appear to the left of the text
 */
private fun TextView.setCompoundDrawableLeft(@DrawableRes drawableResId: Int?){
    val drawableLeft:Drawable? = ContextCompat.getDrawable(context, drawableResId?:0)
    setCompoundDrawableLeft(drawableLeft)
}

/**
 * Sets the size of the padding between the compound drawables and the text.
 * @param padding the size of the padding between the compound drawables and the text to set
 */
private fun TextView.setNullableCompoundDrawablePadding(padding: Int?){
    if(padding != null){
        this.compoundDrawablePadding = padding
    }
}

/**
 * Sets the drawable to appear to the right of the text.
 * @param drawable the drawable to appear to the right of the text
 */
private fun TextView.setCompoundDrawableRight(drawable: Drawable?){
    setCompoundDrawablesWithIntrinsicBounds(
            compoundDrawables[0],
            compoundDrawables[1],
            drawable,
            compoundDrawables[3]
    )
}

/**
 * Sets the drawable to appear to the right of the text.
 * @param drawableResId the resource id of the drawable to appear to the right of the text
 */
private fun TextView.setCompoundDrawableRight(@DrawableRes drawableResId: Int?){
    val drawableRight:Drawable? = ContextCompat.getDrawable(context, drawableResId?:0)
    setCompoundDrawableRight(drawableRight)
}

/**
 * Sets the drawable to appear to the start of the text.
 * @param drawable the drawable to appear to the start of the text
 */
private fun TextView.setCompoundDrawableStart(drawable: Drawable?){
    val currentDrawables = TextViewCompat.getCompoundDrawablesRelative(this)

    TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(
            this,
            drawable,
            currentDrawables[1],
            currentDrawables[2],
            currentDrawables[3]
    )
}

/**
 * Sets the drawable to appear to the start of the text.
 * @param drawableResId the resource id of the drawable to appear to the start of the text
 */
private fun TextView.setCompoundDrawableStart(@DrawableRes drawableResId: Int?){
    val drawableStart:Drawable? = ContextCompat.getDrawable(context, drawableResId?:0)
    setCompoundDrawableStart(drawableStart)
}

/**
 * Sets the tint list to apply to the compound drawables of the TextView.
 * @param colorStateList the tint list to apply to the compound drawables of the TextView
 */
private fun TextView.setAllVersionNullableCompoundDrawableTintList(colorStateList: ColorStateList?){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        this.compoundDrawableTintList = colorStateList
    }
    else{
        if(compoundDrawables[0] != null)
            DrawableCompat.setTintList(compoundDrawables[0], colorStateList)
        if(compoundDrawables[1] != null)
            DrawableCompat.setTintList(compoundDrawables[1], colorStateList)
        if(compoundDrawables[2] != null)
            DrawableCompat.setTintList(compoundDrawables[2], colorStateList)
        if(compoundDrawables[3] != null)
            DrawableCompat.setTintList(compoundDrawables[3], colorStateList)
    }
}

/**
 * Sets the tint list to apply to the compound drawables of the TextView.
 * @param colorStateListResId the res id of the color resource to apply as a tint to the compound drawables of the TextView
 */
private fun TextView.setAllVersionCompoundDrawableTintList(@ColorRes colorStateListResId: Int?){
    val colorStateList = ContextCompat.getColorStateList(context, colorStateListResId?:0)
    setAllVersionNullableCompoundDrawableTintList(colorStateList)
}

/**
 * Specifies the blending mode used to apply the tint specified by
 * TextView.setCompoundDrawableTintList() to the compound drawables.
 * @param colorTintMode the blending mode used to apply the tint, may be null to clear tint
 */
private fun TextView.setAllVersionNullableCompoundDrawableTintMode(colorTintMode: PorterDuff.Mode?){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        this.compoundDrawableTintMode = colorTintMode
    }
    else if(colorTintMode != null){
        if(compoundDrawables[0] != null)
            DrawableCompat.setTintMode(compoundDrawables[0], colorTintMode)
        if(compoundDrawables[1] != null)
            DrawableCompat.setTintMode(compoundDrawables[1], colorTintMode)
        if(compoundDrawables[2] != null)
            DrawableCompat.setTintMode(compoundDrawables[2], colorTintMode)
        if(compoundDrawables[3] != null)
            DrawableCompat.setTintMode(compoundDrawables[3], colorTintMode)
    }
    else{
        if(compoundDrawables[0] != null)
            DrawableCompat.setTintList(compoundDrawables[0], null)
        if(compoundDrawables[1] != null)
            DrawableCompat.setTintList(compoundDrawables[1], null)
        if(compoundDrawables[2] != null)
            DrawableCompat.setTintList(compoundDrawables[2], null)
        if(compoundDrawables[3] != null)
            DrawableCompat.setTintList(compoundDrawables[3], null)
    }
}

/**
 * Sets the drawable to appear above the text.
 * @param drawable the drawable to appear above the text
 */
private fun TextView.setCompoundDrawableTop(drawable: Drawable?){
    setCompoundDrawablesWithIntrinsicBounds(
            compoundDrawables[0],
            drawable,
            compoundDrawables[2],
            compoundDrawables[3]
    )
}

/**
 * Sets the drawable to appear above the text.
 * @param drawableResId the resource id of the drawable to appear above the text
 */
private fun TextView.setCompoundDrawableTop(@DrawableRes drawableResId: Int?){
    val drawableTop:Drawable? = ContextCompat.getDrawable(context, drawableResId?:0)
    setCompoundDrawableTop(drawableTop)
}

/**
 * Sets whether the TextView is editable or not.
 * @param editable whether the TextView is editable or not
 */
private fun TextView.setEditable(editable: Boolean?) {
    if (editable == true) {
        keyListener = TextKeyListener.getInstance()
        setRawInputType(EditorInfo.TYPE_CLASS_TEXT)
    } else if (editable == false) {
        keyListener = null
        setRawInputType(InputType.TYPE_NULL)
    }
}

/**
 * Set the extra input data of the text, which is the TextBoxAttribute.extras Bundle that will be
 * filled in when creating an input connection. The given integer is the resource identifier of an
 * XML resource holding an &lt;input-extras&gt; XML tree.
 * @param xmlResId the resource identifier of the XML resource holding the &lt;input-extras&gt; XML
 * tree
 */
private fun TextView.setNullableInputExtras(@XmlRes xmlResId: Int?) {
    setInputExtras(xmlResId ?: 0)
}

/**
 * Set the TextView's elegant height metrics flag. This setting selects font variants that have not
 * been compacted to fit Latin-based vertical metrics, and also increases top and bottom bounds to
 * provide more space. Does nothing for Version before Lollipop
 * @param elegant set the paint's elegant metrics flag
 */
private fun TextView.setNullableElegantTextHeightBeforeLollipop(elegant: Boolean?) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        isElegantTextHeight = (elegant == true)
    }
}

/**
 * Makes the TextView be exactly this many ems wide.
 * @param ems the exact width of the TextView in terms of ems
 */
private fun TextView.setNullableEms(ems: Int?) {
    if (ems != null) {
        setEms(ems)
    }
}

/**
 * Set whether to respect the ascent and descent of the fallback fonts that are used in displaying
 * the text (which is needed to avoid text from consecutive lines running into each other). If set,
 * fallback fonts that end up getting used can increase the ascent and descent of the lines that
 * they are used on.
 *
 * It is required to be true if text could be in languages like Burmese or Tibetan where text is
 * typically much taller or deeper than Latin text.
 * @param fallbackLineSpacing whether to expand linespacing based on fallback fonts, true by default
 */
private fun TextView.setNullableFallbackLineSpacingBelowP(fallbackLineSpacing: Boolean?) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        isFallbackLineSpacing = fallbackLineSpacing != false
    }
}

/**
 * Updates the top padding of the TextView so that firstBaselineToTopHeight is equal to the distance
 * between the firt text baseline and the top of this TextView. Note that if FontMetrics.top or
 * FontMetrics.ascent was already greater than firstBaselineToTopHeight, the top padding is not
 * updated.
 * @param firstBaselineToTopHeight distance between first baseline to top of the container in pixels
 */
private fun TextView.setNullableFirstBaselineToTopHeight(firstBaselineToTopHeight: Int?) {
    if (firstBaselineToTopHeight != null) {
        TextViewCompat.setFirstBaselineToTopHeight(this, firstBaselineToTopHeight)
    }
}

/**
 * Sets a font family from XML resources to a TextView.
 *
 *@param fontFamily the XML resource identifier of the font
 */
private fun TextView.setNullableFontFamilyBelowO(@FontRes fontFamily: Int?) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && fontFamily != null) {
        val typeface = context.resources.getFont(fontFamily)
        setTypeface(typeface)
    }
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