@file:JvmName("SidedProxyKt")

package net.cinnamon.support.fml

import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.relauncher.Side

@JvmSynthetic
@Suppress("NOTHING_TO_INLINE")
inline fun <V, CLIENT : V, SERVER : V> sidedProxy(
    noinline client: () -> CLIENT,
    noinline server: () -> SERVER
) = when (FMLCommonHandler.instance().side!!) {
    Side.CLIENT -> ({ client })()()
    Side.SERVER -> ({ server })()()
}
