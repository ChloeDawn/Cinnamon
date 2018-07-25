@file:JvmName("RegistryEntries")

package net.cinnamon.common.registry

import net.cinnamon.common.base.resourceLocationOf
import net.minecraft.util.ResourceLocation
import net.minecraftforge.registries.IForgeRegistryEntry as Entry

val Entry<*>.name get() = checkNotNull(registryName) { "Registry entry is missing a registry name" }

fun Entry<*>.hasRegistryName() = registryName != null

fun <V : Entry<V>> V.setNameIfAbsent(name: ResourceLocation) = also {
    if (!hasRegistryName()) registryName = name
}

fun <V : Entry<V>> V.setNameIfAbsent(domain: String, path: String) =
    setNameIfAbsent(resourceLocationOf(domain, path))

fun <V : Entry<V>> V.setNameIfAbsent(name: String) =
    setNameIfAbsent(resourceLocationOf(name))
