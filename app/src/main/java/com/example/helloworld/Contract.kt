package com.example.helloworld

interface Contract {

    interface View {
        fun showSuccess()
        fun showFailure()
    }

    interface Presenter {
        fun compare(account: String, password: String)
    }

}