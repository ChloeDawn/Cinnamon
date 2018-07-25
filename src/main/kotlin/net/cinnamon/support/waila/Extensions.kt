@file:JvmName("WailaSupport")

package net.cinnamon.support.waila

import mcp.mobius.waila.api.IWailaDataProvider
import mcp.mobius.waila.api.IWailaEntityProvider
import mcp.mobius.waila.api.IWailaRegistrar
import net.cinnamon.support.waila.consumer.BlockCompoundConsumer
import net.cinnamon.support.waila.consumer.EntityCompoundConsumer
import net.cinnamon.support.waila.consumer.EntityTooltipConsumer
import net.cinnamon.support.waila.consumer.ItemTooltipConsumer
import net.cinnamon.support.waila.context.BlockCompoundContext
import net.cinnamon.support.waila.context.EntityCompoundContext
import net.cinnamon.support.waila.context.EntityContext
import net.cinnamon.support.waila.context.EntityTooltipContext
import net.cinnamon.support.waila.context.ItemContext
import net.cinnamon.support.waila.context.ItemTooltipContext
import net.cinnamon.support.waila.function.EntityFunction
import net.cinnamon.support.waila.function.ItemFunction
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import kotlin.reflect.KClass

@SafeVarargs
fun IWailaRegistrar.registerTooltip(consumer: ItemTooltipConsumer, vararg classes: Class<out Block>) =
    (consumer as IWailaDataProvider).let {
        classes.forEach { clazz ->
            registerHeadProvider(it, clazz)
            registerBodyProvider(it, clazz)
            registerTailProvider(it, clazz)
        }
    }

@SafeVarargs
fun IWailaRegistrar.registerTooltip(consumer: EntityTooltipConsumer, vararg classes: Class<out Entity>) =
    (consumer as IWailaEntityProvider).let {
        classes.forEach { clazz ->
            registerHeadProvider(it, clazz)
            registerBodyProvider(it, clazz)
            registerTailProvider(it, clazz)
        }
    }

@SafeVarargs
fun IWailaRegistrar.registerItem(function: ItemFunction, vararg classes: Class<out Block>) =
    classes.forEach { registerStackProvider(function, it) }

@SafeVarargs
fun IWailaRegistrar.registerEntity(function: EntityFunction, vararg classes: Class<out Entity>) =
    classes.forEach { registerOverrideEntityProvider(function, it) }

@SafeVarargs
fun IWailaRegistrar.registerCompound(consumer: BlockCompoundConsumer, vararg classes: Class<out Block>) =
    classes.forEach { registerNBTProvider(consumer as IWailaDataProvider, it) }

@SafeVarargs
fun IWailaRegistrar.registerCompound(consumer: EntityCompoundConsumer, vararg classes: Class<out Entity>) =
    classes.forEach { registerNBTProvider(consumer as IWailaEntityProvider, it) }

// Kt Synthetic Functions

@JvmName("registerItemTooltipKt")
@JvmSynthetic
@SafeVarargs
fun IWailaRegistrar.registerTooltip(vararg classes: KClass<out Block>, consumer: (ItemTooltipContext) -> Unit) =
    (ItemTooltipConsumer(consumer) as IWailaDataProvider).let {
        classes.forEach { clazz ->
            registerHeadProvider(it, clazz.java)
            registerBodyProvider(it, clazz.java)
            registerTailProvider(it, clazz.java)
        }
    }

@JvmName("registerEntityTooltipKt")
@JvmSynthetic
@SafeVarargs
fun IWailaRegistrar.registerTooltip(vararg classes: KClass<out Entity>, consumer: (EntityTooltipContext) -> Unit) =
    (EntityTooltipConsumer(consumer) as IWailaEntityProvider).let {
        classes.forEach { clazz ->
            registerHeadProvider(it, clazz.java)
            registerBodyProvider(it, clazz.java)
            registerTailProvider(it, clazz.java)
        }
    }

@JvmName("registerItemKt")
@JvmSynthetic
@SafeVarargs
fun IWailaRegistrar.registerItem(vararg classes: KClass<out Block>, consumer: (ItemContext) -> ItemStack) =
    classes.forEach { registerStackProvider(ItemFunction(consumer) as IWailaDataProvider, it.java) }

@JvmName("registerEntityKt")
@JvmSynthetic
@SafeVarargs
fun IWailaRegistrar.registerEntity(vararg classes: KClass<out Entity>, consumer: (EntityContext) -> Entity) =
    classes.forEach { registerOverrideEntityProvider(EntityFunction(consumer) as IWailaEntityProvider, it.java) }

@JvmName("registerBlockCompoundKt")
@JvmSynthetic
@SafeVarargs
fun IWailaRegistrar.registerCompound(vararg classes: KClass<out Block>, consumer: (BlockCompoundContext) -> Unit) =
    classes.forEach { registerNBTProvider(BlockCompoundConsumer(consumer) as IWailaDataProvider, it.java) }

@JvmName("registerEntityCompoundKt")
@JvmSynthetic
@SafeVarargs
fun IWailaRegistrar.registerCompound(vararg classes: KClass<out Entity>, consumer: (EntityCompoundContext) -> Unit) =
    classes.forEach { registerNBTProvider(EntityCompoundConsumer(consumer) as IWailaEntityProvider, it.java) }
