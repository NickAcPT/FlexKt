package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize

data class FlexibleItemLayoutConstants(private val item: FlexItem) {
    var flexBaseSize: CssNumberSize = CssNumberSize.initial
}