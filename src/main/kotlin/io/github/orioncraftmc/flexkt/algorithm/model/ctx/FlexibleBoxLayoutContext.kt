package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.algorithm.model.FlexContainer
import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.math.shapes.CssDimensionSize
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize

data class FlexibleBoxLayoutContext(
    val container: FlexContainer,
    val flexItems: MutableList<FlexItem> = mutableListOf()
) {
    inline val containerStyle get() = container.style
}