package com.balex.terminal.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.balex.terminal.samples.TestSaver


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestSaver()
//            TerminalTheme {
//                val component = getApplicationComponent()
//                val viewModel: TerminalViewModel = viewModel(factory = component.getViewModelFactory())
//                val screenState = viewModel.state.collectAsState(TerminalScreenState.Initial)
//                when (val currentState = screenState.value) {
//                    is TerminalScreenState.Content -> {
//                        Terminal(bars = currentState.barList)
//                    }
//
//                    is TerminalScreenState.Loading -> {
//                        Log.d("MainActivity", "Loading")
//                    }
//
//                    is TerminalScreenState.Initial -> {
//
//                    }
//                }
//            }
        }
    }
}

