package io.github.orioncraftmc.flexkt.algorithm.steps

import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext

object FlexBaseSizeDeterminationStep : RecursiveFlexItemFlexibleBoxStep() {
    override fun layout(context: FlexibleBoxLayoutContext, item: FlexItem, parent: FlexItem?) {

    }

    override val name: String
        get() = "Determine the flex base size and hypothetical main size of each item"

}
