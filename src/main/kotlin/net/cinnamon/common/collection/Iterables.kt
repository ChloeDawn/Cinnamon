@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.common.collection

import net.cinnamon.common.item.emptyItemStack
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

@JvmSynthetic
inline fun <T> Iterable<T>.isEmpty() =
    count() == 0

@JvmSynthetic
inline fun <T> Iterable<T>.firstOrElse(other: T) =
    firstOrNull() ?: other

@JvmSynthetic
inline fun Iterable<ItemStack>.firstOrEmpty(): ItemStack =
    firstOrNull() ?: emptyItemStack()

@JvmSynthetic
inline fun Iterable<Block>.firstOrEmpty(): Block =
    firstOrNull() ?: Blocks.AIR

@JvmSynthetic
inline fun Iterable<Item>.firstOrEmpty(): Item =
    firstOrNull() ?: Items.AIR
