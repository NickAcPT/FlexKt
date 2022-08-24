package io.github.orioncraftmc.flexkt.algorithm.model.ctx

import io.github.orioncraftmc.flexkt.algorithm.model.FlexItem
import io.github.orioncraftmc.flexkt.math.css.CssNumber

data class FlexibleItemLayoutConstants(private val item: FlexItem) {
    var flexBaseSize: CssNumber = CssNumber.NaN

    var resolvedFlexBasis: CssNumber = CssNumber.initial
}