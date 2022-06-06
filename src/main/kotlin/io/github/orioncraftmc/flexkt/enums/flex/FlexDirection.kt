package io.github.orioncraftmc.flexkt.enums.flex

import io.github.orioncraftmc.flexkt.traits.DefaultTrait

/**
 * The flex-direction property specifies how flex items are placed in the flex container,
 * by setting the direction of the flex container’s main axis.
 *
 *  This determines the direction in which flex items are laid out.
 *
 *  **Note**: The reverse values do not reverse box ordering: like writing-mode and direction,
 *  they only change the direction of flow. Painting order, speech order, and sequential navigation orders are not affected.
 *
 *  @property isReverse Whether the main-start and main-end directions are swapped.
 */
enum class FlexDirection(val isReverse: Boolean = false) {

    /**
     * The flex container’s main axis has the same orientation as the inline axis of the current writing mode.
     *
     * The main-start and main-end directions are equivalent to the inline-start and inline-end directions,
     * respectively, of the current writing mode.
     */
    ROW,

    /**
     * Same as [ROW], except the main-start and main-end directions are swapped.
     */
    ROW_REVERSE(isReverse = true),

    /**
     * The flex container’s main axis has the same orientation as the block axis of the current writing mode.
     *
     * The main-start and main-end directions are equivalent to the block-start and block-end directions, respectively,
     * of the current writing mode.
     */
    COLUMN,

    /**
     * Same as [COLUMN], except the main-start and main-end directions are swapped.
     */
    COLUMN_REVERSE(isReverse = true);

    companion object : DefaultTrait<FlexDirection> {
        override val initial: FlexDirection = ROW
    }
}