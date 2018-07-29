@file:JvmName("TagCompounds")
@file:Suppress("NOTHING_TO_INLINE")
@file:JvmMultifileClass

package net.cinnamon.common.nbt

import com.mojang.authlib.GameProfile
import net.cinnamon.common.base.MISSINGNO
import net.cinnamon.common.base.toRootLowerCase
import net.cinnamon.common.base.toRootUpperCase
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import net.minecraft.nbt.NBTUtil
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import net.minecraftforge.common.util.Constants.NBT.TAG_STRING
import java.util.UUID
import kotlin.reflect.KClass

/**
 * Constructs a new empty [NBTTagCompound]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun tagCompoundOf() = NBTTagCompound()

/**
 * Constructs a new [NBTTagCompound], and merges the given [NBTTagCompound] values
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagCompound")
fun tagCompoundOf(vararg values: NBTTagCompound) = NBTTagCompound().apply { values.forEach(::merge) }

/**
 * Appends the given [Enum] constant to the receiver on the given [key]
 * The [constant] is stored as its lower-cased [Enum.name]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun NBTTagCompound.setEnumConstant(key: String, constant: Enum<*>) =
    setString(key, constant.name.toRootLowerCase())

/**
 * Returns an enum [Enum] constant for the given [clazz] and name within the [key] of the receiver
 * @throws IllegalArgumentException If no such constant exists for the stored name
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun <E : Enum<E>> NBTTagCompound.getEnumConstant(clazz: Class<E>, key: String): E =
    java.lang.Enum.valueOf(clazz, getString(key).toRootUpperCase())

/**
 * Returns an enum [Enum] constant for the given [clazz] within the [key]
 * @throws IllegalArgumentException If no such constant exists for the stored name
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline fun <E : Enum<E>> NBTTagCompound.getEnumConstant(clazz: KClass<E>, key: String): E =
    getEnumConstant(clazz.java, key)

/**
 * Returns an enum [Enum] constant for the given class of [E] and name within the [key] of the receiver
 * @throws IllegalArgumentException If no such constant exists for the stored name
 * @author InsomniaKitten
 * @since 0.1.0
 */
inline fun <reified E : Enum<E>> NBTTagCompound.getEnumConstant(key: String): E =
    enumValueOf(getString(key).toRootUpperCase())

