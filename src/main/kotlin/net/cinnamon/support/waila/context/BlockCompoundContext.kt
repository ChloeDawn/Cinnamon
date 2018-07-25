package net.cinnamon.support.waila.context

import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class BlockCompoundContext(
        val player: EntityPlayerMP,
        val tile: TileEntity,
        var compound: NBTTagCompound,
        val world: World,
        val pos: BlockPos
)
