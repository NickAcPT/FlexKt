package io.github.orioncraftmc.flexkt.algorithm.steps.impl

import io.github.orioncraftmc.flexkt.algorithm.helpers.cross
import io.github.orioncraftmc.flexkt.algorithm.helpers.main
import io.github.orioncraftmc.flexkt.algorithm.helpers.notifyPropertyChange
import io.github.orioncraftmc.flexkt.algorithm.helpers.resolve
import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.RecursiveFlexItemFlexibleBoxStep

object FlexBaseSizeDeterminationStep : RecursiveFlexItemFlexibleBoxStep() {

    /**
     * Determine the flex base size and hypothetical main size of each item:
     *
     * - If the item has a definite used flex basis, that’s the flex base size.
     *
     * - If the flex item has: an intrinsic aspect ratio, a used flex basis of content, and
     * a definite cross size, then the flex base size is calculated from its inner cross size
     * and the flex item’s intrinsic aspect ratio.
     *
     * - If the used flex basis is content or depends on its available space,
     * and the flex container is being sized under a min-content or max-content constraint,
     * size the item under that constraint. The flex base size is the item’s resulting main size.
     *
     * - Otherwise, if the used flex basis is content or depends on its available space,
     * the available main size is infinite, and the flex item’s inline axis is parallel
     * to the main axis, lay the item out using the rules for a box in an orthogonal
     * flow. The flex base size is the item’s max-content main size.
     */

    override fun layout(context: FlexibleBoxLayoutContext, item: FlexItem, parent: FlexItem) {
        val flexBasis = item.style.flexBasis

        val usedFlexBasis = flexBasis.resolve(context.containerSize.main(parent.direction))
        val hasIntrinsicAspectRatio = item.style.aspectRatio.isDefinite
        val crossSize = item.style.size.cross(parent.style.flexDirection)
        val hasDefiniteCrossSize = crossSize.isDefinite

        if (hasIntrinsicAspectRatio && hasDefiniteCrossSize) {
            
        } else if (usedFlexBasis.isDefinite) {
            // If the item has a definite used flex basis, that’s the flex base size.
            item.flexBaseSize = usedFlexBasis

            FlexItem::flexBaseSize.notifyPropertyChange(
                "FlexItem Base Size",
                reason = "Item has a definite used flex basis",
                receiver = item,
                auditor = context.auditor
            )
        }
    }

    override val name: String
        get() = "Determine the flex base size and hypothetical main size of each item"

}
