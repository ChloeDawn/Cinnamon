@file:JvmName("Colors")

package net.cinnamon.common.base

import net.cinnamon.client.client
import net.cinnamon.common.math.floorToInt
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.ColorizerFoliage
import net.minecraft.world.ColorizerGrass
import net.minecraft.world.IBlockAccess
import net.minecraft.world.biome.BiomeColorHelper
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import java.awt.Color

val grassColor: Int
    @SideOnly(Side.CLIENT)
    get() = ColorizerGrass.getGrassColor(0.5, 1.0)

val foliageColor: Int
    @SideOnly(Side.CLIENT)
    get() = ColorizerFoliage.getFoliageColorBasic()

val pineFoliageColor: Int
    @SideOnly(Side.CLIENT)
    get() = ColorizerFoliage.getFoliageColorPine()

val birchFoliageColor: Int
    @SideOnly(Side.CLIENT)
    get() = ColorizerFoliage.getFoliageColorBirch()

@JvmOverloads
@SideOnly(Side.CLIENT)
fun ItemStack.getItemColor(tintIndex: Int = 0) =
    client.itemColors.colorMultiplier(this, tintIndex)

@JvmOverloads
@SideOnly(Side.CLIENT)
fun IBlockAccess.getBlockColor(pos: BlockPos, tintIndex: Int = 0) =
    client.blockColors.colorMultiplier(getBlockState(pos), this, pos, tintIndex)

@SideOnly(Side.CLIENT)
fun IBlockAccess.getFoliageColor(pos: BlockPos) =
    BiomeColorHelper.getFoliageColorAtPos(this, pos)

@SideOnly(Side.CLIENT)
fun IBlockAccess.getGrassColor(pos: BlockPos) =
    BiomeColorHelper.getGrassColorAtPos(this, pos)

@SideOnly(Side.CLIENT)
fun IBlockAccess.getWaterColor(pos: BlockPos) =
    BiomeColorHelper.getWaterColorAtPos(this, pos)

@JvmName("getGrassColor")
@SideOnly(Side.CLIENT)
fun grassColorOf(temperature: Double, humidity: Double): Int =
    ColorizerGrass.getGrassColor(temperature, humidity)

@JvmName("getFoliageColor")
@SideOnly(Side.CLIENT)
fun foliageColorOf(temperature: Double, humidity: Double): Int =
    ColorizerFoliage.getFoliageColor(temperature, humidity)

/**
 * Returns the RGB [Int] value of the combined [red], [green], and [blue] values
 */
@JvmName("getRGBInt")
fun rgbInt(red: Int, green: Int, blue: Int): Int {
    checkComponentRange(255, red, green, blue)
    return red shl 16 or green shl 8 or blue
}

/**
 * Returns the RGB [Int] value of the combined [red], [green], and [blue] values
 */
@JvmName("getRGBInt")
fun rgbInt(red: Float, green: Float, blue: Float): Int {
    checkComponentRange(1.0F, red, green, blue)
    return rgbInt(
        floorToInt(red * 255.0F),
        floorToInt(green * 255.0F),
        floorToInt(blue * 255.0F)
    )
}

/**
 * Returns the ARGB [Int] value of the combined [alpha], [red], [green], and [blue] values
 */
@JvmName("getARGBInt")
fun argbInt(alpha: Int, red: Int, green: Int, blue: Int): Int {
    checkComponentRange(alpha, red, green, blue)
    return alpha.shl(24).or(red).shl(16).or(green).shl(8).or(blue)
}

/**
 * Returns the ARGB [Int] value of the combined [alpha], [red], [green], and [blue] values
 */
@JvmName("getARGBInt")
fun argbInt(alpha: Float, red: Float, green: Float, blue: Float): Int {
    checkComponentRange(1.0F, red, green, blue)
    return argbInt(
        floorToInt(alpha * 255.0F),
        floorToInt(red * 255.0F),
        floorToInt(green * 255.0F),
        floorToInt(blue * 255.0F)
    )
}

/**
 * Returns the RGB [Int] value of the given [hue], [saturation], and [brightness] values
 */
@JvmName("getRGBFromHSB")
fun rgbFromHsb(hue: Float, saturation: Float, brightness: Float) =
    Color.HSBtoRGB(hue, saturation, brightness)

/**
 * Returns [hsbValues], holding hue, saturation, and brightness values
 * HSB is calculated from the given [red], [green], and [blue] values
 */
@JvmOverloads
@JvmName("getHSBFromRGB")
fun hsbFromRgb(red: Int, green: Int, blue: Int, hsbValues: FloatArray = floatArrayOf()): FloatArray =
    Color.RGBtoHSB(red, green, blue, hsbValues)

/**
 * Checks the given color [Int] components supplied for validity.
 * @throws IllegalArgumentException if any component is out of range.
 */
private fun checkComponentRange(a: Int, r: Int, g: Int, b: Int) {
    var invalid = false
    var msg = ""
    if (a !in 0..255) {
        invalid = true
        msg += " alpha($a)"
    }
    if (r !in 0..255) {
        invalid = true
        msg += " red($r)"
    }
    if (g !in 0..255) {
        invalid = true
        msg += " green($g)"
    }
    if (b !in 0..255) {
        invalid = true
        msg += " blue($b)"
    }
    if (invalid) {
        throw IllegalArgumentException("Color parameter outside of expected range:$msg")
    }
}

/**
 * Checks the given color [Float] components supplied for validity.
 * @throws IllegalArgumentException if any component is out of range.
 */
private fun checkComponentRange(a: Float, r: Float, g: Float, b: Float) {
    var invalid = false
    var msg = ""
    if (a !in 0.0..1.0) {
        invalid = true
        msg += " alpha($a)"
    }
    if (r !in 0.0..1.0) {
        invalid = true
        msg += " red($r)"
    }
    if (g !in 0.0..1.0) {
        invalid = true
        msg += " green($g)"
    }
    if (b !in 0.0..1.0) {
        invalid = true
        msg += " blue($b)"
    }
    if (invalid) {
        throw IllegalArgumentException("Color parameter outside of expected range:$msg")
    }
}
