package net.cinnamon.support.waila.consumer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.cinnamon.support.waila.ContextConsumer;
import net.cinnamon.support.waila.context.EntityCompoundContext;

@FunctionalInterface
public interface EntityCompoundConsumer extends ContextConsumer<EntityCompoundContext> {
    @Override
    default NBTTagCompound getNBTData(
            final EntityPlayerMP player,
            final Entity entity,
            final NBTTagCompound compound,
            final World world
    ) {
        final EntityCompoundContext ctx = new EntityCompoundContext(player, entity, compound, world);
        accept(ctx);
        return ctx.getCompound();
    }
}
