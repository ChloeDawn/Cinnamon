@file:JvmName("ResourceLocations")

package net.cinnamon.common.base

import net.cinnamon.common.registry.name
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.util.ResourceLocation
import net.minecraftforge.registries.IForgeRegistryEntry

@JvmField val BUILTIN_MISSING = ModelResourceLocation("builtin/missing", "missing")
@JvmField val MISSINGNO = ModelResourceLocation("missingno")

fun ResourceLocation.withVariant(variant: String) =
    ModelResourceLocation(this, variant)

@JvmName("newResourceLocation")
fun resourceLocationOf(name: String) =
    ResourceLocation(name)

@JvmName("newResourceLocation")
fun resourceLocationOf(entry: IForgeRegistryEntry<*>) =
    entry.name

@JvmName("newResourceLocation")
fun resourceLocationOf(namespace: String, path: String) =
    ResourceLocation(namespace, path)

@JvmName("newModelResourceLocation")
@JvmOverloads
fun modelResourceLocationOf(entry: IForgeRegistryEntry<*>, variant: String = "inventory") =
    ModelResourceLocation(entry.name, variant)

@JvmName("newModelResourceLocation")
@JvmOverloads
fun modelResourceLocationOf(name: String, variant: String = "inventory") =
    ModelResourceLocation(ResourceLocation(name), variant)

@JvmName("newModelResourceLocation")
@JvmOverloads
fun modelResourceLocationOf(name: ResourceLocation, variant: String = "inventory") =
    ModelResourceLocation(name, variant)

@JvmName("newModelResourceLocation")
fun modelResourceLocationOf(namespace: String, path: String, variant: String = "inventory") =
    ModelResourceLocation(ResourceLocation(namespace, path), variant)
