package io.github.orioncraftmc.flexkt.algorithm

import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.FlexBaseSizeDeterminationStep
import io.github.orioncraftmc.flexkt.algorithm.steps.impl.CreateFlexItemsStep
import io.github.orioncraftmc.flexkt.algorithm.steps.impl.AvailableSpaceDeterminationStep
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize
import io.github.orioncraftmc.flexkt.nodes.FlexNode

object FlexibleBoxAlgorithm {
    private val steps = listOf(
        CreateFlexItemsStep,

        /* Line Length Determination */
        AvailableSpaceDeterminationStep,
        FlexBaseSizeDeterminationStep,
    )

    fun layout(container: FlexNode, containerSize: CssNumberSize): FlexibleBoxLayoutContext {
        val context = FlexibleBoxLayoutContext(FlexItem(container), containerSize)

        for (step in steps) {
            step.layout(context)
        }

        //TODO: Return layout
        return context
    }

}