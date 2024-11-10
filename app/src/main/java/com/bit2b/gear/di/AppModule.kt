package com.bit2b.gear.di

import com.bit2b.gear.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Define o repositório como uma dependência de escopo único
    single { }
    // Define o ViewModel e injeta o repositório
    viewModel { MainViewModel() }
}
