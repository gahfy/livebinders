package net.gahfy.livebinders.sample.textview

import android.os.Build
import android.text.util.Linkify
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewViewModel(
        private val spToPxMultiplier:Float
):ViewModel(){
    val autolinkValue = MutableLiveData<Int>()
    val autolinkNoneClickListener = View.OnClickListener { autolinkValue.value = null }
    val autolinkEmailClickListener = View.OnClickListener { autolinkValue.value = Linkify.EMAIL_ADDRESSES }
    val autolinkPhoneClickListener = View.OnClickListener { autolinkValue.value = Linkify.PHONE_NUMBERS }
    val autolinkUrlClickListener = View.OnClickListener { autolinkValue.value = Linkify.WEB_URLS }
    val autolinkAllClickListener = View.OnClickListener { autolinkValue.value = Linkify.ALL }

    val autosizeVisibility = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) View.VISIBLE else View.GONE

    val autoSizeMaxValue = MutableLiveData<Int>()
    val autoSizeMax200ClickListener = View.OnClickListener { autoSizeMaxValue.value = (200F*spToPxMultiplier).toInt() }
    val autoSizeMax10ClickListener = View.OnClickListener { autoSizeMaxValue.value = (10F*spToPxMultiplier).toInt() }

    init{
        autolinkValue.value = null
        autoSizeMaxValue.value = (200F*spToPxMultiplier).toInt()
    }
}