@file:JvmName("NBTTags")

package net.cinnamon.common.serializable.nbt

import net.minecraft.nbt.*

/**
 * Constructs a new [NBTTagByte] from the given [Byte], or 0 if undefined
 */
@JvmName("newTagByte")
@JvmOverloads
fun tagByteOf(value: Byte = 0) = NBTTagByte(value)

/**
 * Constructs a new [NBTTagShort] from the given [Short], or 0 if undefined
 */
@JvmName("newTagShort")
@JvmOverloads
fun tagShortOf(value: Short = 0) = NBTTagShort(value)

/**
 * Constructs a new [NBTTagInt] from the given [Int], or 0 if undefined
 */
@JvmName("newTagInt")
@JvmOverloads
fun tagIntOf(value: Int = 0) = NBTTagInt(value)

/**
 * Constructs a new [NBTTagLong] from the given [Long], or 0L if undefined
 */
@JvmName("newTagLong")
@JvmOverloads
fun tagLongOf(value: Long = 0L) = NBTTagLong(value)

/**
 * Constructs a new [NBTTagFloat] from the given [Float], or 0.0F if undefined
 */
@JvmName("newTagFloat")
@JvmOverloads
fun tagFloatOf(value: Float = 0.0F) = NBTTagFloat(value)

/**
 * Constructs a new [NBTTagDouble] from the given [Double], or 0.0 if undefined
 */
@JvmName("newTagDouble")
@JvmOverloads
fun tagDoubleOf(value: Double = 0.0) = NBTTagDouble(value)

/**
 * Constructs a new [NBTTagString] from the given [String], or empty if undefined
 */
@JvmName("newTagString")
@JvmOverloads
fun tagStringOf(value: String = "") = NBTTagString(value)

/**
 * Constructs a new [NBTTagCompound], and merges the given [NBTTagCompound] values
 */
@JvmName("newTagCompound")
fun tagCompoundOf(vararg values: NBTTagCompound) = NBTTagCompound().apply {
    values.asSequence().forEach(this::merge)
}

/**
 * Constructs a new [NBTTagByteArray] from the given [Byte] values
 */
@JvmName("newTagByteArray")
fun tagByteArrayOf(vararg values: Byte) = NBTTagByteArray(values)

/**
 * Constructs a new [NBTTagByteArray] from the given [ByteArray]
 */
@JvmSynthetic
@JvmName("newTagByteArrayKt")
fun tagByteArrayOf(values: ByteArray) = NBTTagByteArray(values)

/**
 * Constructs a new [NBTTagIntArray] from the given [Int] values
 */
@JvmName("newTagIntArray")
fun tagIntArrayOf(vararg values: Int) = NBTTagIntArray(values)

/**
 * Constructs a new [NBTTagIntArray] from the given [IntArray]
 */
@JvmSynthetic
@JvmName("newTagIntArrayKt")
fun tagIntArrayOf(values: IntArray) = NBTTagIntArray(values)

/**
 * Constructs a new [NBTTagLongArray] from the given [Long] values
 */
@JvmName("newTagLongArray")
fun tagLongArrayOf(vararg values: Long) = NBTTagLongArray(values)

/**
 * Constructs a new [NBTTagLongArray] from the given [LongArray]
 */
@JvmSynthetic
@JvmName("newTagLongArrayKt")
fun tagLongArrayOf(values: LongArray) = NBTTagLongArray(values)
