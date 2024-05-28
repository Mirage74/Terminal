package com.balex.terminal.presentation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.balex.terminal.di.ApplicationComponent
import com.balex.terminal.di.DaggerApplicationComponent

class TerminalApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    //Log.d("RECOMPOSITION_TAG", "getApplicationComponent")
    return (LocalContext.current.applicationContext as TerminalApplication).component
}