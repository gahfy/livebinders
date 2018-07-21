package net.gahfy.livebinders.testutils

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.`when`

private var editTextBreakStrategy = -1

fun resetEditText() {
    editTextBreakStrategy = -1
}

val mockEditText: EditText
    get() {
        val parentActivity = Mockito.mock(AppCompatActivity::class.java)
        val editText = Mockito.mock(EditText::class.java)

        `when`(editText.context).thenReturn(parentActivity)

        // Break Strategy
        `when`(editText.setBreakStrategy(ArgumentMatchers.anyInt())).thenAnswer { invocation ->
            editTextBreakStrategy = invocation.arguments[0] as Int
            null
        }
        `when`(editText.breakStrategy).thenAnswer {
            editTextBreakStrategy
        }

        val lifecycle = LifecycleRegistry(parentActivity)
        `when`(parentActivity.lifecycle).thenReturn(lifecycle)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        return editText
    }