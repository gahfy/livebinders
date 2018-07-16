package net.gahfy.livebinders.extension

import android.os.Build
import android.text.util.Linkify
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import net.gahfy.livebinders.databinding.setMutableAutoLinkMask
import net.gahfy.livebinders.databinding.setMutableAutoSizeMaxTextSize

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
 * Specifies the mutable max text size when sizing the text automatically using
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM] scaling.
 *
 * By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * __Related XML attribute:__ app:mutableAutoSizeMaxTextSize
 * @param size the mutable max scaling text size. If the value is null, then 2000 will be set.
 * @throws IllegalArgumentException if the value of [size] is equal or lower than 0
 * @see TextView.setAutoSizeTextTypeUniformWithConfiguration
 */
@RequiresApi(Build.VERSION_CODES.O)
fun TextView.setMutableAutoSizeMaxTextSize(size:MutableLiveData<Int>?){
    setMutableAutoSizeMaxTextSize(this, size)
}