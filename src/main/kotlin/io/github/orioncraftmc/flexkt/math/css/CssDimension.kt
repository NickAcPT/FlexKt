package io.github.orioncraftmc.flexkt.math.css

import io.github.orioncraftmc.flexkt.algorithm.helpers.number
import io.github.orioncraftmc.flexkt.traits.DefaultTrait

sealed class CssDimension(protected val value: CssNumber) {

    open val dependsOnAvailableSpace: Boolean
        get() = false

    abstract fun resolve(parentDimension: CssNumber): CssNumber

    val isDefinite: Boolean
        get() = value.isDefinite

    class CssPoints(value: CssNumber) : CssDimension(value) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return value
        }

        override fun toString() = "${value}pt"
    }

    class CssPercent(value: CssNumber) : CssDimension(value) {
        override val dependsOnAvailableSpace: Boolean
            get() = true

        override fun resolve(parentDimension: CssNumber): CssNumber {
            return parentDimension * value
        }

        override fun toString() = "${(value * number(100f))}%"
    }

    object CssUndefined : CssDimension(CssNumber.NaN) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return CssNumber.NaN
        }

        override fun toString() = "CssUndefined"
    }

    companion object : DefaultTrait<CssDimension> {
        override val initial: CssDimension
            get() = CssUndefined
    }
}
