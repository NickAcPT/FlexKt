package io.github.orioncraftmc.flexkt.algorithm.steps

import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext

abstract class RecursiveFlexItemFlexibleBoxStep : FlexibleBoxStep {
    abstract fun layout(context: FlexibleBoxLayoutContext, item: FlexItem, parent: FlexItem)

    override fun layout(context: FlexibleBoxLayoutContext) {
        performLayoutRecursively(context, context.root, null)
    }

    private fun performLayoutRecursively(context: FlexibleBoxLayoutContext, item: FlexItem, parent: FlexItem?) {
        for (child in item.children) {
            layout(context, child, item)

            performLayoutRecursively(context, child, item)
        }
    }
}