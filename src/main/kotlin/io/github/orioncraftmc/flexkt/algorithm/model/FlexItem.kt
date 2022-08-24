package io.github.orioncraftmc.flexkt.algorithm.model

import io.github.orioncraftmc.flexkt.algorithm.model.ctx.FlexibleItemLayoutConstants
import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.nodes.FlexNode

data class FlexItem(internal val node: FlexNode) {
    val children: MutableList<FlexItem> = mutableListOf()

    val style get() = node.style

    val direction get() = style.flexDirection

    val constants by lazy { FlexibleItemLayoutConstants(this) }
}

