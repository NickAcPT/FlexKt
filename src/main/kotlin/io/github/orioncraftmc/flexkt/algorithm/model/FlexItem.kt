package io.github.orioncraftmc.flexkt.algorithm.model

import io.github.orioncraftmc.flexkt.math.shapes.CssDimensionSize
import io.github.orioncraftmc.flexkt.nodes.FlexNode

data class FlexItem(private val node: FlexNode) {
    val style get() = node.style

    var avaliableSize: CssDimensionSize = CssDimensionSize.initial
}
