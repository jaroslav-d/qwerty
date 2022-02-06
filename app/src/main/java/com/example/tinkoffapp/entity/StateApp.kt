package com.example.tinkoffapp.entity

enum class StateApp {
    ERROR {
        override var urlImg: String
            get() = "https://c.tenor.com/hwe3vkln0_UAAAAM/error-x-error.gif"
            set(value) = Unit
    },
    LOADING {
        override var urlImg: String
            get() = "https://c.tenor.com/FBeNVFjn-EkAAAAC/ben-redblock-loading.gif"
            set(value) = Unit
    },
    LOADED {
        override var urlImg: String = "http://static.devli.ru/public/images/gifs/201402/df9c732c-c89f-4510-8424-44087f86be1d.gif"
    };
    abstract var urlImg: String
}