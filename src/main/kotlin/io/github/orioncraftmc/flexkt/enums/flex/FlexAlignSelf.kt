package io.github.orioncraftmc.flexkt.enums.flex

import io.github.orioncraftmc.flexkt.traits.DefaultTrait

/**
 * Flex items can be aligned in the cross axis of the current line of the flex container,
 * similar to justify-content but in the perpendicular direction.
 *
 * If either of the flex item’s cross-axis margins are auto, align-self has no effect.
 *
 *  Align-Self allows this default alignment to be overridden for individual flex items.
 *
 *  (For anonymous flex items, align-self always matches the value of align-items on their associated flex container.)
 */
enum class FlexAlignSelf {
    /**
     * Defers cross-axis alignment control to the value of align-items on the parent box.
     *
     * (This is the initial value of align-self.)
     */
    AUTO,
    /**
     * The cross-start margin edge of the flex item is placed flush with the cross-start edge of the line.
     */
    FLEX_START,
    /**
     * The cross-end margin edge of the flex item is placed flush with the cross-end edge of the line.
     */
    FLEX_END,
    /**
     * The flex item’s margin box is centered in the cross axis within the line.
     *
     * (If the cross size of the flex line is less than that of the flex item,
     * it will overflow equally in both directions.)
     */
    CENTER,
    /**
     * The flex item participates in baseline alignment:
     * all participating flex items on the line are aligned such that their baselines align,
     * and the item with the largest distance between its baseline and its cross-start margin edge
     * is placed flush against the cross-start edge of the line.
     *
     * If the item does not have a baseline in the necessary axis,
     * then one is synthesized from the flex item’s border box.
     */
    BASELINE,
    /**
     * If the cross size property of the flex item computes to auto, and neither of the cross-axis margins
     * are auto, the flex item is stretched. Its used value is the length necessary to make the cross size
     * of the item’s margin box as close to the same size as the line as possible,
     * while still respecting the constraints imposed by min-height/min-width/max-height/max-width.
     *
     * **Note**: If the flex container’s height is constrained this value may cause the contents of the
     * flex item to overflow the item.
     *
     * The cross-start margin edge of the flex item is placed flush with the cross-start edge of the line.
     */
    STRETCH;

    companion object : DefaultTrait<FlexAlignSelf> {
        override val initial: FlexAlignSelf = AUTO
    }
}