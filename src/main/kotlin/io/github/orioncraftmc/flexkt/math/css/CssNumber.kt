package io.github.orioncraftmc.flexkt.math.css

import io.github.orioncraftmc.flexkt.traits.DefaultTrait

@JvmInline
value class CssNumber(private val value: Float) {

    operator fun plus(other: CssNumber) = CssNumber(value + other.value)

    operator fun minus(other: CssNumber) = CssNumber(value - other.value)

    operator fun times(other: CssNumber) = CssNumber(value * other.value)

    operator fun div(other: CssNumber) = CssNumber(value / other.value)

    operator fun compareTo(other: CssNumber) = value.compareTo(other.value)

    companion object : DefaultTrait<CssNumber> {
        val NaN: CssNumber = CssNumber(Float.NaN)

        override val initial: CssNumber = CssNumber(0f)
    }

}