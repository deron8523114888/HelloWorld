package com.example.helloworld

interface Contract {

    interface View {
        fun showSuccess()
        fun showFailure()
        fun goToMain2()
    }

    interface Presenter {
        fun compare(account: String, password: String)
    }

}