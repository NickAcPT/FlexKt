package io.github.orioncraftmc.flexkt.math.css

import io.github.orioncraftmc.flexkt.math.shapes.CssRectangle
import io.github.orioncraftmc.flexkt.traits.DefaultTrait

/**
 * Represents a CSS margin rectangle that takes [CssDimension]s for each side.
 */
class CssMarginRectangle(
    left: CssDimension,
    top: CssDimension,
    right: CssDimension,
    bottom: CssDimension
) : CssRectangle<CssDimension>(left, top, right, bottom) {

    companion object : DefaultTrait<CssMarginRectangle> {
        override val initial: CssMarginRectangle
            get() = CssMarginRectangle(
                CssDimension.CssUndefined,
                CssDimension.CssUndefined,
                CssDimension.CssUndefined,
                CssDimension.CssUndefined
            )

    }
}