package io.github.orioncraftmc.flexkt.algorithm.trail

interface FlexibleBoxTrailAuditor {
    fun stepStart(name: String)

    fun stepEnd(name: String)

    fun passStart(name: String)

    fun passEnd(name: String)

    fun <T> notifyPropertyChange(name: String, reason: String?, clazz: Class<T>, newValue: T)
}

