package io.github.orioncraftmc.flexkt.algorithm.helpers

import io.github.orioncraftmc.flexkt.enums.flex.FlexAxis
import io.github.orioncraftmc.flexkt.enums.flex.FlexDirection
import io.github.orioncraftmc.flexkt.math.shapes.CssDimensionSize
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class DimensionHelpersTest {

    @ParameterizedTest
    @MethodSource("axisPropertyTestProvider")
    fun `Size Axis Property helper is correct`(direction: FlexDirection, dimension: FlexAxis, expectedName: String) {
        assertEquals(expectedName, CssDimensionSize.initial.axisProperty(dimension, direction).name)
    }

    companion object {
        @JvmStatic
        fun axisPropertyTestProvider(): Stream<Arguments> {
            return listOf(
                Arguments.arguments(FlexDirection.ROW, FlexAxis.MAIN_AXIS, CssDimensionSize::width.name),
                Arguments.arguments(FlexDirection.ROW, FlexAxis.CROSS_AXIS, CssDimensionSize::height.name),

                Arguments.arguments(FlexDirection.ROW_REVERSE, FlexAxis.MAIN_AXIS, CssDimensionSize::height.name),
                Arguments.arguments(FlexDirection.ROW_REVERSE, FlexAxis.CROSS_AXIS, CssDimensionSize::width.name),

                Arguments.arguments(FlexDirection.COLUMN, FlexAxis.MAIN_AXIS, CssDimensionSize::height.name),
                Arguments.arguments(FlexDirection.COLUMN, FlexAxis.CROSS_AXIS, CssDimensionSize::width.name),

                Arguments.arguments(FlexDirection.COLUMN_REVERSE, FlexAxis.MAIN_AXIS, CssDimensionSize::width.name),
                Arguments.arguments(FlexDirection.COLUMN_REVERSE, FlexAxis.CROSS_AXIS, CssDimensionSize::height.name)

            ).stream()
        }
    }
}