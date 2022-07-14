package io.github.orioncraftmc.flexkt.algorithm.helpers

import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.enums.flex.FlexDirection
import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.math.shapes.CssRectangle
import io.github.orioncraftmc.flexkt.math.shapes.CssSize

fun <T : Any> CssSize<T>.axis(axis: FlexAxis, direction: FlexDirection): T {
    return axisProperty<T>(axis, direction).get(this)
}

fun <T : Any> CssSize<T>.main(direction: FlexDirection): T {
    return this.axis(FlexAxis.MAIN_AXIS, direction)
}

fun <T : Any> CssSize<T>.cross(direction: FlexDirection): T {
    return this.axis(FlexAxis.CROSS_AXIS, direction)
}

fun CssRectangle<CssNumber>.sumSides(axis: FlexAxis, direction: FlexDirection): CssNumber {
    return rectProperties<CssNumber>(axis, direction).map { it.get(this) }.sum()
}