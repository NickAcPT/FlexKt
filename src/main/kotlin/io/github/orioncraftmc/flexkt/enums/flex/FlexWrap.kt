package io.github.orioncraftmc.flexkt.enums.flex

import io.github.orioncraftmc.flexkt.traits.DefaultTrait

/**
 * The flex-wrap property controls whether the flex container is single-line or multi-line,
 * and the direction of the cross-axis, which determines the direction new lines are stacked in.
 *
 * For the values that are not wrap-reverse, the cross-start direction is equivalent to either the inline-start
 * or block-start direction of the current writing mode (whichever is in the cross axis) and the cross-end direction
 * is the opposite direction of cross-start.
 *
 * When flex-wrap is wrap-reverse, the cross-start and cross-end directions are swapped.
 */
enum class FlexWrap(val singleLine: Boolean, val reverse: Boolean) {
    /**
     * The flex container is single-line.
     */
    NO_WRAP(singleLine = true, reverse = false),

    /**
     * The flex container is multi-line.
     */
    WRAP(singleLine = false, reverse = false),

    /**
     * Same as [WRAP].
     */
    WRAP_REVERSE(singleLine = false, reverse = true);

    companion object : DefaultTrait<FlexWrap> {
        override val initial: FlexWrap = NO_WRAP
    }
}