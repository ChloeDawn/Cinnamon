@file:JvmName("Inventories")

package net.cinnamon.common.item

import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack

inline val IInventory.size
    @JvmSynthetic
    get() = sizeInventory

@JvmName("getStack")
operator fun IInventory.get(slot: Int): ItemStack =
    getStackInSlot(slot)

@JvmName("setStack")
operator fun IInventory.set(slot: Int, stack: ItemStack) =
    setInventorySlotContents(slot, stack)

@JvmName("addStack")
operator fun InventoryPlayer.plusAssign(stack: ItemStack) {
    addItemStackToInventory(stack)
}

@JvmName("removeStack")
operator fun InventoryPlayer.minusAssign(stack: ItemStack) {
    deleteStack(stack)
}

@JvmName("hasStack")
operator fun InventoryPlayer.contains(stack: ItemStack) =
    hasItemStack(stack)
