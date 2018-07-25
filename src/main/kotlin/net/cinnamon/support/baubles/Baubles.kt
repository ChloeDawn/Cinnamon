@file:JvmName("Baubles")

package net.cinnamon.support.baubles

import baubles.api.IBauble
import baubles.api.cap.IBaublesItemHandler
import net.cinnamon.common.Cinnamon
import net.cinnamon.common.capability.get
import net.cinnamon.common.capability.indexOf
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import java.util.Optional

var baublesItemCapability: Capability<IBauble>? = null
    @CapabilityInject(IBauble::class)
    private set(capability) {
        Cinnamon.debug("Initializing IBauble capability instance with $capability")
        field = capability
    }

var baublesCapability: Capability<IBaublesItemHandler>? = null
    @CapabilityInject(IBaublesItemHandler::class)
    private set(capability) {
        Cinnamon.debug("Initializing IBaublesItemHandler capability instance with $capability")
        field = capability
    }

val EntityPlayer.baublesInventory: Optional<IBaublesItemHandler>
    get() = try {
        Optional.ofNullable(baublesCapability?.let { cap ->
            this[cap]?.also { it.setPlayer(this) }
        })
    } catch (exception: Exception) {
        Optional.empty()
    }

val ItemStack.bauble: Optional<IBauble>
    get() = try {
        Optional.ofNullable(baublesItemCapability?.let { this[it] })
    } catch (exception: Exception) {
        Optional.empty()
    }

fun EntityPlayer.getSlotForBauble(item: Item) = try {
    baublesCapability?.let { this[it]?.indexOf(item) } ?: -1
} catch (exception: Exception) {
    -1
}

fun EntityPlayer.getSlotForBauble(stack: ItemStack) = try {
    baublesCapability?.let { this[it]?.indexOf(stack) } ?: -1
} catch (exception: Exception) {
    -1
}

fun EntityPlayer.hasBauble(item: Item) =
    getSlotForBauble(item) >= 0

fun EntityPlayer.hasBauble(stack: ItemStack) =
    getSlotForBauble(stack) >= 0
