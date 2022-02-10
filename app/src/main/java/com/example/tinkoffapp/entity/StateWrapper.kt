package com.example.tinkoffapp.entity

class StateWrapper(var state: StateApp) {

    var current: StateApp by ::state

    private val prevStates = mutableListOf<StateApp>()
    private val nextStates = mutableListOf<StateApp>()

    fun toNext(): StateApp {
        if (state == StateApp.LOADING) return state
        if (state == StateApp.ERROR) return state
        prevStates.add(state)
        state = if (nextStates.isEmpty()) {
            StateApp.LOADING
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