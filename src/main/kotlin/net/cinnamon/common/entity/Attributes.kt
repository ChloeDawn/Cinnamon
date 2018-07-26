@file:JvmName("Attributes")

package net.cinnamon.common.entity

import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.SharedMonsterAttributes as Attr

val EntityPlayer.attackDamage
    get() = getEntityAttribute(Attr.ATTACK_DAMAGE).attributeValue

val EntityPlayer.attackSpeed
    get() = getEntityAttribute(Attr.ATTACK_SPEED).attributeValue

val EntityPlayer.reachDistance
    get() = getEntityAttribute(EntityPlayer.REACH_DISTANCE).attributeValue

val EntityLivingBase.knockbackResistance
    get() = getEntityAttribute(Attr.KNOCKBACK_RESISTANCE).attributeValue

val EntityLivingBase.movementSpeed
    get() = getEntityAttribute(Attr.MOVEMENT_SPEED).attributeValue

val EntityLivingBase.armorValue
    get() = getEntityAttribute(Attr.ARMOR).attributeValue

val EntityLivingBase.armorToughnessValue
    get() = getEntityAttribute(Attr.ARMOR_TOUGHNESS).attributeValue
