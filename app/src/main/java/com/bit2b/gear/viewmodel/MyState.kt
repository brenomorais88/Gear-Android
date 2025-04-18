package com.bit2b.gear.viewmodel


open class MyState {
    object Success : MyState()
    object Failure : MyState()
    object Error : MyState()
    object Loading : MyState()
}

