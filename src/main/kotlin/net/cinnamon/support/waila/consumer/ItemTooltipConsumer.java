package net.cinnamon.support.waila.consumer;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.item.ItemStack;
import net.cinnamon.support.waila.context.ItemTooltipContext;
import net.cinnamon.support.waila.ContextConsumer;

import java.util.List;

import static net.cinnamon.support.waila.TooltipPosition.BODY;
import static net.cinnamon.support.waila.TooltipPosition.HEAD;
import static net.cinnamon.support.waila.TooltipPosition.TAIL;

@FunctionalInterface
public interface ItemTooltipConsumer extends ContextConsumer<ItemTooltipContext> {
    @Override
    default List<String> getWailaHead(
            final ItemStack stack,
            final List<String> tooltip,
            final IWailaDataAccessor accessor,
            final IWailaConfigHandler config
    ) {
        final ItemTooltipContext ctx = new ItemTooltipContext(stack, tooltip, HEAD, accessor);
        accept(ctx);
        return ctx.getTooltip();
    }

    @Override
    default List<String> getWailaBody(
            final ItemStack stack,
            final List<String> tooltip,
            final IWailaDataAccessor accessor,
            final IWailaConfigHandler config
    ) {
        final ItemTooltipContext ctx = new ItemTooltipContext(stack, tooltip, BODY, accessor);
        accept(ctx);
        return ctx.getTooltip();
    }

    @Override
    default List<String> getWailaTail(
            final ItemStack stack,
            final List<String> tooltip,
            final IWailaDataAccessor accessor,
            final IWailaConfigHandler config
    ) {
        final ItemTooltipContext ctx = new ItemTooltipContext(stack, tooltip, TAIL, accessor);
        accept(ctx);
        return ctx.getTooltip();
    }
}
