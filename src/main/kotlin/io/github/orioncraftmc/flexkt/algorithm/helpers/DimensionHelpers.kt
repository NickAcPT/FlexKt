package io.github.orioncraftmc.flexkt.algorithm.helpers

import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.enums.flex.FlexDirection
import io.github.orioncraftmc.flexkt.math.shapes.CssRectangle
import io.github.orioncraftmc.flexkt.math.shapes.CssSize
import kotlin.reflect.KMutableProperty1

fun <T : Any> axisProperty(dimension: FlexAxis, direction: FlexDirection): KMutableProperty1<CssSize<T>, T> {
    val dimensions = arrayOf(/* main axis */CssSize<T>::width, /* cross axis */CssSize<T>::height)
    val directions = arrayOf(FlexAxis.MAIN_AXIS, FlexAxis.CROSS_AXIS)

    if (direction.isReverse) dimensions.reverse()
    if (direction.isColumn) dimensions.reverse()

    return dimensions[directions.indexOf(dimension)]
}

fun <T> rectProperties(dimension: FlexAxis, direction: FlexDirection): Array<KMutableProperty1<CssRectangle<T>, T>> {
    val dimensions = arrayOf(
        arrayOf(CssRectangle<T>::left, CssRectangle<T>::right),
        arrayOf(CssRectangle<T>::top, CssRectangle<T>::bottom)
    )
    val directions = arrayOf(FlexAxis.MAIN_AXIS, FlexAxis.CROSS_AXIS)

    if (direction.isReverse) dimensions.forEach { it.reverse() }
    if (direction.isColumn) dimensions.reverse()

    return dimensions[directions.indexOf(dimension)]
}