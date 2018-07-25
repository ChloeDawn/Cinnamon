@file:JvmName("NonNullLists")

package net.cinnamon.common.collection.mc

typealias MutableNonNullList<V> = net.minecraft.util.NonNullList<V>
typealias NonNullList<V> = ImmutableNonNullList<V>

fun <V : Any> emptyNonNullList(): NonNullList<V> =
    ImmutableNonNullList.empty()

@JvmName("newImmutableNonNullList")
fun <V : Any> nonNullListOf(): NonNullList<V> =
    emptyNonNullList()

@JvmName("newImmutableNonNullList")
fun <V : Any> nonNullListOf(element: V): NonNullList<V> =
    ImmutableNonNullList.Singleton(element)

@JvmName("newImmutableNonNullList")
fun <V : Any> nonNullListOf(vararg elements: V): NonNullList<V> =
    ImmutableNonNullList(elements.toList())

@JvmName("newImmutableNonNullList")
fun <V : Any> nonNullListOf(elements: Iterable<V>): NonNullList<V> =
    when (elements.count()) {
        0 -> ImmutableNonNullList.empty()
        1 -> ImmutableNonNullList.Singleton(elements.first())
        else -> when (elements) {
            is List -> ImmutableNonNullList(elements)
            else -> ImmutableNonNullList(elements.toList())
        }
    }

@JvmName("newNonNullList")
fun <V : Any> mutableNonNullListOf(vararg elements: V): MutableNonNullList<V> =
    MutableNonNullList.create<V>().apply { addAll(elements) }

@JvmName("newNonNullList")
fun <V : Any> mutableNonNullListOf(elements: Iterable<V>): MutableNonNullList<V> =
    MutableNonNullList.create<V>().apply { addAll(elements) }

@JvmSynthetic
fun <V : Any> Iterable<V>.toNonNullList() =
    nonNullListOf(this)

@JvmSynthetic
fun <V : Any> Array<V>.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun DoubleArray.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun FloatArray.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun LongArray.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun IntArray.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun CharArray.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun ShortArray.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun ByteArray.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun BooleanArray.toNonNullList() =
    nonNullListOf(toList())

@JvmSynthetic
fun <V : Any> Iterable<V>.toMutableNonNullList() =
    mutableNonNullListOf(this)

@JvmSynthetic
fun <V : Any> Array<V>.toMutableNonNullList() =
    mutableNonNullListOf(toList())

@JvmSynthetic
fun DoubleArray.toMutableNonNullList() =
    mutableNonNullListOf(toList())

@JvmSynthetic
fun FloatArray.toMutableNonNullList() =
    mutableNonNullListOf(toList())

@JvmSynthetic
fun LongArray.toMutableNonNullList() =
    mutableNonNullListOf(toList())

@JvmSynthetic
fun IntArray.toMutableNonNullList() =
    mutableNonNullListOf(toList())

@JvmSynthetic
fun CharArray.toMutableNonNullList() =
    mutableNonNullListOf(toList())

@JvmSynthetic
fun ShortArray.toMutableNonNullList() =
    mutableNonNullListOf(toList())

@JvmSynthetic
fun ByteArray.toMutableNonNullList() =
    mutableNonNullListOf(toList())

@JvmSynthetic
fun BooleanArray.toMutableNonNullList() =
    mutableNonNullListOf(toList())
