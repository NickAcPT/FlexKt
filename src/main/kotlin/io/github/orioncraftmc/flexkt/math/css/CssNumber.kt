package io.github.orioncraftmc.flexkt.math.css

import io.github.orioncraftmc.flexkt.traits.DefaultTrait

@JvmInline
value class CssNumber(private val value: Float) {

    val isDefinite
        get() = value.isFinite()

    operator fun plus(other: CssNumber): CssNumber {
        if (!other.isDefinite) return CssNumber(value)
        return CssNumber(value + other.value)
    }

    operator fun minus(other: CssNumber): CssNumber {
        if (!other.isDefinite) return CssNumber(value)
        if (!this.isDefinite) return CssNumber(-other.value)
        return CssNumber(value - other.value)
    }

    operator fun times(other: CssNumber): CssNumber {
        return CssNumber(value * other.value)
    }

    operator fun div(other: CssNumber): CssNumber {
        return CssNumber(value / other.value)
    }

    operator fun compareTo(other: CssNumber) = value.compareTo(other.value)

    fun coerceAtLeast(other: CssNumber): CssNumber {
        if (!other.isDefinite) return this
        return if (value < other.value) other else this
    }

    fun coerceAtMost(other: CssNumber): CssNumber {
        if (!other.isDefinite) return this
        return if (value > other.value) other else this
    }

    override fun toString() = value.toString()

    companion object : DefaultTrait<CssNumber> {

        val NaN: CssNumber = CssNumber(Float.NaN)
        override val initial: CssNumber = CssNumber(0f)
    }
}