package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.algorithm.helpers.main
import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.trail.FlexibleBoxTrailAuditor
import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize

data class FlexibleBoxLayoutContext(
    val root: FlexItem,
    val containerSize: CssNumberSize,
    val auditor: FlexibleBoxTrailAuditor
) {
    var constants = FlexibleBoxLayoutContextConstants(this)

    fun resolve(dimension: CssDimension, parent: FlexItem): CssNumber {
        return dimension.resolve(containerSize.main(parent.direction))
    }
}

