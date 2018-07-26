@file:JvmName("Items")

package net.cinnamon.common.item

import net.cinnamon.common.collection.mc.NonNullList
import net.cinnamon.common.collection.mc.nonNullListOf
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemBlockSpecial
import net.minecraft.item.ItemStack
import net.minecraft.stats.StatBase
import net.minecraft.stats.StatList

/**
 * Queries [Item.REGISTRY] to determine the ID of the receiver
 * @return The [Int] item ID of the receiver in the registry
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.id: Int get() = Item.REGISTRY.getIDForObject(this)

/**
 * Collects the receiver's sub items for the given [tab]
 * If no [tab] is defined, defaults to [Item.getCreativeTab]
 * If [tab] is `null`, falls back to [CreativeTabs.SEARCH]
 * @return An immutable [NonNullList] of [ItemStack] sub items
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmOverloads
fun Item.getSubItems(tab: CreativeTabs? = creativeTab): NonNullList<ItemStack> =
    nonNullListOf<ItemStack>().also { getSubItems(tab ?: CreativeTabs.SEARCH, it) }

/**
 * Determines if the receiver is an [ItemBlock] or [ItemBlockSpecial]
 * @return [Blocks.AIR] if the receiver is not an [Block] provider
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.block: Block
    get() = when {
        this is ItemBlock -> block
        this is ItemBlockSpecial -> block
        else -> Blocks.AIR
    }

/**
 * Compares the receiver [Item] to [Items.AIR]
 * @return True if the receiver is equal to [Items.AIR]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.isEmpty get() = Items.AIR == this

/**
 * Compares the receiver [Item] to [Items.AIR]
 * @return True if the receiver is NOT equal to [Items.AIR]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.isNotEmpty get() = Items.AIR != this

/**
 * Safely queries the [StatBase] mapped to this receiver in [StatList.CRAFTS_STATS]
 * @return `null` if no [StatBase] exists for the receiver's [Item.id]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.craftStats: StatBase? get() = StatList.getCraftStats(this)

/**
 * Safely queries the [StatBase] mapped to this receiver in [StatList.OBJECT_USE_STATS]
 * @return `null` if no [StatBase] exists for the receiver's [Item.id]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.usageStats: StatBase? get() = StatList.getObjectUseStats(this)

/**
 * Safely queries the [StatBase] mapped to this receiver in [StatList.OBJECT_BREAK_STATS]
 * @return `null` if no [StatBase] exists for the receiver's [Item.id]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.breakStats: StatBase? get() = StatList.getObjectBreakStats(this)

/**
 * Safely queries the [StatBase] mapped to this receiver in [StatList.OBJECTS_PICKED_UP_STATS]
 * @return `null` if no [StatBase] exists for the receiver's [Item.id]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.pickedUpStats: StatBase? get() = StatList.getObjectsPickedUpStats(this)

/**
 * Safely queries the [StatBase] mapped to this receiver in [StatList.OBJECTS_DROPPED_STATS]
 * @return `null` if no [StatBase] exists for the receiver's [Item.id]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Item.droppedStats: StatBase? get() = StatList.getDroppedObjectStats(this)
