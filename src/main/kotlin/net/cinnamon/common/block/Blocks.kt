@file:JvmName("Blocks")

package net.cinnamon.common.block

import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.stats.StatBase
import net.minecraft.stats.StatList
import net.minecraftforge.fluids.Fluid
import net.minecraftforge.fluids.FluidRegistry

/**
 * Queries [Block.REGISTRY] to determine the ID of the receiver
 * @return The [Int] block ID of the receiver in the registry
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Block.id: Int get() = Block.REGISTRY.getIDForObject(this)

/**
 * Queries [Item.BLOCK_TO_ITEM] to find an [Item] mapped to this receiver
 * If no registered [Item] is mapped to the receiver, returns [Items.AIR]
 * @return The [Item] mapped to the receiver in [Item.BLOCK_TO_ITEM]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Block.item: Item
    get() = Item.getItemFromBlock(this)

/**
 * Queries [FluidRegistry.fluidBlocks] to find a [Fluid] mapped to this receiver
 * If no registered [Fluid] is mapped to the receiver, returns `null`
 * @return The [Fluid] mapped to the receiver in [FluidRegistry.fluidBlocks]
 * @author InsomniaKitten
 * @since 1.0.0
 */
fun Block.getFluid(): Fluid? = FluidRegistry.lookupFluidForBlock(this)

/**
 * Determines if there is a registered [Fluid] mapped to this receiver
 * @return True if [Block.getFluid] returns a non-null [Fluid]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Block.isFluidBlock get() = getFluid() != null

/**
 * Compares the receiver [Block] to [Blocks.AIR]
 * @return True if the receiver is equal to [Blocks.AIR]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Block.isEmpty: Boolean get() = Blocks.AIR == this

/**
 * Compares the receiver [Block] to [Blocks.AIR]
 * @return True if the receiver is NOT equal to [Blocks.AIR]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Block.isNotEmpty: Boolean get() = Blocks.AIR != this

/**
 * Queries the [StatBase] mapped to this receiver in [StatList.BLOCKS_STATS]
 * @return `null` if no [StatBase] exists for the receiver's [Block.id]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val Block.stats: StatBase?
    get() = StatList.getBlockStats(this)
