package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.algorithm.model.FlexContainer
import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem

data class FlexibleBoxLayoutContext(
    val container: FlexContainer,
    val flexItems: MutableList<FlexItem> = mutableListOf()
) {
    inline val containerStyle get() = container.style
}