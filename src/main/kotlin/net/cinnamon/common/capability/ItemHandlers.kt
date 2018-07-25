@file:JvmName("ItemHandlers")
@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.common.capability

import net.cinnamon.common.collection.mc.toMutableNonNullList
import net.cinnamon.common.collection.mc.toNonNullList
import net.cinnamon.common.item.isEqvTo
import net.cinnamon.common.item.itemStackOf
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.NonNullList
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.IItemHandlerModifiable
import net.minecraftforge.items.ItemHandlerHelper

inline val IItemHandler.comparatorOutput
    get() = ItemHandlerHelper.calcRedstoneFromInventory(this)

@JvmName("addStack")
@JvmOverloads
fun IItemHandler.insertItem(stack: ItemStack, simulate: Boolean, strict: Boolean = true) = when {
    strict -> ItemHandlerHelper.insertItem(this, stack, simulate)
    else -> ItemHandlerHelper.insertItemStacked(this, stack, simulate)
}

@JvmSynthetic
inline operator fun IItemHandler.get(slot: Int) =
    getStackInSlot(slot)

@JvmSynthetic
inline operator fun IItemHandlerModifiable.set(slot: Int, stack: ItemStack) =
    setStackInSlot(slot, stack)

@JvmSynthetic
inline operator fun IItemHandlerModifiable.set(slot: Int, item: Item) =
    setStackInSlot(slot, itemStackOf(item))

@JvmName("hasStack")
operator fun IItemHandler.contains(stack: ItemStack) =
    indexOf(stack) > -1

@JvmName("hasItem")
operator fun IItemHandler.contains(item: Item) =
    indexOf(item) > -1

infix fun IItemHandler.indexOf(stack: ItemStack) =
    (0 until slots).firstOrNull { getStackInSlot(it) isEqvTo stack } ?: -1

infix fun IItemHandler.indexOf(item: Item) =
    (0 until slots).firstOrNull { getStackInSlot(it).item == item } ?: -1

@JvmName("createIterator")
operator fun IItemHandler.iterator() =
    (0 until slots).map(::getStackInSlot).iterator()

@JvmSynthetic
inline fun IItemHandler.asSequence() =
    iterator().asSequence()

@JvmName("toImmutableSet")
fun IItemHandler.toSet() =
    (0 until slots).map { getStackInSlot(it).copy() }.toSet()

@JvmName("toImmutableList")
fun IItemHandler.toList() =
    (0 until slots).map { getStackInSlot(it).copy() }.toList()

@JvmName("toImmutableNonNullList")
fun IItemHandler.toNonNullList(): NonNullList<ItemStack> =
    (0 until slots).map { getStackInSlot(it).copy() }.toNonNullList()

@JvmName("toSet")
fun IItemHandler.toMutableSet() =
    (0 until slots).map { getStackInSlot(it).copy() }.toMutableSet()

@JvmName("toList")
fun IItemHandler.toMutableList() =
    (0 until slots).map { getStackInSlot(it).copy() }.toMutableList()

@JvmName("toNonNullList")
fun IItemHandler.toMutableNonNullList() =
    (0 until slots).map { getStackInSlot(it).copy() }.toMutableNonNullList()

@JvmSynthetic
inline fun IItemHandler.forEach(action: (ItemStack) -> Unit) =
    iterator().forEach(action)
