package io.github.orioncraftmc.flexkt.algorithm.helpers

import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.enums.flex.FlexDirection
import io.github.orioncraftmc.flexkt.math.shapes.CssDimensionSize
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize

fun CssDimensionSize.resolve(parentDimension: CssNumberSize, direction: FlexDirection): CssNumberSize {
    return CssNumberSize(
        this.axis(FlexAxis.MAIN_AXIS, direction).resolve(parentDimension.axis(FlexAxis.MAIN_AXIS, direction)),
        this.axis(FlexAxis.CROSS_AXIS, direction).resolve(parentDimension.axis(FlexAxis.CROSS_AXIS, direction))
    )
}