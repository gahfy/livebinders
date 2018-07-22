package net.gahfy.livebinders.testutils

import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.TintAwareDrawable
import org.mockito.ArgumentMatchers.nullable
import org.mockito.Mockito.*

fun getMockDrawable():CustomDrawable{
    val drawable = mock(CustomDrawable::class.java)
    `when`(drawable.setTintList(nullable(ColorStateList::class.java))).thenCallRealMethod()
    `when`(drawable.setTintMode(nullable(PorterDuff.Mode::class.java))).thenCallRealMethod()
    return drawable
}

open class CustomDrawable: Drawable(), TintAwareDrawable{

    private var colorStateList: ColorStateList? = null
    private var tintMode: PorterDuff.Mode? = null

    override fun draw(canvas: Canvas?) {}

    override fun setAlpha(alpha: Int) {}

    override fun getOpacity(): Int = 100

    override fun setTintMode(tintMode: PorterDuff.Mode?) { this.tintMode = tintMode }
    fun getTintMode() = tintMode

    override fun setTintList(colorStateList: ColorStateList?) {
        this.colorStateList = colorStateList
    }
    fun getTintList() = colorStateList

    override fun setColorFilter(colorFilter: ColorFilter?) {}
}