package com.maxtayler.punk.base

interface BaseComponent<T> {

    fun inject(target: T)
}
