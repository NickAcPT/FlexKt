package io.github.orioncraftmc.flexkt.math.shapes

/**
 * Represents a generic 2D Size with width and height sizes of type [T].
 */
open class CssSize<T>(
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
        var result = width?.hashCode() ?: 0
        result = 31 * result + (height?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "CssSize(width=$width, height=$height)"
    }
}