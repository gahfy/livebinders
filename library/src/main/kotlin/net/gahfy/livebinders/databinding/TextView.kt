package net.gahfy.livebinders.databinding

import android.os.Build
import android.text.util.Linkify
import android.util.Log
import android.util.TypedValue
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
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
 * Specifies the mutable max text size when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizeMaxTextSize
 * @param textView the TextView on which to apply the mutable max scaling text size.
 * @param size the mutable max scaling text size. If the value is null, then 2000 will be set.
 * @throws IllegalArgumentException if the value of [size] is equal or lower than 0
 * @see TextView.setAutoSizeTextTypeUniformWithConfiguration
 */
@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("mutableAutoSizeMaxTextSize")
fun setMutableAutoSizeMaxTextSize(textView: TextView, size:MutableLiveData<Int>?){
    val parentActivity: AppCompatActivity? = textView.parentActivity
    if(parentActivity != null && size != null) {
        size.observe(parentActivity, Observer { value -> textView.setAutoSizeTextTypeUniformWithConfiguration(
                if (textView.autoSizeMinTextSize == -1) 1 else textView.autoSizeMinTextSize,
                value?:2000,
                if (textView.autoSizeStepGranularity == -1) 1 else textView.autoSizeStepGranularity,
                TypedValue.COMPLEX_UNIT_PX
        )})
    }
}

