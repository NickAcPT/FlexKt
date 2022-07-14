package io.github.orioncraftmc.flexkt.algorithm.steps.impl

import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.FlexibleBoxStep
import io.github.orioncraftmc.flexkt.algorithm.steps.RecursiveFlexItemFlexibleBoxStep

object CreateFlexItemsStep : FlexibleBoxStep {

    override val name: String
        get() = "Create Flex Items"

    /**
     * Performs the first layout step of the flexible box algorithm.
     *
     * The steps are as follows:
     * - Order the children by their order property. (Flex layout works with the flex items in order-modified document order,
     * not their original document order)
     * - Then collect the items that participate in the flex layout.
     * - Then finally create the flex items for each node.
     */
    override fun layout(context: FlexibleBoxLayoutContext) {
        context.root.node.children
            .asSequence()
            .sortedBy { it.style.order }
            .filter { it.style.visibility.affectsLayout }
            .forEach {
                context.root.children.add(FlexItem(it))
            }
    }
}