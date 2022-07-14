package io.github.orioncraftmc.flexkt.math.shapes

import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.traits.DefaultTrait

class CssNumberSize(width: CssNumber, height: CssNumber) : CssSize<CssNumber>(width, height) {

    companion object : DefaultTrait<CssNumberSize> {
        override val initial: CssNumberSize
            get() = CssNumberSize(CssNumber.initial, CssNumber.initial)
    }

}