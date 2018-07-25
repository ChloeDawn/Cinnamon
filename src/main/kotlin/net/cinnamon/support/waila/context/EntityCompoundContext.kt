package net.cinnamon.support.waila.context

import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World

class EntityCompoundContext(
        val player: EntityPlayerMP,
        val entity: Entity,
        var compound: NBTTagCompound,
        val world: World
)
