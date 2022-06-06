package io.github.orioncraftmc.flexkt.traits

/**
 * Represents a way of getting a default value for [T].
 */
interface DefaultTrait<T> {

    /**
     * The default value of this object.
     *
     * @return the default value of this object.
     */
    val initial: T
}

