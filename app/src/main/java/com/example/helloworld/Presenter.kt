package com.example.helloworld

class Presenter(val view: Contract.View) :Contract.Presenter{

    override fun compare(account: String, password: String) {
        if (account == "1234" && password == "5678") {
            view.showSuccess()
        } else {
            view.showFailure()
        }
    }

}