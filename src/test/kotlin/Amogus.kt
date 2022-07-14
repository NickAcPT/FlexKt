import io.github.orioncraftmc.flexkt.algorithm.FlexibleBoxAlgorithm
import io.github.orioncraftmc.flexkt.math.css.CssDimension
import io.github.orioncraftmc.flexkt.math.css.CssNumber
import io.github.orioncraftmc.flexkt.math.shapes.CssDimensionSize
import io.github.orioncraftmc.flexkt.math.shapes.CssNumberSize
import io.github.orioncraftmc.flexkt.nodes.FlexNode
import io.github.orioncraftmc.flexkt.nodes.FlexStyle

fun main() {
    val root = FlexNode(FlexStyle(size = CssDimensionSize(CssDimension.CssAuto, CssDimension.CssAuto)))

    val result = FlexibleBoxAlgorithm.layout(root, CssNumberSize(CssNumber(100f), CssNumber(100f)))
}