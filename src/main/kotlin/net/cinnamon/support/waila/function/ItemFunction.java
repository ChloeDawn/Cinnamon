package net.cinnamon.support.waila.function;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.item.ItemStack;
import net.cinnamon.support.waila.ContextFunction;
import net.cinnamon.support.waila.context.ItemContext;

@FunctionalInterface
public interface ItemFunction extends ContextFunction<ItemContext, ItemStack> {
    @Override
    default ItemStack getWailaStack(
            final IWailaDataAccessor accessor,
            final IWailaConfigHandler config
    ) {
        return apply(new ItemContext(accessor));
    }
}
