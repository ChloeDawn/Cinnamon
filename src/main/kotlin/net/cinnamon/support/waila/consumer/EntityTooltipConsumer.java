package net.cinnamon.support.waila.consumer;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaEntityAccessor;
import net.minecraft.entity.Entity;
import net.cinnamon.support.waila.ContextConsumer;
import net.cinnamon.support.waila.context.EntityTooltipContext;

import java.util.List;

import static net.cinnamon.support.waila.TooltipPosition.BODY;
import static net.cinnamon.support.waila.TooltipPosition.HEAD;
import static net.cinnamon.support.waila.TooltipPosition.TAIL;

@FunctionalInterface
public interface EntityTooltipConsumer extends ContextConsumer<EntityTooltipContext> {
    @Override
    default List<String> getWailaHead(
            final Entity entity,
            final List<String> tooltip,
            final IWailaEntityAccessor accessor,
            final IWailaConfigHandler config
    ) {
        final EntityTooltipContext ctx = new EntityTooltipContext(entity, tooltip, HEAD, accessor);
        accept(ctx);
        return ctx.getTooltip();
    }

    @Override
    default List<String> getWailaBody(
            final Entity entity,
            final List<String> tooltip,
            final IWailaEntityAccessor accessor,
            final IWailaConfigHandler config
    ) {
        final EntityTooltipContext ctx = new EntityTooltipContext(entity, tooltip, BODY, accessor);
        accept(ctx);
        return ctx.getTooltip();
    }

    @Override
    default List<String> getWailaTail(
            final Entity entity,
            final List<String> tooltip,
            final IWailaEntityAccessor accessor,
            final IWailaConfigHandler config
    ) {
        final EntityTooltipContext ctx = new EntityTooltipContext(entity, tooltip, TAIL, accessor);
        accept(ctx);
        return ctx.getTooltip();
    }
}
