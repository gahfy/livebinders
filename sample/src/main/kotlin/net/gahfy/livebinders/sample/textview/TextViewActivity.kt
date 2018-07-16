package net.gahfy.livebinders.sample.textview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import net.gahfy.livebinders.sample.R
import net.gahfy.livebinders.sample.databinding.ActivityTextViewBinding
import net.gahfy.livebinders.sample.injection.ViewModelFactory

class TextViewActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityTextViewBinding>(this, R.layout.activity_text_view)

        val viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(TextViewViewModel::class.java)
        binding.viewModel = viewModel
    }
}