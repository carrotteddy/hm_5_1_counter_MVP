package com.example.counter.main

import com.example.counter.model.CounterModel
import com.example.counter.view.CounterView

class Presenter {

    var model = CounterModel()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        view.updateActualCount(model.count)
    }

    fun attachView(view: CounterView){
        this.view = view
    }
}