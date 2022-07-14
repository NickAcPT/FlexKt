package io.github.orioncraftmc.flexkt.math.css

import io.github.orioncraftmc.flexkt.math.shapes.CssRectangle
import io.github.orioncraftmc.flexkt.traits.DefaultTrait

/**
 * Represents a rectangle that takes [CssDimension]s for each side.
 */
class CssDimensionRectangle(
    left: CssDimension = CssDimension.initial,
    top: CssDimension = CssDimension.initial,
    right: CssDimension = CssDimension.initial,
    bottom: CssDimension = CssDimension.initial
) : CssRectangle<CssDimension>(left, top, right, bottom) {

    companion object : DefaultTrait<CssDimensionRectangle> {
        override val initial: CssDimensionRectangle
            get() = CssDimensionRectangle(
                CssDimension.initial,
                CssDimension.initial,
                CssDimension.initial,
                CssDimension.initial
            )

    }
}