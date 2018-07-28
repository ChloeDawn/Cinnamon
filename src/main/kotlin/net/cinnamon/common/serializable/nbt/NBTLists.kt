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
 * Returns an [NBTTagList] containing the given [Iterable] elements
 * @deprecated Will be migrated to safer type specific functions eventually
 * @throws UnsupportedTagTypeException If the element type is not a supported type
 */
@Deprecated("Will be migrated to safer type specific functions eventually")
inline fun <reified T> Iterable<T>.toTagList() = asSequence().run {
    NBTTagList().also { list ->
        when (T::class.java) {
            Boolean::class.java -> map { tagByteOf(it as Boolean) }
            Byte::class.java -> map { tagByteOf(it as Byte) }
            Short::class.java -> map { tagShortOf(it as Short) }
            Int::class.java -> map { tagIntOf(it as Int) }
            Long::class.java -> map { tagLongOf(it as Long) }
            Float::class.java -> map { tagFloatOf(it as Float) }
            Double::class.java -> map { tagDoubleOf(it as Double) }
            ByteArray::class.java -> map { tagByteArrayOf((it as ByteArray)) }
            String::class.java -> map { tagStringOf(it as String) }
            NBTTagList::class.java -> map { it as NBTBase }
            NBTTagCompound::class.java -> map { it as NBTTagCompound }
            IntArray::class.java -> map { tagIntArrayOf(it as IntArray) }
            LongArray::class.java -> map { tagLongArrayOf(it as LongArray) }
            NBTBase::class.java -> map { it as NBTBase }
            else -> throw UnsupportedTagTypeException(T::class.java.name, "toTagList")
        }.forEach(list::appendTag)
    }
}
