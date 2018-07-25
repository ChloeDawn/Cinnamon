@file:JvmName("ItemStacks")

package net.cinnamon.common.item

import com.google.common.base.Equivalence
import com.google.common.base.Equivalence.Wrapper
import net.cinnamon.common.base.hashCodeOf
import net.minecraft.block.Block
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

val ItemStack.isNotEmpty get() = !isEmpty

val ItemStack.creatorModId
    get() = item.getCreatorModId(this)

fun ItemStack.eqvHash() = ItemStackEquivalence.hash(this)

@JvmName("wrapEqv")
fun eqvOf(stack: ItemStack): Wrapper<ItemStack> =
    ItemStackEquivalence.wrap(stack)

@JvmName("areEqv")
infix fun ItemStack.isEqvTo(other: ItemStack) =
    ItemStackEquivalence.equivalent(this, other)

@SideOnly(Side.CLIENT)
@JvmOverloads
fun ItemStack.getTooltip(player: EntityPlayer? = null, advanced: Boolean = false): MutableList<String> =
    getTooltip(player) { advanced }

@SideOnly(Side.CLIENT)
fun ItemStack.getTooltip(flag: ITooltipFlag): MutableList<String> =
    getTooltip(null, flag)

/**
 * Returns whether this [ItemStack] is repairable in an anvil
 * @param repairer The [ItemStack] being used to repair the receiver
 * @author InsomniaKitten
 * @since 1.0.0
 */
fun ItemStack.isRepairable(repairer: ItemStack) = item.getIsRepairable(this, repairer)

/**
 * An inverse of [ItemStack.isRepairable], where the receiver [ItemStack] is the repairer
 * @param repairable The [ItemStack] being checked to see if it is repairable by the receiver
 * @author InsomniaKitten
 * @since 1.0.0
 */
infix fun ItemStack.canRepair(repairable: ItemStack) = repairable.isRepairable(this)

/**
 * Copies the receiver [ItemStack], setting its count to the given [count]
 * Returns [emptyItemStack] if the given [count] is 0
 * @author InsomniaKitten
 * @since 1.0.0
 */
fun ItemStack.copy(count: Int): ItemStack = when (count) {
    0 -> emptyItemStack()
    else -> copy().also {
        it.count = count
    }
}

/**
 * Copies the receiver [ItemStack], setting its count to the given [count]
 * Also sets its metadata to the given [meta] value
 * Returns [emptyItemStack] if the given [count] is 0
 * @author InsomniaKitten
 * @since 1.0.0
 */
fun ItemStack.copy(count: Int, meta: Int): ItemStack = when (count) {
    0 -> emptyItemStack()
    else -> copy().also {
        it.count = count
        it.itemDamage = meta
    }
}

fun emptyItemStack(): ItemStack = ItemStack.EMPTY

@JvmName("newItemStack")
@JvmSynthetic
fun itemStackOf() = emptyItemStack()

@JvmName("newItemStack")
@JvmOverloads
fun itemStackOf(item: Item, count: Int = 1, meta: Int = 0) =
    ItemStack(item, count, meta)

@JvmName("newItemStack")
@JvmOverloads
fun itemStackOf(block: Block, count: Int = 1, meta: Int = 0) =
    ItemStack(block, count, meta)

@JvmName("newItemStack")
fun itemStackOf(stack: ItemStack): ItemStack =
    stack.copy()

@JvmName("newItemStack")
fun itemStackOf(stack: ItemStack, count: Int) =
    stack.copy(count)

@JvmName("newItemStack")
fun itemStackOf(stack: ItemStack, count: Int, meta: Int) =
    stack.copy(count, meta)

@JvmName("newItemStack")
fun itemStackOf(nbt: NBTTagCompound?) = when {
    nbt != null -> ItemStack(nbt)
    else -> emptyItemStack()
}

private object ItemStackEquivalence : Equivalence<ItemStack>() {
    override fun doEquivalent(left: ItemStack, right: ItemStack) = when {
        left.isEmpty && right.isEmpty -> true
        left.item != right.item -> false
        !left.hasSubtypes || left.metadata == right.metadata -> {
            left.tagCompound == right.tagCompound
        }
        else -> false
    }

    override fun doHash(stack: ItemStack) = when {
        stack.isEmpty -> 0
        stack.hasSubtypes -> hashCodeOf(stack.item, stack.metadata, stack.tagCompound)
        else -> hashCodeOf(stack.item, stack.tagCompound)
    }
}
