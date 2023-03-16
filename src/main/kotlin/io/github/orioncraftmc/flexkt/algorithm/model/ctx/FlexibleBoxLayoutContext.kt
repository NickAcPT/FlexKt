package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.algorithm.helpers.axis
import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.trail.FlexibleBoxTrailAuditor
import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize

data class FlexibleBoxLayoutContext(
    val root: FlexItem,
    val containerSize: CssNumberSize,
    val auditor: FlexibleBoxTrailAuditor
) {
    var constants = FlexibleBoxLayoutContextConstants(this)

    fun resolveAxis(
        dimension: CssDimension,
        axis: FlexAxis,
        parent: FlexItem,
        size: CssNumberSize = containerSize
    ): CssNumber {
        return dimension.resolve(size.axis(axis, parent.direction))
    }

    fun resolveMain(dimension: CssDimension, parent: FlexItem, size: CssNumberSize = containerSize): CssNumber {
        return resolveAxis(dimension, FlexAxis.MAIN_AXIS, parent, size)
    }

    fun resolveCross(dimension: CssDimension, parent: FlexItem, size: CssNumberSize = containerSize): CssNumber {
        return resolveAxis(dimension, FlexAxis.CROSS_AXIS, parent, size)
    }
}

