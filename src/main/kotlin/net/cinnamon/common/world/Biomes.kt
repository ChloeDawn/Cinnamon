@file:JvmName("Biomes")

package net.cinnamon.common.world

import net.cinnamon.common.registry.biomeRegistry
import net.cinnamon.common.registry.get
import net.minecraft.util.ResourceLocation
import net.minecraft.world.biome.Biome
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeDictionary.Type

val Biome.id: Int get() = Biome.getIdForBiome(this)

val Biome.types: Set<Type> get() = BiomeDictionary.getTypes(this)

val Type.biomes: Set<Biome> get() = BiomeDictionary.getBiomes(this)

@JvmName("areSimilar")
infix fun Biome.isSimilarTo(other: Biome) = BiomeDictionary.areSimilar(this, other)

@JvmName("hasType")
operator fun Biome.contains(type: Type) = BiomeDictionary.hasType(this, type)

fun Biome.addTypes(vararg types: Type) = BiomeDictionary.addTypes(this, *types)

@JvmSynthetic
operator fun Biome.plusAssign(type: Type) = BiomeDictionary.addTypes(this, type)

@JvmName("getBiome")
fun biome(id: Int): Biome? = Biome.getBiome(id)

@JvmName("getBiome")
fun biome(name: ResourceLocation): Biome? = biomeRegistry[name]

@JvmName("getBiome")
fun biome(name: String): Biome? = biomeRegistry[name]
