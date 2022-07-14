package io.github.orioncraftmc.flexkt.algorithm.helpers

import io.github.orioncraftmc.flexkt.math.css.CssNumber

fun Collection<CssNumber>.sum(): CssNumber {
    if (this.isEmpty()) return CssNumber.initial
    if (this.size == 1) return this.first()

    return this.drop(1).fold(this.first()) { l, r -> l + r }
}