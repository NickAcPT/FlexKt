package io.github.orioncraftmc.flexkt.algorithm.helpers

import io.github.orioncraftmc.flexkt.algorithm.trail.FlexibleBoxTrailAuditor
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KMutableProperty1

inline fun FlexibleBoxTrailAuditor.pass(name: String, code: () -> Unit) {
    passStart(name)
    code.invoke()
    passEnd(name)
}

inline fun <reified T> KMutableProperty0<T>.notifyPropertyChange(auditor: FlexibleBoxTrailAuditor, name: String, reason: String? = null) {
    val newValue = this.get()
    val clazz = T::class.java

    auditor.notifyPropertyChange(name, reason, clazz, newValue)
}

inline fun <reified T, reified V> KMutableProperty1<T, V>.notifyPropertyChange(name: String, reason: String? = null, receiver: T, auditor: FlexibleBoxTrailAuditor) {
    val newValue = this.get(receiver)
    val clazz = V::class.java

    auditor.notifyPropertyChange(name, reason, clazz, newValue)
}