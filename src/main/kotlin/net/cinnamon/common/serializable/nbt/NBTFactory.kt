@file:JvmName("NBTFactory")

package net.cinnamon.common.serializable.nbt

import com.mojang.authlib.GameProfile
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import java.util.UUID
import java.util.function.Consumer

@DslMarker
private annotation class NBTDslMarker

/**
 * A factory method for creating an [NBTTagCompound]. The consumer function parameter is
 * applied to a [TagCompoundFactory], which delegates all calls to an [NBTTagCompound]
 * @return An [NBTTagCompound] instance with the factory changes applied
 * @author InsomniaKitten
 * @since 0.1.0
 */
@NBTDslMarker
@JvmName("createTagCompound")
@JvmSynthetic
fun tagCompound(compound: TagCompoundFactory.() -> Unit) {
    tagCompoundOf().also { compound.invoke(TagCompoundFactory(it)) }
}

/**
 * A factory method for creating an [NBTTagCompound]. The consumer function parameter is
 * applied to a [TagCompoundFactory], which delegates all calls to an [NBTTagCompound]
 * @return An [NBTTagCompound] instance with the factory changes applied
 * @author InsomniaKitten
 * @since 0.1.0
 */
@NBTDslMarker
@JvmName("createTagCompound")
fun tagCompound(compound: Consumer<TagCompoundFactory>) {
    tagCompoundOf().also { compound.accept(TagCompoundFactory(it)) }
}

@Suppress("NOTHING_TO_INLINE")
class TagCompoundFactory(private val compound: NBTTagCompound) {
    /**
     * Appends the given [NBTBase] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: NBTBase) = compound.setTag(this, value)

    /**
     * Appends the given [NBTBase] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: NBTBase) = this(value)

    /**
     * Appends the given [NBTBase] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: NBTBase) = this(value)

    /**
     * Appends the given [Byte] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Byte) = compound.setByte(this, value)

    /**
     * Appends the given [Byte] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Byte) = this(value)

    /**
     * Appends the given [Byte] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Byte) = this(value)

    /**
     * Appends the given [Short] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Short) = compound.setShort(this, value)

    /**
     * Appends the given [Short] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Short) = this(value)

    /**
     * Appends the given [Short] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Short) = this(value)

    /**
     * Appends the given [Int] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Int) = compound.setInteger(this, value)

    /**
     * Appends the given [Int] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Int) = this(value)

    /**
     * Appends the given [Int] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Int) = this(value)

    /**
     * Appends the given [Long] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Long) = compound.setLong(this, value)

    /**
     * Appends the given [Long] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Long) = this(value)

    /**
     * Appends the given [Long] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Long) = this(value)

    /**
     * Appends the given [UUID] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: UUID) = compound.setUniqueId(this, value)

    /**
     * Appends the given [UUID] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: UUID) = this(value)

    /**
     * Appends the given [UUID] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: UUID) = this(value)

    /**
     * Appends the given [Float] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Float) = compound.setFloat(this, value)

    /**
     * Appends the given [Float] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Float) = this(value)

    /**
     * Appends the given [Float] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Float) = this(value)

    /**
     * Appends the given [Double] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Double) = compound.setDouble(this, value)

    /**
     * Appends the given [Double] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Double) = this(value)

    /**
     * Appends the given [Double] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Double) = this(value)

    /**
     * Appends the given [String] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: String) = compound.setString(this, value)

    /**
     * Appends the given [String] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: String) = this(value)

    /**
     * Appends the given [String] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: String) = this(value)

    /**
     * Appends the given [ByteArray] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: ByteArray) = compound.setByteArray(this, value)

    /**
     * Appends the given [ByteArray] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: ByteArray) = this(value)

    /**
     * Appends the given [ByteArray] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: ByteArray) = this(value)

    /**
     * Appends the given [IntArray] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: IntArray) = compound.setIntArray(this, value)

    /**
     * Appends the given [IntArray] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: IntArray) = this(value)

    /**
     * Appends the given [IntArray] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: IntArray) = this(value)

    /**
     * Appends the given [Boolean] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Boolean) = compound.setBoolean(this, value)

    /**
     * Appends the given [Boolean] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Boolean) = this(value)

    /**
     * Appends the given [Boolean] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Boolean) = this(value)

    /**
     * Appends the given [Enum] constant to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Enum<*>) = compound.setEnumConstant(this, value)

    /**
     * Appends the given [Enum] constant to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Enum<*>) = this(value)

    /**
     * Appends the given [Enum] constant to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Enum<*>) = this(value)

    /**
     * Appends the given [ResourceLocation] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: ResourceLocation) = compound.setResourceLocation(this, value)

    /**
     * Appends the given [ResourceLocation] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: ResourceLocation) = this(value)

    /**
     * Appends the given [ResourceLocation] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: ResourceLocation) = this(value)

    /**
     * Appends the given [ModelResourceLocation] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: ModelResourceLocation) = compound.setModelResourceLocation(this, value)

    /**
     * Appends the given [ModelResourceLocation] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: ModelResourceLocation) = this(value)

    /**
     * Appends the given [ModelResourceLocation] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: ModelResourceLocation) = this(value)

    /**
     * Appends the given [IBlockState] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: IBlockState) = compound.setBlockState(this, value)

    /**
     * Appends the given [IBlockState] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: IBlockState) = this(value)

    /**
     * Appends the given [IBlockState] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: IBlockState) = this(value)

    /**
     * Appends the given [GameProfile] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: GameProfile) = compound.setGameProfile(this, value)

    /**
     * Appends the given [GameProfile] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: GameProfile) = this(value)

    /**
     * Appends the given [GameProfile] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: GameProfile) = this(value)

    /**
     * Appends the given [BlockPos] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: BlockPos) = compound.setBlockPos(this, value)

    /**
     * Appends the given [BlockPos] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: BlockPos) = this(value)

    /**
     * Appends the given [BlockPos] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: BlockPos) = this(value)

    /**
     * Appends the given [Vec3i] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Vec3i) = compound.setVec3i(this, value)

    /**
     * Appends the given [Vec3i] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Vec3i) = this(value)

    /**
     * Appends the given [Vec3i] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Vec3i) = this(value)

    /**
     * Appends the given [Vec3d] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Vec3d) = compound.setVec3d(this, value)

    /**
     * Appends the given [Vec3d] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Vec3d) = this(value)

    /**
     * Appends the given [Vec3d] to the receiver key in the [compound]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Vec3d) = this(value)
}
