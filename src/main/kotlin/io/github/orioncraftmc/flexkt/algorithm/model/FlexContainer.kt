package io.github.orioncraftmc.flexkt.algorithm.model

import io.github.orioncraftmc.flexkt.nodes.FlexNode
import io.github.orioncraftmc.flexkt.nodes.FlexStyle

data class FlexContainer(private val root: FlexNode) {
    val children: List<FlexItem> = root.children.map { FlexItem(it) }

    val style: FlexStyle get() = root.style

}
