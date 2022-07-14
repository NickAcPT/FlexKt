package io.github.orioncraftmc.flexkt.algorithm.helpers

import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize

inline fun number(value: Float) = CssNumber(value)

inline fun points(value: Float) = CssDimension.CssPoints(number(value))

inline fun percentage(value: Float) = CssDimension.CssPercent(number(value))

inline fun numberSize(width: Float, height: Float) = CssNumberSize(number(width), number(height))