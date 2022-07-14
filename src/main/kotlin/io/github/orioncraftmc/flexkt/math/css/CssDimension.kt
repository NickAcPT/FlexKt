package io.github.orioncraftmc.flexkt.math.css

import io.github.orioncraftmc.flexkt.traits.DefaultTrait

sealed class CssDimension(protected val value: CssNumber) {

    abstract fun resolve(parentDimension: CssNumber): CssNumber

    val isDefinite: Boolean
        get() = value.isDefinite

    class CssPoints(value: CssNumber) : CssDimension(value) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return value
        }
    }

    class CssPercent(value: CssNumber) : CssDimension(value) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return parentDimension * value
        }
    }

    object CssUndefined : CssDimension(CssNumber.NaN) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return CssNumber.NaN
        }
    }

    companion object : DefaultTrait<CssDimension> {
        override val initial: CssDimension
            get() = CssUndefined
    }
}
