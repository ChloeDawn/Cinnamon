package net.cinnamon.support.waila.consumer;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.cinnamon.support.waila.context.BlockCompoundContext;
import net.cinnamon.support.waila.ContextConsumer;

@FunctionalInterface
public interface BlockCompoundConsumer extends ContextConsumer<BlockCompoundContext> {
    @Override
    default NBTTagCompound getNBTData(
            final EntityPlayerMP player,
            final TileEntity tile,
            final NBTTagCompound compound,
            final World world,
            final BlockPos pos
    ) {
        final BlockCompoundContext ctx = new BlockCompoundContext(player, tile, compound, world, pos);
        accept(ctx);
        return ctx.getCompound();
    }
}
