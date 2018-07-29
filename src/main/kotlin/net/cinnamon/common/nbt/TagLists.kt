@file:JvmName("TagLists")

package net.cinnamon.common.nbt

import net.minecraft.nbt.*

/**
 * Constructs a new empty [NBTTagList]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf() = NBTTagList()

/**
 * Constructs a new [NBTTagList] populated with the given [NBTBase] values
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf(vararg values: NBTBase) = NBTTagList().apply {
    values.forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], populated with the given [Byte] values as [NBTTagByte]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Byte) = NBTTagList().apply {
    values.asSequence().map(::tagByteOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], populated with the given [Short] values as [NBTTagShort]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Short) = NBTTagList().apply {
    values.asSequence().map(::tagShortOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], populated with the given [Int] values as [NBTTagInt]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Int) = NBTTagList().apply {
    values.asSequence().map(::tagIntOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], populated with the given [Long] values as [NBTTagLong]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Long) = NBTTagList().apply {
    values.asSequence().map(::tagLongOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], populated with the given [Float] values as [NBTTagFloat]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Float) = NBTTagList().apply {
    values.asSequence().map(::tagFloatOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], populated with the given [Double] values as [NBTTagDouble]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf(vararg values: Double) = NBTTagList().apply {
    values.asSequence().map(::tagDoubleOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], populated with the given [String] values as [NBTTagString]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newTagList")
fun tagListOf(vararg values: String) = NBTTagList().apply {
    values.asSequence().map(::tagStringOf).forEach(::appendTag)
}

/**
 * Constructs a new [NBTTagList], populated with the given [NBTTagCompound] values
 * @author InsomniaKitten
 * @since 0.1.0
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
@JvmSynthetic
fun Array<NBTBase>.toTagList() = tagListOf(*this)

/**
 * Converts the [ByteArray] receiver to an [NBTTagList] of [NBTTagByte]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun ByteArray.toTagList() = tagListOf(*map(::tagByteOf).toTypedArray())

/**
 * Converts the [ShortArray] receiver to an [NBTTagList] of [NBTTagShort]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun ShortArray.toTagList() = tagListOf(*map(::tagShortOf).toTypedArray())

/**
 * Converts the [IntArray] receiver to an [NBTTagList] of [NBTTagInt]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun IntArray.toTagList() = tagListOf(*map(::tagIntOf).toTypedArray())
/**
 * Converts the [LongArray] receiver to an [NBTTagList] of [NBTTagLong]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun LongArray.toTagList() = tagListOf(*map(::tagLongOf).toTypedArray())

/**
 * Converts the [FloatArray] receiver to an [NBTTagList] of [NBTTagFloat]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun FloatArray.toTagList() = tagListOf(*map(::tagFloatOf).toTypedArray())

/**
 * Converts the [DoubleArray] receiver to an [NBTTagList] of [NBTTagDouble]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun DoubleArray.toTagList() = tagListOf(*map(::tagDoubleOf).toTypedArray())

/**
 * Converts the [Array]<[String]> receiver to an [NBTTagList] of [NBTTagString]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun Array<String>.toTagList() = tagListOf(*map(::tagStringOf).toTypedArray())

/**
 * Converts the [BooleanArray] receiver to an [NBTTagList] of [NBTTagByte]s
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
fun BooleanArray.toTagList() = tagListOf(*map(::tagByteOf).toTypedArray())
