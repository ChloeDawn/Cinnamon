package net.cinnamon.support.waila.function;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaEntityAccessor;
import net.minecraft.entity.Entity;
import net.cinnamon.support.waila.ContextFunction;
import net.cinnamon.support.waila.context.EntityContext;

import javax.annotation.Nullable;

@FunctionalInterface
public interface EntityFunction extends ContextFunction<EntityContext, Entity> {
    @Override
    @Nullable
    default Entity getWailaOverride(
            final IWailaEntityAccessor accessor,
            final IWailaConfigHandler config
    ) {
        return apply(new EntityContext(accessor));
    }
}
