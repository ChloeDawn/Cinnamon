@file:JvmName("BlockStates")
@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.common.block

import net.minecraft.block.Block
import net.minecraft.block.properties.IProperty
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Mirror
import net.minecraft.util.Rotation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraftforge.common.property.ExtendedBlockState
import net.minecraftforge.common.property.IExtendedBlockState
import net.minecraftforge.common.property.IUnlistedProperty
import java.util.function.Consumer

/**
 * Gets the unique [Int] ID of the receiver, using its metadata and [Block] ID
 * @return The unique ID of the receiver
 * @author InsomniaKitten
 * @since 1.0.0
 */
val IBlockState.id: Int get() = Block.getStateId(this)

/**
 * Simplified accessor for [net.minecraft.block.Block.getExtendedState] with safe casting
 * @return An [IExtendedBlockState] instance, or `null` if the received [IBlockState] cannot be cast
 * @author InsomniaKitten
 * @since 1.0.0
 */
fun IBlockState.getExtendedState(access: IBlockAccess, pos: BlockPos) =
    block.getExtendedState(this, access, pos) as? IExtendedBlockState

/**
 * Helper function to determine if the given [stack] is an effective tool for the receiver
 * @return True for any match for [Block.isToolEffective] when iterating [Item.getToolClasses]
 * @author InsomniaKitten
 * @since 1.0.0
 */
fun IBlockState.isToolEffective(stack: ItemStack) =
    stack.item.getToolClasses(stack).any {
        block.isToolEffective(it, this)
    }

/**
 * Simplified accessor for [IBlockState.getActualState]
 * This extension function exists purely to provide invocation syntax in Kotlin
 * @return The actual state of the receiver
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
operator fun IBlockState.invoke(access: IBlockAccess, pos: BlockPos): IBlockState =
    getActualState(access, pos)

/**
 * Simplified property value accessor
 * This extension function exists purely to provide array access syntax in Kotlin
 * @return The value of the given [property] within the receiver
 * @throws IllegalArgumentException If the [property] does not exist within the receiver
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
operator fun <V : Comparable<V>> IBlockState.get(property: IProperty<V>): V =
    getValue(property)

/**
 * Simplified accessor for [IBlockState.withProperty]
 * This extension function exists purely to provide `+`/`+=` addition syntax in Kotlin
 * @return An [IBlockState] instance containing the given [entry]
 * @throws IllegalArgumentException If the [entry] [IProperty] does not exist within the receiver
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
operator fun <V : Comparable<V>> IBlockState.plus(entry: Pair<IProperty<V>, V>): IBlockState =
    withProperty(entry.first, entry.second)

/**
 * Simplified accessor for [IBlockState.withProperty]
 * This extension function exists purely for use as a short-hand alternative in Kotlin
 * @return An [IBlockState] instance containing the given [property] and [value]
 * @throws IllegalArgumentException If the [property] does not exist within the receiver
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
fun <V : Comparable<V>> IBlockState.with(property: IProperty<V>, value: V): IBlockState =
    withProperty(property, value)

/**
 * Simplified accessor for [IBlockState.withProperty]
 * If avoiding infix usage, use the function defined above, as it does not require a [Pair]
 * This extension function exists purely for use as a short-hand alternative in Kotlin
 * @return An [IBlockState] instance containing the given [entry]
 * @throws IllegalArgumentException If the [entry] [IProperty] does not exist within the receiver
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
infix fun <V : Comparable<V>> IBlockState.with(entry: Pair<IProperty<V>, V>): IBlockState =
    withProperty(entry.first, entry.second)

/**
 * Simplified accessor for [IBlockState.cycleProperty]
 * This extension function exists purely for use as a short-hand alternative in Kotlin
 * @return An [IBlockState] instance with the [property] cycled to the next value
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
infix fun <V : Comparable<V>> IBlockState.cycle(property: IProperty<V>): IBlockState =
    cycleProperty(property)

/**
 * Simplified accessor for [IBlockState.withRotation]
 * This extension function exists purely for use as a short-hand alternative in Kotlin
 * @return An [IBlockState] instance with [rotation] applied from [IBlockState.withRotation]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
infix fun <V : Comparable<V>> IBlockState.rotate(rotation: Rotation): IBlockState =
    withRotation(rotation)

/**
 * Simplified accessor for [IBlockState.withMirror]
 * This extension function exists purely for use as a short-hand alternative in Kotlin
 * @return An [IBlockState] instance with [mirror] applied from [IBlockState.withMirror]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
infix fun <V : Comparable<V>> IBlockState.mirror(mirror: Mirror): IBlockState =
    withMirror(mirror)

/**
 * Factory method for creating a new [BlockStateContainer]
 * @return A [BlockStateContainer] instance for the given [block]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmName("newContainer")
fun stateContainerOf(block: Block) =
    BlockStateContainer(block)

/**
 * Factory method for creating a new [BlockStateContainer]
 * @return A [BlockStateContainer] instance for the given [block] and [properties]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmName("newContainer")
fun stateContainerOf(block: Block, vararg properties: IProperty<*>) =
    BlockStateContainer(block, *properties)

/**
 * Factory method for creating a new [BlockStateContainer]
 * @return A [BlockStateContainer] instance for the given [block] and [properties]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmName("newContainer")
fun stateContainerOf(block: Block, vararg properties: IUnlistedProperty<*>) =
    ExtendedBlockState(block, emptyArray(), properties)

/**
 * Factory method for creating a new [BlockStateContainer]
 * @return A [BlockStateContainer] instance for the given [block], [properties], and [unlistedProperties]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmName("newContainer")
fun stateContainerOf(block: Block, properties: Array<IProperty<*>>, unlistedProperties: Array<IUnlistedProperty<*>>) =
    if (unlistedProperties.isNotEmpty()) {
        ExtendedBlockState(block, properties, unlistedProperties)
    } else BlockStateContainer(block, *properties)

/**
 * Factory method for creating a new [BlockStateContainer]
 * Constructs a [BlockStateContainer] for the [block], then runs the [action] on the builder instance
 * @return A [BlockStateContainer] instance for the given [block], with values applied from the [action]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmName("newContainer")
@JvmSynthetic
fun stateContainerOf(block: Block, action: (BlockStateContainer.Builder) -> Unit): BlockStateContainer =
    BlockStateContainer.Builder(block).apply(action).build()

/**
 * Factory method for creating a new [BlockStateContainer]
 * Constructs a [BlockStateContainer] for the [block], then runs the [action] on the builder instance
 * @return A [BlockStateContainer] instance for the given [block], with values applied from the [action]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmName("newContainer")
fun stateContainerOf(block: Block, action: Consumer<BlockStateContainer.Builder>): BlockStateContainer =
    BlockStateContainer.Builder(block).also(action::accept).build()

/**
 * Kotlin helper function for use as a method reference
 * This helper exists as the existing Java vararg functions
 * cannot be used for method references in Kotlin.
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
inline fun BlockStateContainer.Builder.add(property: IProperty<*>) {
    add(property)
}

/**
 * Kotlin helper function for use as a method reference
 * This helper exists as the existing Java vararg functions
 * cannot be used for method references in Kotlin.
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
inline fun BlockStateContainer.Builder.add(property: IUnlistedProperty<*>) {
    add(property)
}
