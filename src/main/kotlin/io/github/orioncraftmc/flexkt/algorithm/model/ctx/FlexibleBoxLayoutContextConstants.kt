package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize

data class FlexibleBoxLayoutContextConstants(private val context: FlexibleBoxLayoutContext) {
    var avaliableSize: CssNumberSize = CssNumberSize.initial
}