package io.github.orioncraftmc.flexkt.algorithm.trail

interface FlexibleBoxTrailAuditor {
    fun passStart(name: String)

    fun passEnd(name: String)

    fun <T> notifyPropertyChange(name: String, reason: String?, clazz: Class<T>, newValue: T)
}

