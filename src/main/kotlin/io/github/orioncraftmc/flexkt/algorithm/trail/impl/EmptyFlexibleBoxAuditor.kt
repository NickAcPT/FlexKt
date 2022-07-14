package io.github.orioncraftmc.flexkt.algorithm.trail.impl

import io.github.orioncraftmc.flexkt.algorithm.trail.FlexibleBoxTrailAuditor

object EmptyFlexibleBoxAuditor : FlexibleBoxTrailAuditor {
    override fun passStart(name: String) {
    }

    override fun passEnd(name: String) {
    }

    override fun <T> notifyPropertyChange(name: String, reason: String?, clazz: Class<T>, newValue: T) {
    }
}