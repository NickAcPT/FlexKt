package io.github.orioncraftmc.flexkt.math.shapes

import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.traits.DefaultTrait


class CssDimensionSize(main: CssDimension, cross: CssDimension) : CssSize<CssDimension>(main, cross) {

    val isUndefined get() = width is CssDimension.CssUndefined && height is CssDimension.CssUndefined

    companion object : DefaultTrait<CssDimensionSize> {

        val undefined: CssDimensionSize
            get() = CssDimensionSize(CssDimension.CssUndefined, CssDimension.CssUndefined)

        override val initial: CssDimensionSize
            get() = CssDimensionSize(CssDimension.initial, CssDimension.initial)
    }

}