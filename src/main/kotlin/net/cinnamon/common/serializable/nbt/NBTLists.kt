@file:JvmName("NBTLists")

package net.cinnamon.common.serializable.nbt

import net.minecraft.nbt.*

/**
 * Constructs a new [NBTTagList]
 */
@JvmName("newTagList")
fun tagListOf() = NBTTagList()

/**
 * Constructs a new [NBTTagList], appending the given [NBTBase] values
 */
@JvmName("newTagList")
fun tagListOf(vararg values: NBTBase) = NBTTagList().apply {
    values.forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], appending the given [Byte] values as [NBTTagByte]s
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Byte) = NBTTagList().apply {
    values.asSequence().map(::tagByteOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], appending the given [Short] values as [NBTTagShort]s
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Short) = NBTTagList().apply {
    values.asSequence().map(::tagShortOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], appending the given [Int] values as [NBTTagInt]s
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Int) = NBTTagList().apply {
    values.asSequence().map(::tagIntOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], appending the given [Long] values as [NBTTagLong]s
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Long) = NBTTagList().apply {
    values.asSequence().map(::tagLongOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], appending the given [Float] values as [NBTTagFloat]s
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Float) = NBTTagList().apply {
    values.asSequence().map(::tagFloatOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], appending the given [Double] values as [NBTTagDouble]s
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Double) = NBTTagList().apply {
    values.asSequence().map(::tagDoubleOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], appending the given [String] values as [NBTTagString]s
 */
@JvmName("newTagList")
fun tagListOf(vararg values: String) = NBTTagList().apply {
    values.asSequence().map(::tagStringOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], appending the given [NBTTagCompound] values
 */
@JvmName("newTagList")
fun tagListOf(vararg values: NBTTagCompound) = NBTTagList().apply {
    values.forEach(::appendTag)
}

/**
 * Converts the [Array]<[NBTBase]> receiver to an [NBTTagList] of [NBTBase]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<NBTBase>.toTagList() = tagListOf(*this)

/**
 * Converts the [ByteArray] receiver to an [NBTTagList] of [NBTTagByte]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun ByteArray.toTagList() = tagListOf(*map(::tagByteOf).toTypedArray())

/**
 * Converts the [ShortArray] receiver to an [NBTTagList] of [NBTTagShort]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun ShortArray.toTagList() = tagListOf(*map(::tagShortOf).toTypedArray())

/**
 * Converts the [IntArray] receiver to an [NBTTagList] of [NBTTagInt]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun IntArray.toTagList() = tagListOf(*map(::tagIntOf).toTypedArray())
/**
 * Converts the [LongArray] receiver to an [NBTTagList] of [NBTTagLong]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun LongArray.toTagList() = tagListOf(*map(::tagLongOf).toTypedArray())

/**
 * Converts the [FloatArray] receiver to an [NBTTagList] of [NBTTagFloat]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun FloatArray.toTagList() = tagListOf(*map(::tagFloatOf).toTypedArray())

/**
 * Converts the [DoubleArray] receiver to an [NBTTagList] of [NBTTagDouble]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun DoubleArray.toTagList() = tagListOf(*map(::tagDoubleOf).toTypedArray())

/**
 * Converts the [Array]<[String]> receiver to an [NBTTagList] of [NBTTagString]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<String>.toTagList() = tagListOf(*map(::tagStringOf).toTypedArray())

/**
 * Converts the [BooleanArray] receiver to an [NBTTagList] of [NBTTagByte]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun BooleanArray.toTagList() = tagListOf(*map(::tagByteOf).toTypedArray())
