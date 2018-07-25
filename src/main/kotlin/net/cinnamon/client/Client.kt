@file:JvmName("Client")
@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.client

import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.client.renderer.texture.TextureMap
import net.minecraft.init.Blocks
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.client.FMLClientHandler
import net.minecraftforge.fml.relauncher.Side.CLIENT
import net.minecraftforge.fml.relauncher.SideOnly
import java.util.UUID

inline val BlockRenderLayer.isSolid
    @JvmSynthetic
    get() = BlockRenderLayer.SOLID == this

inline val BlockRenderLayer.isCutoutMipped
    @JvmSynthetic
    get() = BlockRenderLayer.CUTOUT_MIPPED == this

inline val BlockRenderLayer.isCutout
    @JvmSynthetic
    get() = BlockRenderLayer.CUTOUT == this

inline val BlockRenderLayer.isTranslucent
    @JvmSynthetic
    get() = BlockRenderLayer.TRANSLUCENT == this

@JvmSynthetic
@SideOnly(CLIENT)
inline operator fun TextureMap.get(sprite: String): TextureAtlasSprite =
    getAtlasSprite(sprite)

@JvmSynthetic
@SideOnly(CLIENT)
inline operator fun TextureMap.get(sprite: ResourceLocation) =
    get(sprite.toString())

val client: Minecraft
    @JvmName("getInstance")
    @SideOnly(CLIENT)
    get() = FMLClientHandler.instance().client

val clientUUID: UUID
    @JvmName("getUUID")
    @SideOnly(CLIENT)
    get() = client.session.profile.id

val isFancyGraphics: Boolean
    get() = !Blocks.LEAVES.defaultState.isOpaqueCube
