package io.github.orioncraftmc.flexkt.algorithm.trail.impl

import io.github.orioncraftmc.flexkt.algorithm.trail.FlexibleBoxTrailAuditor
import kotlin.time.DurationUnit
import kotlin.time.toDuration

object SimpleOutputtingFlexibleBoxAudior : FlexibleBoxTrailAuditor {
    private val passStartTimings = mutableMapOf<String, Long>()
    override fun passStart(name: String) {
        passStartTimings[name] = System.currentTimeMillis()
        println("Started pass [$name]")
    }

    override fun passEnd(name: String) {
        val timing = passStartTimings[name]?.let { System.currentTimeMillis() - it }?.toDuration(DurationUnit.MILLISECONDS)
        println("Finished pass [$name]${timing?.let { " in $it" } ?: ""}")
    }

    override fun <T> notifyPropertyChange(name: String, reason: String?, clazz: Class<T>, newValue: T) {
        println("Flexible Box property [$name: ${clazz.simpleName}] changed to [$newValue]${reason?.let { " because [$it]" } ?: ""}")
    }
}