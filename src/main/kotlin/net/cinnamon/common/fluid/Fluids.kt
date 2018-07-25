@file:JvmName("Fluids")

package net.cinnamon.common.fluid

import net.cinnamon.common.base.ModContainers
import net.minecraft.item.EnumRarity
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.ResourceLocation
import net.minecraft.util.SoundEvent
import net.minecraftforge.fluids.Fluid
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fluids.FluidStack
import java.awt.Color

private val stillSpriteGetter = { name: String ->
    ResourceLocation(ModContainers.activeModId, "textures/fluid/${name}_still")
}

private val flowingSpriteGetter = { name: String ->
    ResourceLocation(ModContainers.activeModId, "textures/fluid/${name}_flowing")
}

const val BUCKET_VOLUME = 1000
const val BOTTLE_VOLUME = BUCKET_VOLUME / 3

val FluidStack?.isEmpty get() = this == null

val FluidStack?.isNotEmpty get() = this != null

val Fluid.isRegistered: Boolean get() = FluidRegistry.isFluidRegistered(this)

val Fluid.isDefault: Boolean get() = FluidRegistry.isFluidDefault(this)

val FluidStack.registryName: ResourceLocation? get() = fluid.registryName

val Fluid.registryName: ResourceLocation?
    get() = if (isRegistered) {
        ResourceLocation(FluidRegistry.getDefaultFluidName(this))
    } else null

val FluidStack.doesVaporize: Boolean get() = fluid.doesVaporize(this)

val FluidStack.luminosity: Int get() = fluid.getLuminosity(this)

val FluidStack.density: Int get() = fluid.getDensity(this)

val FluidStack.temperature: Int get() = fluid.getTemperature(this)

val FluidStack.viscosity: Int get() = fluid.getViscosity(this)

val FluidStack.isGaseous: Boolean get() = fluid.isGaseous(this)

val FluidStack.rarity: EnumRarity get() = fluid.getRarity(this)

val FluidStack.color: Int get() = fluid.getColor(this)

val FluidStack.still: ResourceLocation get() = fluid.getStill(this)

val FluidStack.flowing: ResourceLocation get() = fluid.getFlowing(this)

val FluidStack.fillSound: SoundEvent get() = fluid.getFillSound(this)

val FluidStack.emptySound: SoundEvent get() = fluid.getEmptySound(this)

fun emptyFluidStack(): FluidStack? = null

@JvmName("newFluidStack")
@JvmSynthetic
fun fluidStackOf(): FluidStack? = null

@JvmName("newFluidStack")
@JvmOverloads
fun fluidStackOf(fluid: Fluid, amount: Int = BUCKET_VOLUME) =
    FluidStack(fluid, amount)

@JvmName("newFluidStack")
fun fluidStackOf(fluid: Fluid, nbt: NBTTagCompound) =
    FluidStack(fluid, BUCKET_VOLUME, nbt)

@JvmName("newFluidStack")
fun fluidStackOf(fluid: Fluid, amount: Int, nbt: NBTTagCompound) =
    FluidStack(fluid, amount, nbt)

@JvmName("newFluidStack")
fun fluidStackOf(nbt: NBTTagCompound) =
    FluidStack.loadFluidStackFromNBT(nbt)

@JvmName("newFluidStack")
@JvmOverloads
fun fluidStackOf(fluid: FluidStack, amount: Int = BUCKET_VOLUME) =
    FluidStack(fluid, amount)

@JvmName("newFluid")
fun fluidOf(name: String) =
    Fluid(name, stillSpriteGetter(name), flowingSpriteGetter(name))

@JvmName("newFluid")
fun fluidOf(name: String, color: Int) =
    Fluid(name, stillSpriteGetter(name), flowingSpriteGetter(name), color)

@JvmName("newFluid")
fun fluidOf(name: String, color: Color) =
    Fluid(name, stillSpriteGetter(name), flowingSpriteGetter(name), color)

@JvmName("newFluid")
fun fluidOf(name: String, still: ResourceLocation, flowing: ResourceLocation) =
    Fluid(name, still, flowing)

@JvmName("newFluid")
fun fluidOf(name: String, still: ResourceLocation, flowing: ResourceLocation, color: Int) =
    Fluid(name, still, flowing, color)

@JvmName("newFluid")
fun fluidOf(name: String, still: ResourceLocation, flowing: ResourceLocation, color: Color) =
    Fluid(name, still, flowing, color)
