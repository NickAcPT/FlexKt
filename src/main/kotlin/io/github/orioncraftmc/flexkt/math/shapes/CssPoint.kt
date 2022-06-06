package io.github.orioncraftmc.flexkt.math.shapes

/**
 * Represents a generic 2D Point with x and y coordinates of type [T].
 */
data class CssPoint<T>(
    /**
     * The x coordinate of the point.
     */
    val x: T,
    /**
     * The y coordinate of the point.
     */
    val y: T
)