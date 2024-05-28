package com.balex.terminal.di

import androidx.lifecycle.ViewModel
import com.balex.terminal.presentation.main.TerminalViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(TerminalViewModel::class)
    @Binds
    fun bindNewsFeedViewModel(viewModel: TerminalViewModel): ViewModel

}