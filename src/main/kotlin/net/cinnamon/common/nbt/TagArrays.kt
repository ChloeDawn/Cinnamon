@file:JvmName("TagArrays")

package net.cinnamon.common.nbt

import net.minecraft.nbt.NBTTagByteArray
import net.minecraft.nbt.NBTTagIntArray
import net.minecraft.nbt.NBTTagLongArray

/**
 * Constructs a new [NBTTagByteArray] from the given [Byte] values
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagArray")
fun tagByteArrayOf(vararg values: Byte) = NBTTagByteArray(values)

/**
 * Constructs a new [NBTTagByteArray] from the given [ByteArray]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
@JvmName("newTagArrayKt")
fun tagByteArrayOf(values: ByteArray) = NBTTagByteArray(values)

/**
 * Constructs a new [NBTTagIntArray] from the given [Int] values
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagArray")
fun tagIntArrayOf(vararg values: Int) = NBTTagIntArray(values)

/**
 * Constructs a new [NBTTagIntArray] from the given [IntArray]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
@JvmName("newTagArrayKt")
fun tagIntArrayOf(values: IntArray) = NBTTagIntArray(values)

/**
 * Constructs a new [NBTTagLongArray] from the given [Long] values
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagArray")
fun tagLongArrayOf(vararg values: Long) = NBTTagLongArray(values)

/**
 * Constructs a new [NBTTagLongArray] from the given [LongArray]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
@JvmName("newTagArrayKt")
fun tagLongArrayOf(values: LongArray) = NBTTagLongArray(values)
