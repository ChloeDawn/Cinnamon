package net.cinnamon.common.base

import net.minecraft.block.material.MapColor
import net.minecraft.item.EnumDyeColor
import net.minecraft.util.IStringSerializable
import java.util.Locale

enum class Color(
        val mapColor: MapColor,
        val dyeColor: EnumDyeColor,
        val colorValue: Int
) : IStringSerializable {
    BLACK      ( MapColor.BLACK,      EnumDyeColor.BLACK,      0x1D1D21 ),
    RED        ( MapColor.RED,        EnumDyeColor.RED,        0xB02E26 ),
    GREEN      ( MapColor.GREEN,      EnumDyeColor.GREEN,      0x5E7C16 ),
    BROWN      ( MapColor.BROWN,      EnumDyeColor.BROWN,      0x835432 ),
    BLUE       ( MapColor.BLUE,       EnumDyeColor.BLUE,       0x3C44AA ),
    PURPLE     ( MapColor.PURPLE,     EnumDyeColor.PURPLE,     0x8932B8 ),
    CYAN       ( MapColor.CYAN,       EnumDyeColor.CYAN,       0x169C9C ),
    LIGHT_GRAY ( MapColor.SILVER,     EnumDyeColor.SILVER,     0x9D9D97 ),
    GRAY       ( MapColor.GRAY,       EnumDyeColor.GRAY,       0x474F52 ),
    PINK       ( MapColor.PINK,       EnumDyeColor.PINK,       0xF38BAA ),
    LIME       ( MapColor.LIME,       EnumDyeColor.LIME,       0x80C71F ),
    YELLOW     ( MapColor.YELLOW,     EnumDyeColor.YELLOW,     0xFED83D ),
    LIGHT_BLUE ( MapColor.LIGHT_BLUE, EnumDyeColor.LIGHT_BLUE, 0x3AB3DA ),
    MAGENTA    ( MapColor.MAGENTA,    EnumDyeColor.MAGENTA,    0xC74EBD ),
    ORANGE     ( MapColor.GOLD,       EnumDyeColor.ORANGE,     0xF9801D ),
    WHITE      ( MapColor.SNOW,       EnumDyeColor.WHITE,      0xF9FFFE );

    override fun getName() = name.toLowerCase(Locale.ROOT)

    companion object {
        private val VALUES = values()

        @JvmStatic
        @JvmName("valueOf")
        operator fun get(ordinal: Int) = VALUES[ordinal]
    }
}
