package io.github.orioncraftmc.flexkt.algorithm.steps.impl

import io.github.orioncraftmc.flexkt.algorithm.helpers.axisProperty
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.FlexibleBoxStep
import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.math.shapes.CssDimensionSize

object LineLengthDeterminationStep : FlexibleBoxStep {
    override fun layout(context: FlexibleBoxLayoutContext) {
        val availableSpace = CssDimensionSize.initial

        FlexAxis.values().forEach { flexAxis ->
            val prop = availableSpace.axisProperty(flexAxis, context.containerStyle.flexDirection)

            val result = prop.get(context.containerStyle.size).takeIf { it.isDefinite }


        }
    }
}