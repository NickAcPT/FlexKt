package io.github.orioncraftmc.flexkt.algorithm

import io.github.orioncraftmc.flexkt.algorithm.helpers.pass
import io.github.orioncraftmc.flexkt.algorithm.helpers.step
import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.impl.FlexBaseSizeDeterminationStep
import io.github.orioncraftmc.flexkt.algorithm.steps.impl.CreateFlexItemsStep
import io.github.orioncraftmc.flexkt.algorithm.steps.impl.AvailableSpaceDeterminationStep
import io.github.orioncraftmc.flexkt.algorithm.trail.FlexibleBoxTrailAuditor
import io.github.orioncraftmc.flexkt.algorithm.trail.impl.EmptyFlexibleBoxAuditor
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize
import io.github.orioncraftmc.flexkt.nodes.FlexNode

object FlexibleBoxAlgorithm {
    private val steps = listOf(
        CreateFlexItemsStep,

        /* Line Length Determination */
        AvailableSpaceDeterminationStep,
        FlexBaseSizeDeterminationStep,
    )

    fun layout(container: FlexNode, containerSize: CssNumberSize, auditor: FlexibleBoxTrailAuditor = EmptyFlexibleBoxAuditor): FlexibleBoxLayoutContext {
        val context = FlexibleBoxLayoutContext(FlexItem(container), containerSize, auditor)

        auditor.pass("First Layout Pass") {
            for ((index, step) in steps.withIndex()) {
                auditor.step(step.name) {
                    step.layout(context)
                }
            }
        }

        //TODO: Return layout
        return context
    }

}