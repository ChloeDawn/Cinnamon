@file:JvmName("Dyes")

package net.cinnamon.common.item

import net.minecraft.item.EnumDyeColor
import net.minecraft.item.ItemStack

private val dyeOreNames = arrayOf(
    "dyeWhite",
    "dyeOrange",
    "dyeMagenta",
    "dyeLightBlue",
    "dyeYellow",
    "dyeLime",
    "dyePink",
    "dyeGray",
    "dyeLightGray",
    "dyeCyan",
    "dyePurple",
    "dyeBlue",
    "dyeBrown",
    "dyeGreen",
    "dyeRed",
    "dyeBlack"
)

fun isDye(stack: ItemStack) =
    dyeMetadataOf(stack) != null

@JvmName("getDyeColor")
fun dyeColorOf(stack: ItemStack) =
    dyeMetadataOf(stack)?.let(EnumDyeColor::byMetadata)

@JvmName("getDyeMetadata")
fun dyeMetadataOf(stack: ItemStack) =
    oreNamesOf(stack).map(dyeOreNames::indexOf).firstOrNull { it >= 0 }

@JvmName("getDyeDamage")
fun dyeDamageOf(stack: ItemStack) =
    dyeMetadataOf(stack)?.let(0xF::minus)
