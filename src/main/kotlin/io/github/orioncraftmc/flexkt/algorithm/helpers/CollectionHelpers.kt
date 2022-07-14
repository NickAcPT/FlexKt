package io.github.orioncraftmc.flexkt.algorithm.helpers

import io.github.orioncraftmc.flexkt.math.css.CssNumber

fun Collection<CssNumber>.sum() = this.fold(CssNumber.initial) { l, r -> l + r }