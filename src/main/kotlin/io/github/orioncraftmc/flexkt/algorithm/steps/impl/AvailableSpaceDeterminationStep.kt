package io.github.orioncraftmc.flexkt.algorithm.steps.impl

import io.github.orioncraftmc.flexkt.algorithm.helpers.axisProperty
import io.github.orioncraftmc.flexkt.algorithm.helpers.notifyPropertyChange
import io.github.orioncraftmc.flexkt.algorithm.helpers.rectProperties
import io.github.orioncraftmc.flexkt.algorithm.helpers.sum
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.FlexibleBoxStep
import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.math.css.CssNumber

object AvailableSpaceDeterminationStep : FlexibleBoxStep {
    override val name: String
        get() = "Determine the available main and cross space for the flex items"

    /**
     * Determine the available main and cross space for the flex items:
     *
     * - For each dimension, if that dimension of the flex container’s content box is a definite size,
     * use that;
     * - If that dimension of the flex container is being sized under a min or max-content constraint,
     * the available space in that dimension is that constraint; otherwise, subtract the flex container’s margin,
     * border, and padding from the space available to the flex container in that dimension and use that value.
     */
    override fun layout(context: FlexibleBoxLayoutContext) {
        val flexDirection = context.root.style.flexDirection

        for (axis in FlexAxis.values()) {
            val dimProp = axisProperty<CssDimension>(axis, flexDirection)
            val numProp = axisProperty<CssNumber>(axis, flexDirection)
            val rectProps = rectProperties<CssDimension>(axis, flexDirection)

            val containerLength = numProp.get(context.containerSize)
            val length = dimProp.get(context.root.style.size).resolve(containerLength)

            val result = if (length.isDefinite) {
                val minLength = dimProp.get(context.root.style.minSize).resolve(containerLength)
                val maxLength = dimProp.get(context.root.style.maxSize).resolve(containerLength)

                length.coerceAtLeast(minLength).coerceAtMost(maxLength)
            } else {
                val marginSum = rectProps.map { it.get(context.root.style.margin).resolve(containerLength) }.sum()
                val paddingSum = rectProps.map { it.get(context.root.style.padding).resolve(containerLength) }.sum()
                containerLength - marginSum - paddingSum
            }

            numProp.set(context.constants.avaliableSize, result)

            numProp.notifyPropertyChange(
                "${axis.name} of Avaliable Size",
                receiver = context.constants.avaliableSize,
                auditor = context.auditor
            )
        }
    }
}