package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize

data class FlexibleBoxLayoutContext(
    val root: FlexItem,
    val containerSize: CssNumberSize
) {
    val flexItems: MutableList<FlexItem> = mutableListOf()

    var avaliableSize: CssNumberSize = CssNumberSize.initial

}