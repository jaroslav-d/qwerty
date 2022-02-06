package com.example.tinkoffapp.entity

enum class StateApp {
    ERROR {
        override var imgPath: String
            get() = "Error"
            set(value) = Unit
    },
    LOADING {
        override var imgPath: String
            get() = "Loading"
            set(value) = Unit
    },
    LOADED {
        override var imgPath: String = "Path"
    };
    abstract var imgPath: String
}