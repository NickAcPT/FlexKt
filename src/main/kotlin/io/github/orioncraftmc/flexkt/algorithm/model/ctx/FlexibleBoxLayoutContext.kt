package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.algorithm.helpers.main
import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.algorithm.trail.FlexibleBoxTrailAuditor
import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize
import io.github.orioncraftmc.flexkt.nodes.FlexStyle
import kotlin.reflect.KProperty1

data class FlexibleBoxLayoutContext(
    val root: FlexItem,
    val containerSize: CssNumberSize,
    val auditor: FlexibleBoxTrailAuditor
) {
    var constants = FlexibleBoxLayoutContextConstants(this)

    fun FlexItem.resolve(property: KProperty1<FlexStyle, CssDimension>, parent: FlexItem): CssNumber {
        return resolve(property.name, property.get(style), parent)
    }

    fun FlexItem.resolve(name: String, dimension: CssDimension, parent: FlexItem): CssNumber {
        return resolvedDimensionsCache.getOrPut(name) { dimension.resolve(containerSize.main(parent.direction)) }
    }
}

