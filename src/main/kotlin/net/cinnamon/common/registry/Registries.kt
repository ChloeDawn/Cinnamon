@file:JvmName("Registries")

package net.cinnamon.common.registry

import net.cinnamon.common.base.resourceLocationOf
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantment
import net.minecraft.item.Item
import net.minecraft.item.crafting.IRecipe
import net.minecraft.potion.Potion
import net.minecraft.potion.PotionType
import net.minecraft.util.ResourceLocation
import net.minecraft.util.SoundEvent
import net.minecraft.world.biome.Biome
import net.minecraftforge.fml.common.registry.EntityEntry
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession
import net.minecraftforge.registries.RegistryManager
import kotlin.reflect.KClass
import net.minecraftforge.registries.IForgeRegistry as Registry
import net.minecraftforge.registries.IForgeRegistryEntry as Entry

val blockRegistry: Registry<Block>
    get() = ForgeRegistries.BLOCKS

val itemRegistry: Registry<Item>
    get() = ForgeRegistries.ITEMS

val potionRegistry: Registry<Potion>
    get() = ForgeRegistries.POTIONS

val biomeRegistry: Registry<Biome>
    get() = ForgeRegistries.BIOMES

val soundEventRegistry: Registry<SoundEvent>
    get() = ForgeRegistries.SOUND_EVENTS

val potionTypeRegistry: Registry<PotionType>
    get() = ForgeRegistries.POTION_TYPES

val enchantmentRegistry: Registry<Enchantment>
    get() = ForgeRegistries.ENCHANTMENTS

val villagerProfessionRegistry: Registry<VillagerProfession>
    get() = ForgeRegistries.VILLAGER_PROFESSIONS

val entityRegistry: Registry<EntityEntry>
    get() = ForgeRegistries.ENTITIES

val recipeRegistry: Registry<IRecipe>
    get() = ForgeRegistries.RECIPES

val <V : Entry<V>> Registry<V>.isVanilla: Boolean
    get() = RegistryManager.VANILLA.getName(this) != null

val <V : Entry<V>> Registry<V>.registryName: ResourceLocation
    get() = RegistryManager.VANILLA.getName(this) ?: checkNotNull(RegistryManager.ACTIVE.getName(this)) {
        "Cannot get registry name for an unregistered IForgeRegistry"
    }

/**
 * Synchronized lazy registry lookup for property delegates
 * Will be `null` if no registry is present when initialized
 */
@JvmSynthetic
fun <V : Entry<V>> registry(type: KClass<V>): Lazy<Registry<V>?> {
    return lazy { registryOf(type.java) }
}

/**
 * Looks up the registry for the given entry type
 * Returns `null` if no registry is present
 */
@JvmName("getRegistry")
fun <V : Entry<V>> registryOf(type: Class<V>): Registry<V>? {
    return GameRegistry.findRegistry(type)
}

/**
 * Looks up the registry for the given entry type
 * Returns `null` if no registry is present
 */
@JvmSynthetic
@JvmName("getRegistry")
fun <V : Entry<V>> registryOf(type: KClass<V>): Registry<V>? {
    return registryOf(type.java)
}

@JvmName("retrieve")
operator fun <V : Entry<V>> Registry<V>.get(name: ResourceLocation): V {
    check(name in this) { "\"$name\" does not exist in $this" }
    return getValue(name)!!
}

@JvmName("retrieve")
operator fun <V : Entry<V>> Registry<V>.get(name: String): V =
    resourceLocationOf(name).let {
        check(it in this) { "\"$it\" does not exist in $this" }
        return getValue(it)!!
    }

@JvmName("register")
operator fun <V : Entry<V>> Registry<V>.set(name: ResourceLocation, entry: V) =
    register(entry.setNameIfAbsent(name))

@JvmName("register")
operator fun <V : Entry<V>> Registry<V>.set(name: String, entry: V) =
    register(entry.setNameIfAbsent(name))

@JvmName("register")
operator fun <V : Entry<V>> Registry<V>.plusAssign(entry: V) =
    register(entry)

operator fun <V : Entry<V>> Registry<V>.contains(entry: V) =
    containsValue(entry)

operator fun <V : Entry<V>> Registry<V>.contains(name: ResourceLocation) =
    containsKey(name)

operator fun <V : Entry<V>> Registry<V>.contains(name: String) =
    containsKey(resourceLocationOf(name))
