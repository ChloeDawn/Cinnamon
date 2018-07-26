@file:JvmName("Capabilities")

package net.cinnamon.common.capability

import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilityProvider
import net.minecraftforge.energy.IEnergyStorage
import net.minecraftforge.fluids.capability.IFluidHandler
import net.minecraftforge.fluids.capability.IFluidHandlerItem
import net.minecraftforge.items.IItemHandler

@CapabilityInject(IItemHandler::class)
lateinit var itemCapability: Capability<IItemHandler>
    private set

@CapabilityInject(IFluidHandler::class)
lateinit var fluidCapability: Capability<IFluidHandler>
    private set

@CapabilityInject(IFluidHandlerItem::class)
lateinit var fluidItemCapability: Capability<IFluidHandlerItem>
    private set

@CapabilityInject(IEnergyStorage::class)
lateinit var energyCapability: Capability<IEnergyStorage>
    private set

@JvmSynthetic
operator fun <T> ICapabilityProvider.get(capability: Capability<T>, side: EnumFacing? = null): T? =
    getCapability(capability, side)

@JvmSynthetic
operator fun <T> ICapabilityProvider.contains(capability: Capability<T>) =
    hasCapability(capability, null)

@JvmSynthetic
infix fun <T> ICapabilityProvider.has(capability: Capability<T>) =
    hasCapability(capability, null)

@JvmSynthetic
fun <T> ICapabilityProvider.has(capability: Capability<T>, side: EnumFacing?) =
    hasCapability(capability, side)

@JvmSynthetic
infix fun <T> Capability<T>.from(provider: ICapabilityProvider): T? =
    provider.getCapability(this, null)

@JvmSynthetic
fun <T> Capability<T>.from(provider: ICapabilityProvider, side: EnumFacing?): T? =
    provider.getCapability(this, side)
