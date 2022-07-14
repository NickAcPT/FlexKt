package io.github.orioncraftmc.flexkt.algorithm

import io.github.orioncraftmc.flexkt.algorithm.model.FlexContainer
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.FlexibleBoxStep
import io.github.orioncraftmc.flexkt.algorithm.steps.impl.CreateFlexItemsStep
import io.github.orioncraftmc.flexkt.nodes.FlexNode

object FlexibleBoxAlgorithm {
    private val steps = listOf<FlexibleBoxStep>(
        CreateFlexItemsStep
    )

    fun layout(container: FlexNode) {
        val context = FlexibleBoxLayoutContext(FlexContainer(container))

        for (step in steps) {
            step.layout(context)
        }

        //TODO: Return layout
    }

}