package io.github.orioncraftmc.flexkt.math.shapes


/**
 * Represents a generic 2D rectangle with a left, top, right, and bottom coordinates of type [T].
 */
open class CssRectangle<T>(
    /**
     * The left-most coordinate of the rectangle.
     */
    var left: T,
    /**
     * The top-most coordinate of the rectangle.
     */
    var top: T,
    /**
     * The right-most coordinate of the rectangle.
     */
    var right: T,
    /**
     * The bottom-most coordinate of the rectangle.
     */
    var bottom: T
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CssRectangle<*>

        if (left != other.left) return false
        if (top != other.top) return false
        if (right != other.right) return false
        if (bottom != other.bottom) return false

        return true
    }

    override fun hashCode(): Int {
        var result = left?.hashCode() ?: 0
        result = 31 * result + (top?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        result = 31 * result + (bottom?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "CssRectangle(left=$left, top=$top, right=$right, bottom=$bottom)"
    }
}

