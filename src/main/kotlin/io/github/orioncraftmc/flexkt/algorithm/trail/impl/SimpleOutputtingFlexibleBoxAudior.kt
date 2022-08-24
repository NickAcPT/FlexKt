package io.github.orioncraftmc.flexkt.algorithm.trail.impl

import io.github.orioncraftmc.flexkt.algorithm.trail.FlexibleBoxTrailAuditor
import kotlin.time.DurationUnit
import kotlin.time.toDuration

object SimpleOutputtingFlexibleBoxAudior : FlexibleBoxTrailAuditor {
    private fun Int.ordinalOf() = "$this" + if (this % 100 in 11..13) "th" else when (this % 10) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }

    private var stepCount = 0

    private var passCount = 0
    set(value) {
        field = value
        stepCount = 0
    }

    private val passStartTimings = mutableMapOf<String, Long>()
    private val stepStartTimings = mutableMapOf<String, Long>()
    override fun stepStart(name: String) {
        stepCount++
        stepStartTimings[name] = System.currentTimeMillis()
        println("Started ${stepCount.ordinalOf()} step [$name]")
    }

    override fun stepEnd(name: String) {
        val timing = stepStartTimings[name]?.let { System.currentTimeMillis() - it }?.toDuration(DurationUnit.MILLISECONDS)
        println("Finished step [$name]${timing?.let { " in $it" } ?: ""}")
    }

    override fun passStart(name: String) {
        passStartTimings[name] = System.currentTimeMillis()
        println("Started pass [$name]")
    }

    override fun passEnd(name: String) {
        val timing = passStartTimings[name]?.let { System.currentTimeMillis() - it }?.toDuration(DurationUnit.MILLISECONDS)
        println("Finished pass [$name]${timing?.let { " in $it" } ?: ""}")
    }

    override fun <T> notifyPropertyChange(name: String, reason: String?, clazz: Class<T>, newValue: T) {
        println(" - Flexible Box property [$name: ${clazz.simpleName}] changed to [$newValue]${reason?.let { " because [$it]" } ?: ""}")
    }
}