package io.github.orioncraftmc.flexkt.algorithm.steps.impl

import io.github.orioncraftmc.flexkt.algorithm.helpers.axisProperty
import io.github.orioncraftmc.flexkt.algorithm.helpers.rectProperties
import io.github.orioncraftmc.flexkt.algorithm.helpers.sum
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.FlexibleBoxStep
import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.math.shapes.CssDimensionSize

object LineLengthDeterminationStep : FlexibleBoxStep {

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


            numProp.set(context.avaliableSize, result)
        }

    }
}