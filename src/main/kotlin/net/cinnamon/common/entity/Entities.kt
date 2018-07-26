@file:JvmName("Entities")

package net.cinnamon.common.entity

import net.cinnamon.common.math.vecOf
import net.minecraft.block.material.Material
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.inventory.EntityEquipmentSlot.Type
import net.minecraft.item.ItemStack
import net.minecraft.network.datasync.DataParameter
import net.minecraft.network.datasync.DataSerializer
import net.minecraft.network.datasync.EntityDataManager
import net.minecraft.util.EnumHand
import net.minecraft.util.math.RayTraceResult
import kotlin.reflect.KClass

var EntityLivingBase.mainHand: ItemStack
    get() = this[EnumHand.MAIN_HAND]
    set(stack) {
        this[EnumHand.MAIN_HAND] = stack
    }

var EntityLivingBase.offHand: ItemStack
    get() = this[EnumHand.OFF_HAND]
    set(stack) {
        this[EnumHand.OFF_HAND] = stack
    }

var EntityLivingBase.headEquipment: ItemStack
    get() = this[EntityEquipmentSlot.HEAD]
    set(stack) {
        this[EntityEquipmentSlot.HEAD] = stack
    }

var EntityLivingBase.chestEquipment: ItemStack
    get() = this[EntityEquipmentSlot.CHEST]
    set(stack) {
        this[EntityEquipmentSlot.CHEST] = stack
    }

var EntityLivingBase.legsEquipment: ItemStack
    get() = this[EntityEquipmentSlot.LEGS]
    set(stack) {
        this[EntityEquipmentSlot.LEGS] = stack
    }

var EntityLivingBase.feetEquipment: ItemStack
    get() = this[EntityEquipmentSlot.FEET]
    set(stack) {
        this[EntityEquipmentSlot.FEET] = stack
    }

@JvmSynthetic
infix fun Entity.isInsideOf(material: Material) = isInsideOfMaterial(material)

fun Entity.getPosition(partialTicks: Float) = vecOf(
    lastTickPosX + (posX - lastTickPosX) * partialTicks,
    lastTickPosY + (posY - lastTickPosY) * partialTicks,
    lastTickPosZ + (posZ - lastTickPosZ) * partialTicks
)

@JvmName("getEquipmentSlot")
operator fun EntityLivingBase.get(slot: EntityEquipmentSlot): ItemStack =
    getItemStackFromSlot(slot)

@JvmName("setEquipmentSlot")
operator fun EntityLivingBase.set(slot: EntityEquipmentSlot, stack: ItemStack) =
    if (this is EntityPlayer) inventory.run {
        // Circumvent EntityPlayer#playEquipSound
        when (slot) {
            EntityEquipmentSlot.MAINHAND -> mainInventory[currentItem] = stack
            EntityEquipmentSlot.OFFHAND -> offHandInventory[0] = stack
            else -> if (slot.slotType == Type.ARMOR) {
                armorInventory[slot.index] = stack
            }
        }
    } else setItemStackToSlot(slot, stack)

@JvmName("getHandSlot")
operator fun EntityLivingBase.get(hand: EnumHand): ItemStack =
    getHeldItem(hand)

@JvmName("setHandSlot")
operator fun EntityLivingBase.set(hand: EnumHand, stack: ItemStack) =
    if (this is EntityPlayer) inventory.run {
        // Circumvent EntityPlayer#playEquipSound
        when (hand) {
            EnumHand.MAIN_HAND -> mainInventory[currentItem] = stack
            EnumHand.OFF_HAND -> offHandInventory[0] = stack
        }
    } else setHeldItem(hand, stack)

fun EntityPlayer.rayTraceLookVec(): RayTraceResult? {
    val reach = reachDistance
    val start = getPositionEyes(1.0F)
    val look = getLook(1.0F)
    val end = start.add(look.x * reach, look.y * reach, look.z * reach)
    return world.rayTraceBlocks(start, end, false, true, false)
}