/**
 * Appends the given [ResourceLocation] to the receiver on the given [key]
 * The [rl] is stored as an [NBTTagCompound] containing the namespace and path
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.setResourceLocation(key: String, rl: ResourceLocation) =
    setTag(key, NBTTagCompound().apply {
        setString("namespace", rl.namespace)
        setString("path", rl.path)
    })

/**
 * Returns a [ResourceLocation] created from the data within the [key] of the receiver
 * @return [MISSINGNO] if no valid resource location exists for the [key]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.getResourceLocation(key: String) =
    getTag(key).run {
        if (hasKeys(TAG_STRING, "namespace", "path")) {
            val domain = getString("namespace")
            val path = getString("path")
            ResourceLocation(domain, path)
        } else MISSINGNO
    }

/**
 * Appends the given [ModelResourceLocation] to the receiver on the given [key]
 * The [mrl] is stored as an [NBTTagCompound] containing the namespace, path, and variant
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.setModelResourceLocation(key: String, mrl: ModelResourceLocation) =
    setTag(key, NBTTagCompound().apply {
        setString("namespace", mrl.namespace)
        setString("path", mrl.path)
        setString("variant", mrl.variant)
    })

/**
 * Returns a [ModelResourceLocation] created from the data within the [key] of the receiver
 * @return [MISSINGNO] if no valid model resource location exists for the [key]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.getModelResourceLocation(key: String) = getTag(key).run {
    if (hasKeys(TAG_STRING, "namespace", "path", "variant")) {
        val domain = getString("namespace")
        val path = getString("path")
        val variant = getString("variant")
        ModelResourceLocation(ResourceLocation(domain, path), variant)
    } else MISSINGNO
}

/**
 * Appends the given [IBlockState] to the receiver on the given [key]
 * The block [state] is serialized using [NBTUtil.writeBlockState]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.setBlockState(key: String, state: IBlockState) =
    setTag(key, NBTUtil.writeBlockState(NBTTagCompound(), state))

/**
 * Returns an [IBlockState] created from the data within the [key] of the receiver
 * The block state is deserialized using [NBTUtil.readBlockState]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.getBlockState(key: String): IBlockState =
    NBTUtil.readBlockState(getCompoundTag(key))

/**
 * Appends the given [GameProfile] to the receiver on the given [key]
 * The block [profile] is serialized using [NBTUtil.writeGameProfile]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.setGameProfile(key: String, profile: GameProfile) =
    setTag(key, NBTUtil.writeGameProfile(this, profile))

/**
 * Returns a [GameProfile] created from the data within the [key] of the receiver
 * The block state is deserialized using [NBTUtil.readGameProfileFromNBT]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.getGameProfile(key: String) =
    NBTUtil.readGameProfileFromNBT(getCompoundTag(key))

/**
 * Appends the given [BlockPos] to the receiver on the given [key]
 * The [pos] is stored as an [NBTTagCompound] containing the coordinates
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.setBlockPos(key: String, pos: BlockPos) = setTag(key, NBTTagCompound().apply {
    setInteger("x", pos.x)
    setInteger("y", pos.y)
    setInteger("z", pos.z)
})

/**
 * Returns a [BlockPos] created from the coordinates within the [key] of the receiver
 * Coordinates will default to 0 if they do not exist in the compound
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.getBlockPos(key: String): BlockPos = getCompoundTag(key).run {
    val x = getInteger("x")
    val y = getInteger("y")
    val z = getInteger("z")
    return BlockPos(x, y, z)
}

/**
 * Appends the given [Vec3i] to the receiver on the given [key]
 * The [vec] is stored as an [NBTTagCompound] containing the coordinates
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.setVec3i(key: String, vec: Vec3i) = setTag(key, NBTTagCompound().apply {
    setInteger("x", vec.x)
    setInteger("y", vec.y)
    setInteger("z", vec.z)
})

/**
 * Returns a [Vec3i] created from the coordinates within the [key] of the receiver
 * Coordinates will default to 0 if they do not exist in the compound
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.getVec3i(key: String): Vec3i = getCompoundTag(key).run {
    val x = getInteger("x")
    val y = getInteger("y")
    val z = getInteger("z")
    return Vec3i(x, y, z)
}

/**
 * Appends the given [Vec3d] to the receiver on the given [key]
 * The [vec] is stored as an [NBTTagCompound] containing the coordinates
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.setVec3d(key: String, vec: Vec3d) = setTag(key, NBTTagCompound().apply {
    setDouble("x", vec.x)
    setDouble("y", vec.y)
    setDouble("z", vec.z)
})

/**
 * Returns a [Vec3d] created from the coordinates within the [key] of the receiver
 * Coordinates will default to 0 if they do not exist in the compound
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.getVec3d(key: String): Vec3d = getCompoundTag(key).run {
    val x = getDouble("x")
    val y = getDouble("y")
    val z = getDouble("z")
    return Vec3d(x, y, z)
}

/**
 * Generic setter for [NBTTagCompound], which can be called as { compound["key"] = value }
 * Infers type from given value, avoiding the requirement of declaring a specific setter
 * @throws UnsupportedTagTypeException if the inferred type is not a supported tag type
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("setValue")
operator fun <T> NBTTagCompound.set(key: String, value: T) = when (value) {
    is Boolean -> setBoolean(key, value)
    is Byte -> setByte(key, value)
    is ByteArray -> setByteArray(key, value)
    is Double -> setDouble(key, value)
    is Float -> setFloat(key, value)
    is IntArray -> setIntArray(key, value)
    is Int -> setInteger(key, value)
    is Long -> setLong(key, value)
    is Short -> setShort(key, value)
    is String -> setString(key, value)
    is NBTBase -> setTag(key, value)
    is UUID -> setUniqueId(key, value)
    is IBlockState -> setBlockState(key, value)
    is GameProfile -> setGameProfile(key, value)
    is BlockPos -> setBlockPos(key, value)
    is ResourceLocation -> setResourceLocation(key, value)
    is Enum<*> -> setEnumConstant(key, value)
    is Vec3i -> setVec3i(key, value)
    is Vec3d -> setVec3d(key, value)
    else -> throw UnsupportedTagTypeException(value.toString(), "(\"$key\", ${value.toString()})")
}

/**
 * Generic getter for [NBTTagCompound], which can be called as { val i: Int = compound["key"] }
 * Return type is inferred from the field/return types being declared against, or via diamond operators
 * The alternative diamond operator usage can be applied as { val i = compound.get<Int>("key") }
 * This method is inaccessible from Java due to heavy reliance on reified type inference
 * @throws UnsupportedTagTypeException if the inferred type is not a supported tag type
 * @return An instance of the inferred type, retrieved from the [NBTTagCompound] using the given [key]
 * @author InsomniaKitten
 * @since 0.1.0
 */
