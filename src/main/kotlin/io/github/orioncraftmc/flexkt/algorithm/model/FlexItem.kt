package io.github.orioncraftmc.flexkt.algorithm.model

import io.github.orioncraftmc.flexkt.nodes.FlexNode

data class FlexItem(internal val node: FlexNode) {
    val children: MutableList<FlexItem> = mutableListOf()

    val style get() = node.style
}
