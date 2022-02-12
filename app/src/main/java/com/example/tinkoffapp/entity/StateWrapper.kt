package com.example.tinkoffapp.entity

class StateWrapper(private var state: StateApp = StateApp.LOADING()) {

    var current: StateApp by ::state

    private val prevStates = mutableListOf<StateApp>()
    private val nextStates = mutableListOf<StateApp>()

    fun toNext(): StateApp {
        if (state is StateApp.LOADING) return state
        if (state is StateApp.ERROR) return state
        prevStates.add(state)
        state = if (nextStates.isEmpty()) {
            StateApp.LOADING()
        } else {
            val currentState = nextStates.last()
            nextStates.remove(currentState)
            currentState
        }
        return state
    }

    fun toPrev(): StateApp {
        state = if (prevStates.isEmpty()) {
            state
        } else {
            val currentState = prevStates.last()
            prevStates.remove(currentState)
            nextStates.add(state)
            currentState
        }
        return state
    }
}