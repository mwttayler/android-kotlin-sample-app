package com.maxtayler.core.base

interface BaseComponent<T> {

    fun inject(target: T)
}
