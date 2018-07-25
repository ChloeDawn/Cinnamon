@file:JvmName("Potions")

package net.cinnamon.common.item

import net.cinnamon.common.registry.potionTypeRegistry
import net.minecraft.init.PotionTypes
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.potion.PotionEffect
import net.minecraft.potion.PotionType
import net.minecraft.potion.PotionUtils
import net.minecraft.util.ResourceLocation

val PotionType.isEmpty
    get() = PotionTypes.EMPTY == this

val PotionType.creatorModId: String
    get() = potionTypeRegistry.getKey(this)?.resourceDomain
            ?: registryName?.resourceDomain.toString()

@JvmName("getPotionEffects")
@JvmOverloads
fun potionEffectsOf(stack: ItemStack, includeCustom: Boolean = false): List<PotionEffect> =
    if (includeCustom) {
        PotionUtils.getFullEffectsFromItem(stack)
    } else PotionUtils.getEffectsFromStack(stack)

@JvmName("getPotionEffects")
@JvmOverloads
fun potionEffectsOf(compound: NBTTagCompound, includeCustom: Boolean = false): List<PotionEffect> =
    if (includeCustom) {
        PotionUtils.getFullEffectsFromTag(compound)
    } else PotionUtils.getEffectsFromTag(compound)

@JvmName("getPotionColor")
fun potionColorOf(stack: ItemStack): Int =
    PotionUtils.getColor(stack)

@JvmName("getPotionColor")
fun potionColorOf(potion: PotionType): Int =
    PotionUtils.getPotionColor(potion)

@JvmName("getPotionType")
fun potionTypeOf(stack: ItemStack): PotionType =
    PotionUtils.getPotionFromItem(stack)

@JvmName("getPotionType")
fun potionTypeOf(compound: NBTTagCompound): PotionType =
    PotionUtils.getPotionTypeFromNBT(compound)

@JvmName("getPotionType")
fun potionTypeOf(name: String): PotionType? =
    PotionType.getPotionTypeForName(name)

@JvmName("getPotionType")
fun potionTypeOf(name: ResourceLocation): PotionType? =
    PotionType.getPotionTypeForName(name.toString())

fun Collection<PotionEffect>.getAveragePotionColor() =
    PotionUtils.getPotionColorFromEffectList(this)
