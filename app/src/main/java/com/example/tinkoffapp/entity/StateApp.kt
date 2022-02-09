package com.example.tinkoffapp.entity

enum class StateApp {
    ERROR {
        override var photo: Photo
            get() = Photo("https://c.tenor.com/hwe3vkln0_UAAAAM/error-x-error.gif")
            set(value) = Unit
    },
    LOADING {
        override var photo: Photo
            get() = Photo("https://c.tenor.com/FBeNVFjn-EkAAAAC/ben-redblock-loading.gif")
            set(value) = Unit
    },
    LOADED {
        override var photo: Photo = Photo("https://c.tenor.com/FBeNVFjn-EkAAAAC/ben-redblock-loading.gif")
    };
    abstract var photo: Photo
}