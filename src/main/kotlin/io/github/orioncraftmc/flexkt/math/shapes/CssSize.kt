package io.github.orioncraftmc.flexkt.math.shapes

import io.github.orioncraftmc.flexkt.algorithm.helpers.cross
import io.github.orioncraftmc.flexkt.algorithm.helpers.main
import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.enums.flex.FlexDirection

/**
 * Represents a generic 2D Size with width and height sizes of type [T].
 */
open class CssSize<T : Any>(
    /**
     * The width of the size.
     */
    var width: T,
    /**
     * The height of the size.
     */
    var height: T
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CssSize<*>

        if (width != other.width) return false
        if (height != other.height) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width.hashCode()
        result = 31 * result + height.hashCode()
        return result
    }

    override fun toString(): String {
        return "CssSize(width=$width, height=$height)"
    }

    fun <R : Any> map(mapper: (value: T) -> R): CssSize<R> {
        return CssSize(mapper(width), mapper(height))
    }

    fun <R : Any> mapWithAxis(direction: FlexDirection, mapper: (value: T, axis: FlexAxis) -> R): CssSize<R> {
        return CssSize(
            mapper(this.main(direction), FlexAxis.MAIN_AXIS),
            mapper(this.cross(direction), FlexAxis.CROSS_AXIS)
        )
    }
}