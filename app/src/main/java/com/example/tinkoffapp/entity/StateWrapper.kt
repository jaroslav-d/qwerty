package com.example.tinkoffapp.entity

class StateWrapper(var state: StateApp) {

    var photo: Photo by state::photo
    var current: StateApp by ::state

    private val prevStates = mutableSetOf<StateApp>()
    private val nextStates = mutableSetOf<StateApp>()

    fun toNext(): StateApp {
        state = if (nextStates.isEmpty()) {
            StateApp.LOADING
        } else {
            val currentState = nextStates.last()
            nextStates.remove(currentState)
            prevStates.add(state)
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