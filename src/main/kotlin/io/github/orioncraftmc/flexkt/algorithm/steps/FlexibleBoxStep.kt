package io.github.orioncraftmc.flexkt.algorithm.steps

import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext

/**
 * Represents a Flexible Box layout step
 */
interface FlexibleBoxStep {
    val name: String

    fun layout(context: FlexibleBoxLayoutContext)
}

