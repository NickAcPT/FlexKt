package io.github.orioncraftmc.flexkt.algorithm.steps.impl

import io.github.orioncraftmc.flexkt.algorithm.helpers.axisProperty
import io.github.orioncraftmc.flexkt.algorithm.helpers.rectProperties
import io.github.orioncraftmc.flexkt.algorithm.helpers.sum
import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleBoxLayoutContext
import io.github.orioncraftmc.flexkt.algorithm.steps.FlexibleBoxStep
import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.math.css.CssNumber

object LineLengthDeterminationStep : FlexibleBoxStep {
    override fun layout(context: FlexibleBoxLayoutContext) {
        val containerStyle = context.containerStyle

        FlexAxis.values().forEach { flexAxis ->
            val propDim = axisProperty<CssDimension>(flexAxis, containerStyle.flexDirection)
            val propNum = axisProperty<CssNumber>(flexAxis, containerStyle.flexDirection)
            val propsRectDim = rectProperties<CssDimension>(flexAxis, containerStyle.flexDirection)

            val rootLength = propNum.get(context.rootSize)
            val minConstraint = propDim.get(containerStyle.minSize).resolve(rootLength)
            val maxConstraint = propDim.get(containerStyle.maxSize).resolve(rootLength)
            val containerLength = propDim.get(containerStyle.size)

            val result = if (containerLength.isDefinite) {
                containerLength.resolve(rootLength).coerceAtLeast(minConstraint).coerceAtMost(maxConstraint)
            } else {
                val marginSum = propsRectDim.map { it.get(containerStyle.margin).resolve(rootLength) }.sum()
                val paddingSum = propsRectDim.map { it.get(containerStyle.padding).resolve(rootLength) }.sum()

                rootLength - marginSum - paddingSum
            }

            propDim.set(context.avaliableSize, CssDimension.CssPixels(result))
        }
    }
}