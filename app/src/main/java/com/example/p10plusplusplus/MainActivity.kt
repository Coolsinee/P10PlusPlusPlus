package com.example.p10plusplusplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p10plusplusplus.UDFprinciple.Screen3UDF

class MyViewModel2: ViewModel() {
    var i = mutableStateOf(0)
    private set

    fun increment() {
        i.value++
    }
}

object UDFprinciple {
    @Composable
    fun Screen3UDF(
        myViewModel: MyViewModel2 = viewModel()
    ) {
        val i by myViewModel.i
        increment(i, myViewModel::increment)
    }
    @Composable
    fun increment(
        i: Int,
        increment: () -> Unit
    ) {
        Text(
            text = "Клики: $i",
            modifier = Modifier.clickable(onClick = increment)
        )
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen3UDF()
        }
    }
}
