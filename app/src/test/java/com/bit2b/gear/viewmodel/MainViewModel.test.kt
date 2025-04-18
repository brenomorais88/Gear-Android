package com.bit2b.gear.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@ExtendWith(InstantTaskExecutorRule::class)
@ExperimentalCoroutinesApi
class MainViewModelTest {


    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: MainViewModel
    private var stateObserver = mockk<Observer<MyState>>(relaxed = true)

    @BeforeEach
    fun before() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        viewModel = MainViewModel()
    }

    @Test
    fun `should set state to Loading when executarMetodo is called`() = runBlocking(testDispatcher) {

        viewModel.state.observeForever(stateObserver)

        // When
        viewModel.interactor("AnyInteractor")

        // Then
        verify { stateObserver.onChanged(MyState.Loading) }
    }

    @Test
    fun `should set state to Success after first delay in executarMetodo`() = runTest(testDispatcher) {
        // Given
        val providerUseCase = mockk<ProviderUseCase>()
        viewModel = MainViewModel()
        stateObserver = mockk(relaxed = true)
        viewModel.state.observeForever(stateObserver)

        // When
        viewModel.interactor("AnyInteractor")
        testDispatcher.scheduler.advanceTimeBy(1000)

        // Then
        verify {
            stateObserver.onChanged(MyState.Loading)
            stateObserver.onChanged(MyState.Success)
        }
    }

    @AfterEach
    fun after(){
        Dispatchers.resetMain()
    }
}
