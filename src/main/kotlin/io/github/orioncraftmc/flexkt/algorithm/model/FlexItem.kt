package io.github.orioncraftmc.flexkt.algorithm.model

import io.github.orioncraftmc.flexkt.math.shapes.CssDimensionSize
import io.github.orioncraftmc.flexkt.nodes.FlexNode

data class FlexItem(private val node: FlexNode) {
    val children: List<FlexItem> = node.children.map { FlexItem(it) }

    val style get() = node.style
}
