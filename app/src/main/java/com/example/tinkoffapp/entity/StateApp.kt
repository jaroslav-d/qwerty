package com.example.tinkoffapp.entity

interface StateApp {
    var photo: Photo

    class ERROR : StateApp{
        override var photo: Photo
            get() = Photo("https://c.tenor.com/hwe3vkln0_UAAAAM/error-x-error.gif")
            set(value) = Unit
    }
    class LOADING : StateApp{
        override var photo: Photo
            get() = Photo("https://c.tenor.com/FBeNVFjn-EkAAAAC/ben-redblock-loading.gif")
            set(value) = Unit
    }
    class LOADED : StateApp {
        override var photo: Photo = Photo("https://c.tenor.com/FBeNVFjn-EkAAAAC/ben-redblock-loading.gif")
    }
}