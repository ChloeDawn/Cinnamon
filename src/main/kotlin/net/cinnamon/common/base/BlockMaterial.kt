package net.cinnamon.common.base

import net.minecraft.block.SoundType
import net.minecraft.block.material.MapColor
import net.minecraft.block.material.Material
import net.minecraft.util.IStringSerializable
import java.util.Locale

enum class BlockMaterial(
    val material: Material,
    val sound: SoundType,
    val hardness: Float,
    val resistance: Float
) : IStringSerializable {
    CARPET    ( Material.CARPET,   SoundType.CLOTH,  0.1F, 0.5F  ),
    CIRCUITS  ( Material.CIRCUITS, SoundType.STONE,  0.0F, 0.0F  ),
    CLOTH     ( Material.CLOTH,    SoundType.CLOTH,  0.8F, 4.0F  ),
    GLASS     ( Material.GLASS,    SoundType.GLASS,  0.3F, 1.5F  ),
    GLOWSTONE ( Material.GLASS,    SoundType.GLASS,  0.3F, 1.5F  ),
    GRASS     ( Material.GRASS,    SoundType.PLANT,  0.6F, 3.0F  ),
    GROUND    ( Material.GROUND,   SoundType.GROUND, 0.5F, 2.5F  ),
    ICE       ( Material.ICE,      SoundType.GLASS,  0.5F, 2.5F  ),
    LADDER    ( Material.WOOD,     SoundType.LADDER, 0.4F, 2.0F  ),
    LEAVES    ( Material.LEAVES,   SoundType.PLANT,  0.2F, 1.0F  ),
    METAL     ( Material.IRON,     SoundType.METAL,  5.0F, 30.0F ),
    PLANT     ( Material.PLANTS,   SoundType.PLANT,  0.0F, 0.0F  ),
    QUARTZ    ( Material.ROCK,     SoundType.STONE,  0.8F, 4.0F  ),
    ROCK      ( Material.ROCK,     SoundType.STONE,  1.5F, 30.0F ),
    SAND      ( Material.SAND,     SoundType.SAND,   0.5F, 2.5F  ),
    SNOW      ( Material.SNOW,     SoundType.SNOW,   0.2F, 1.0F  ),
    VINE      ( Material.VINE,     SoundType.PLANT,  0.2F, 1.0F  ),
    WOOD      ( Material.WOOD,     SoundType.WOOD,   2.0F, 15.0F );

    val mapColor: MapColor = material.materialMapColor

    override fun getName() = name.toLowerCase(Locale.ROOT)

    companion object {
        private val VALUES = values()

        @JvmStatic
        @JvmName("valueOf")
        operator fun get(ordinal: Int) = VALUES[ordinal]
    }
}
