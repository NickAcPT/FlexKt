package io.github.orioncraftmc.flexkt.math.css

sealed class CssDimension(val value: CssNumber) {
    abstract fun resolve(parentDimension: CssNumber): CssNumber

    sealed class CssPixels(value: CssNumber) : CssDimension(value) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return value
        }
    }

    sealed class CssPercent(value: CssNumber) : CssDimension(value) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return parentDimension * value
        }
    }

    object CssAuto : CssDimension(CssNumber.NaN) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return CssNumber.NaN
        }
    }

    object CssUndefined : CssDimension(CssNumber.NaN) {
        override fun resolve(parentDimension: CssNumber): CssNumber {
            return CssNumber.NaN
        }
    }
}