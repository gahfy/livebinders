package net.gahfy.livebinders.databinding

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Call [View.setOnClickListener]
 *
 * __Related XML attribute:__ app:clickListener
 * @param view the view instance for which to call [View.setOnClickListener]
 * @param l the argument to pass to [View.setOnClickListener]
 * @see View.setOnClickListener
 */
@BindingAdapter("clickListener")
internal fun setClickListener(view: View, l: View.OnClickListener) {
    view.setOnClickListener(l)
}