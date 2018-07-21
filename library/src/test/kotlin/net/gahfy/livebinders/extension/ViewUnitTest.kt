package net.gahfy.livebinders.extension

import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import net.gahfy.livebinders.testutils.mockView
import net.gahfy.livebinders.testutils.resetView
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ViewUnitTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        resetView()
    }

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

    @Test
    fun view_addLiveData() {
        var view = mockView
        var counter = 0
        var liveClickListener: MutableLiveData<View.OnClickListener>? = MutableLiveData()
        view.addLiveData(liveClickListener, Observer { value -> view.setOnClickListener(value) })
        liveClickListener?.value = View.OnClickListener {
            counter++
        }
        view.callOnClick()
        assertEquals("Click listener should be registered", 1, counter)

        resetView()
        view = mockView
        counter = 0
        liveClickListener = null
        view.addLiveData(liveClickListener, Observer { value -> view.setOnClickListener(value as View.OnClickListener?) })
        liveClickListener?.value = View.OnClickListener {
            counter++
        }
        view.callOnClick()
        assertEquals("Click listener should not be registered (null live data)", 0, counter)

        view = mock(View::class.java)
        `when`(view.context).thenReturn(null)
        counter = 0
        liveClickListener = MutableLiveData()
        view.addLiveData(liveClickListener, Observer { value -> view.setOnClickListener(value) })
        liveClickListener.value = View.OnClickListener { counter++ }
        view.callOnClick()
        assertEquals("Click listener should not be registered (null parent activity)", 0, counter)

        view = mock(View::class.java)
        `when`(view.context).thenReturn(null)
        counter = 0
        liveClickListener = null
        view.addLiveData(liveClickListener, Observer { value -> view.setOnClickListener(value as View.OnClickListener?) })
        liveClickListener?.value = View.OnClickListener { counter++ }
        view.callOnClick()
        assertEquals("Click listener should not be registered (null parent activity and live data)", 0, counter)

    }
}