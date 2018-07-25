@file:JvmName("Ores")

package net.cinnamon.common.item

import net.cinnamon.common.collection.mc.NonNullList
import net.cinnamon.common.collection.mc.toNonNullList
import net.cinnamon.common.registry.hasRegistryName
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

@JvmName("getOreIds")
fun oreIdsOf(stack: ItemStack): IntArray =
    if (stack.isNotEmpty && stack.item.hasRegistryName()) {
        OreDictionary.getOreIDs(stack)
    } else intArrayOf()

@JvmName("getOreNames")
fun oreNamesOf(stack: ItemStack) = oreIdsOf(stack).map(OreDictionary::getOreName)

@JvmName("getOres")
@JvmOverloads
fun oresOf(ore: String, createIfAbsent: Boolean = false): NonNullList<ItemStack> {
    return OreDictionary.getOres(ore, createIfAbsent).toNonNullList()
}

@JvmName("getId")
fun oreIdOf(ore: String): Int = OreDictionary.getOreID(ore)

@JvmName("getName")
fun oreNameOf(oreId: Int): String = OreDictionary.getOreName(oreId)
