package net.gahfy.livebinders.databinding

import android.view.View
import net.gahfy.livebinders.testutils.mockView
import net.gahfy.livebinders.testutils.resetView
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ViewUnitTest {
    private var counterClick = 0

    @Before
    fun setUp(){
        resetView()
        counterClick = 0
    }

    @Test
    fun view_setclicklistener() {
        val view = mockView

        setClickListener(view, View.OnClickListener { counterClick++ })
        view.callOnClick()

        Assert.assertEquals("Counter must be incremented", 1, counterClick)
    }
}