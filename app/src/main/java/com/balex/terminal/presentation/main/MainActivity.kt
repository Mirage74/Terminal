package com.balex.terminal.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.balex.terminal.presentation.getApplicationComponent
import com.balex.terminal.ui.theme.TerminalTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerminalTheme {
                val component = getApplicationComponent()
                val viewModel: TerminalViewModel =
                    viewModel(factory = component.getViewModelFactory())
                val screenState = viewModel.state.collectAsState(TerminalScreenState.Initial)
                when (val currentState = screenState.value) {
                    is TerminalScreenState.Content -> {
                        Terminal(bars = currentState.barList)
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .background(Color.White),
//                            contentAlignment = Alignment.Center
//                        ) {
//
//                                Terminal(
//                                    modifier = Modifier
//                                        .size(350.dp),
//                                    bars = currentState.barList
//                                )
//
//                        }
                    }

                    is TerminalScreenState.Loading -> {
                        Log.d("MainActivity", "Loading")
                    }

                    is TerminalScreenState.Initial -> {

                    }
                }
            }
        }
    }
}

