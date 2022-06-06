package io.github.orioncraftmc.flexkt.enums.flex

import io.github.orioncraftmc.flexkt.traits.DefaultTrait

/**
 * The justify-content property aligns flex items along the main axis of the current line of the flex container.
 *
 * This is done after any flexible lengths and any auto margins have been resolved.
 *
 * Typically, it helps distribute extra free space leftover when either all the flex items on a line are inflexible,
 * or are flexible but have reached their maximum size.
 *
 * It also exerts some control over the alignment of items when they overflow the line.
 */
enum class FlexJustifyContent {
    /**
     * Flex items are packed toward the start of the line.
     *
     * The main-start margin edge of the first flex item on the line is placedflush with the main-start
     * edge of the line, and each subsequent flex item is placed flush with the preceding item.
     */
    FLEX_START,

    /**
     * Flex items are packed toward the end of the line.
     *
     * The main-end margin edge of the last flex item is placed flush with the main-end edge of the line,
     * and each preceding flex item is placed flush with the subsequent item.
     */
    FLEX_END,

    /**
     * Flex items are packed toward the center of the line.
     *
     * The flex items on the line are placed flush with each other and aligned in the center of the line,
     * with equal amounts of space between the main-start edge of the line and the first item on the line
     * and between the main-end edge of the line and the last item on the line.
     *
     * (If the leftover free-space is negative, the flex items will overflow equally in both directions.)
     */
    CENTER,

    /**
     * Flex items are evenly distributed in the line.
     * If the leftover free-space is negative or there is only a single flex item on the line,
     * this value is identical to flex-start.
     *
     * Otherwise, the main-start margin edge of the first flex item on the line is placed flush with the
     * main-start edge of the line, the main-end margin edge of the last flex item on the line is placed
     * flush with the main-end edge of the line, and the remaining flex items on the line are distributed
     * so that the spacing between any two adjacent items is the same.
     */
    SPACE_BETWEEN,

    /**
     * Flex items are evenly distributed in the line, with half-size spaces on either end.
     *
     * If the leftover free-space is negative or there is only a single flex item on the line,
     * this value is identical to [CENTER].
     *
     * Otherwise, the flex items on the line are distributed such that the spacing between any two adjacent
     * flex items on the line is the same, and the spacing between the first/last flex items and the
     * flex container edges is half the size of the spacing between flex items.
     */
    SPACE_AROUND;

    companion object : DefaultTrait<FlexJustifyContent> {
        override val initial: FlexJustifyContent = FLEX_START
    }
}