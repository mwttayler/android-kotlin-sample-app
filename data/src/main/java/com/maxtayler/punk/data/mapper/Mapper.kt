package com.maxtayler.punk.data.mapper

internal abstract class Mapper<in From, out To> {

    abstract fun mapFrom(from: From): To
}
