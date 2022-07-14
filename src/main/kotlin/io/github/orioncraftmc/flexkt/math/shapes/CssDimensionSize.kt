package io.github.orioncraftmc.flexkt.math.shapes

import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.traits.DefaultTrait


class CssDimensionSize(width: CssDimension, height: CssDimension) : CssSize<CssDimension>(width, height) {

    companion object : DefaultTrait<CssDimensionSize> {
        override val initial: CssDimensionSize
            get() = CssDimensionSize(CssDimension.initial, CssDimension.initial)
    }

}