inline operator fun <reified T> NBTTagCompound.get(key: String): T = when (T::class.java) {
    Boolean::class.java -> getBoolean(key) as T
    Byte::class.java -> getByte(key) as T
    Short::class.java -> getShort(key) as T
    Int::class.java -> getInteger(key) as T
    Long::class.java -> getLong(key) as T
    Float::class.java -> getFloat(key) as T
    Double::class.java -> getDouble(key) as T
    ByteArray::class.java -> getByteArray(key) as T
    String::class.java -> getString(key) as T
    NBTTagList::class.java -> getTag(key) as? T ?: NBTTagList() as T
    NBTTagCompound::class.java -> getCompoundTag(key) as T
    IntArray::class.java -> getIntArray(key) as T
    NBTBase::class.java -> getTag(key) as T
    UUID::class.java -> getUniqueId(key) as T
    IBlockState::class.java -> getBlockState(key) as T
    GameProfile::class.java -> getGameProfile(key) as T
    BlockPos::class.java -> getBlockPos(key) as T
    ResourceLocation::class.java -> getResourceLocation(key) as T
    Enum::class.java -> getString(key).let { constant ->
        // Pay no attention to this dumpster fire, move along
        T::class.java.enumConstants.find {
            constant.equals((it as Enum<*>).name, ignoreCase = true)
        } ?: error("Unable to determine enum constant for \"$constant\"")
    }
    Vec3i::class.java -> getVec3i(key) as T
    Vec3d::class.java -> getVec3d(key) as T
    else -> throw UnsupportedTagTypeException(T::class.java.name, "(\"$key\")")
}

/**
 * Determines if the given [keys] exist in the receiver [NBTTagCompound] as any type
 * This extension is inlined at call site, delegating to [Array.any] and [NBTTagCompound.hasKey]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.hasKeys(vararg keys: String) = keys.any(::hasKey)

/**
 * Determines if the given [keys] exist in the receiver [NBTTagCompound] as the given [type]
 * This extension is inlined at call site, delegating to [Array.any] and [NBTTagCompound.hasKey]
 * @see net.minecraftforge.common.util.Constants.NBT for reference on NBT valid tag types
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun NBTTagCompound.hasKeys(type: Int, vararg keys: String) = keys.any { hasKey(it, type) }

/**
 * Determines if the given [key] exists in the receiver [NBTTagCompound]
 * This extension is inlined at call site, delegating to [NBTTagCompound.hasKey]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun NBTTagCompound.contains(key: String) = hasKey(key)

/**
 * Merges the given [tag] into the receiver [NBTTagCompound]
 * This extension is inlined at call site, delegating to [NBTTagCompound.merge]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun NBTTagCompound.plus(tag: NBTTagCompound) = apply { merge(tag) }

/**
 * Merges the given [tag] into the receiver [NBTTagCompound]
 * This extension is inlined at call site, delegating to [NBTTagCompound.merge]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun NBTTagCompound.plusAssign(tag: NBTTagCompound) = merge(tag)
