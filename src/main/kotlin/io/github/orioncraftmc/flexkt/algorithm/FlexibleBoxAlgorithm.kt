package io.github.orioncraftmc.flexkt.algorithm

import io.github.orioncraftmc.flexkt.algorithm.model.FlexContainer
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.FlexibleBoxStep
import io.github.orioncraftmc.flexkt.algorithm.steps.impl.CreateFlexItemsStep
import io.github.orioncraftmc.flexkt.algorithm.steps.impl.LineLengthDeterminationStep
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize
import io.github.orioncraftmc.flexkt.nodes.FlexNode

object FlexibleBoxAlgorithm {
    private val steps = listOf(
        CreateFlexItemsStep,
        LineLengthDeterminationStep
    )

    fun layout(container: FlexNode, rootSize: CssNumberSize): FlexibleBoxLayoutContext {
        val context = FlexibleBoxLayoutContext(rootSize, FlexContainer(container))

        for (step in steps) {
            step.layout(context)
        }

        //TODO: Return layout
        return context
    }

}