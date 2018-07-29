@file:JvmName("TagPrimitives")

package net.cinnamon.common.nbt

import net.minecraft.nbt.NBTTagByte
import net.minecraft.nbt.NBTTagDouble
import net.minecraft.nbt.NBTTagFloat
import net.minecraft.nbt.NBTTagInt
import net.minecraft.nbt.NBTTagLong
import net.minecraft.nbt.NBTTagShort
import net.minecraft.nbt.NBTTagString

/**
 * Constructs a new [NBTTagByte] from the given [Byte], or 0 if undefined
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagByte")
@JvmOverloads
fun tagByteOf(value: Byte = 0) = NBTTagByte(value)

/**
 * Constructs a new [NBTTagByte] from the given [Boolean]
 * If [value] is `true` the byte will be 1, else it will be 0
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagByte")
fun tagByteOf(value: Boolean) = NBTTagByte(if (value) 1 else 0)

/**
 * Constructs a new [NBTTagShort] from the given [Short], or 0 if undefined
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagShort")
@JvmOverloads
fun tagShortOf(value: Short = 0) = NBTTagShort(value)

/**
 * Constructs a new [NBTTagInt] from the given [Int], or 0 if undefined
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagInt")
@JvmOverloads
fun tagIntOf(value: Int = 0) = NBTTagInt(value)

/**
 * Constructs a new [NBTTagLong] from the given [Long], or 0L if undefined
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagLong")
@JvmOverloads
fun tagLongOf(value: Long = 0L) = NBTTagLong(value)

/**
 * Constructs a new [NBTTagFloat] from the given [Float], or 0.0F if undefined
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagFloat")
@JvmOverloads
fun tagFloatOf(value: Float = 0.0F) = NBTTagFloat(value)

/**
 * Constructs a new [NBTTagDouble] from the given [Double], or 0.0 if undefined
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagDouble")
@JvmOverloads
fun tagDoubleOf(value: Double = 0.0) = NBTTagDouble(value)

/**
 * Constructs a new [NBTTagString] from the given [String], or empty if undefined
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagString")
@JvmOverloads
fun tagStringOf(value: String = "") = NBTTagString(value)
