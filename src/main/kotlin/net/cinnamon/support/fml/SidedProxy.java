package net.cinnamon.support.fml;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.function.Supplier;

/**
 * The IDE seems to have trouble handling the nested generics when providing
 * a generated Java method from a Kotlin function, so this Java class was created
 * to provide basic inter-op using an actual Java-written SidedProxy method.
 */
public final class SidedProxy {
    private SidedProxy() {}

    public static <V, CLIENT extends V, SERVER extends V> V of(
        final Supplier<Supplier<CLIENT>> client,
        final Supplier<Supplier<SERVER>> server
    ) {
        final Side side = FMLCommonHandler.instance().getSide();
        switch (side) {
            case CLIENT: return client.get().get();
            case SERVER: return server.get().get();
            default: throw new IllegalStateException("Invalid side \"" + side + "\"");
        }
    }
}
