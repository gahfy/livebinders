package net.gahfy.livebinders.extension

import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ViewUnitTest {
    @Test
    fun view_parentActivity_oneOnly_null() {
        val context = mock(Context::class.java)
        val view = mock(View::class.java)
        `when`(view.context).thenReturn(context)

        assertNull("Parent activity must be null", view.parentActivity)
    }

    @Test
    fun view_parentActivity_moreThanOne_null() {
        val context = mock(ContextWrapper::class.java)
        val contextInside = mock(Context::class.java)
        `when`(context.baseContext).thenReturn(contextInside)
        val view = mock(View::class.java)
        `when`(view.context).thenReturn(context)


        assertNull("Parent activity must be null", view.parentActivity)
    }

    @Test
    fun view_parentActivity_oneOnly_notnull() {
        val parentActivity = mock(AppCompatActivity::class.java)
        val view = mock(View::class.java)
        `when`(view.context).thenReturn(parentActivity)

        assertSame("Parent activity must be the one set", view.parentActivity, parentActivity)
    }

    @Test
    fun view_parentActivity_moreThanOne_notnull() {
        val context = mock(ContextWrapper::class.java)
        val parentActivity = mock(AppCompatActivity::class.java)
        `when`(context.baseContext).thenReturn(parentActivity)
        val view = mock(View::class.java)
        `when`(view.context).thenReturn(context)


        assertSame("Parent activity must be the one set", view.parentActivity, parentActivity)
    }
}