@file:JvmName("IntLists")

package net.cinnamon.common.collection.fastutil

import it.unimi.dsi.fastutil.ints.IntArrayList
import it.unimi.dsi.fastutil.ints.IntList
import it.unimi.dsi.fastutil.ints.IntLists
import java.util.Random

/**
 * Returns a reference to [IntLists.EMPTY_LIST]
 */
fun emptyIntList(): IntList = IntLists.EMPTY_LIST

/**
 * Returns a reference to [IntLists.EMPTY_LIST]
 */
@JvmName("newImmutableIntList")
fun intListOf(): IntList = emptyIntList()

/**
 * Returns an [IntLists.Singleton] instance wrapping the given [int]
 */
@JvmName("newImmutableIntList")
fun intListOf(int: Int): IntList = IntLists.singleton(int)

/**
 * Returns an [IntLists.UnmodifiableList] instance wrapping the given [ints]
 */
@JvmName("newImmutableIntList")
fun intListOf(vararg ints: Int): IntList = if (ints.isNotEmpty()) {
    IntLists.unmodifiable(IntArrayList.wrap(ints))
} else emptyIntList()

/**
 * Returns an [IntLists.UnmodifiableList] instance wrapping the given [IntArray]
 * This function has no applicable use in a Java environment
 */
@JvmSynthetic
fun intListOf(ints: IntArray): IntList = if (ints.isNotEmpty()) {
    IntLists.unmodifiable(IntArrayList.wrap(ints))
} else emptyIntList()

/**
 * Returns an [IntLists.UnmodifiableList] instance wrapping the given [IntList]
 */
@JvmName("newImmutableIntList")
fun intListOf(ints: IntList): IntList = if (ints.isNotEmpty()) {
    IntLists.unmodifiable(ints)
} else emptyIntList()

/**
 * Returns an [IntArrayList] instance wrapping the given [ints]
 */
@JvmName("newIntList")
fun mutableIntListOf(vararg ints: Int): IntList = IntArrayList.wrap(ints)

/**
 * Returns an [IntArrayList] instance wrapping the given [IntArray]
 * This function has no applicable use in a Java environment
 */
@JvmSynthetic
fun mutableIntListOf(ints: IntArray): IntList = IntArrayList.wrap(ints)

/**
 * Returns an [IntArrayList] instance wrapping the given [IntList]
 */
@JvmName("newIntList")
fun mutableIntListOf(ints: IntList): IntList = if (ints.isNotEmpty()) {
    IntLists.unmodifiable(ints)
} else emptyIntList()

/**
 * Returns an unmodifiable version of the receiver [IntList]
 */
@JvmSynthetic
fun IntList.toIntList(): IntList = when {
    this is IntLists.Singleton -> this
    this is IntLists.UnmodifiableList -> this
    isEmpty() -> emptyIntList()
    size == 1 -> intListOf(first())
    else -> intListOf(this)
}

/**
 * Returns a of [IntList] wrapping the contents of the receiver
 * If the receiver was already mutable, itself will be returned
 */
@JvmSynthetic
fun IntList.toMutableIntList(): IntList = when {
    this is IntLists.EmptyList -> mutableIntListOf(this)
    this is IntLists.Singleton -> mutableIntListOf(this)
    this is IntLists.UnmodifiableList -> mutableIntListOf(this)
    else -> this
}

/**
 * Returns an unmodifiable [IntList] wrapping the receiver [IntArray]
 */
@JvmSynthetic
fun IntArray.toIntList(): IntList = when {
    isEmpty() -> emptyIntList()
    size == 1 -> intListOf(first())
    else -> intListOf(this)
}

/**
 * Returns an [IntArrayList] wrapping the receiver [IntArray]
 */
@JvmSynthetic
fun IntArray.toMutableIntList(): IntList = mutableIntListOf(this)

/**
 * Returns an unmodifiable [IntList] wrapping the [Int] values of the receiver [List]
 */
@JvmSynthetic
fun List<Int>.toIntList(): IntList = toIntArray().toIntList()

/**
 * Returns an [IntArrayList] wrapping the [Int] values of the receiver [List]
 */
@JvmSynthetic
fun List<Int>.toMutableIntList(): IntList = toIntArray().toMutableIntList()

/**
 * Constructs a of synchronized [IntList] backed by the receiver
 * Returns an [IntLists.SynchronizedList] instance wrapping the receiver
 * @see java.util.Collections.synchronizedList
 */
fun IntList.synchronize(): IntList = IntLists.synchronize(this)

/**
 * Constructs a of synchronized [IntList] backed by the receiver
 * Passes an unassigned object [sync] which is used to synchronize
 * Returns an [IntLists.SynchronizedList] instance wrapping the receiver
 * @see java.util.Collections.synchronizedList
 */
fun IntList.synchronize(sync: Any): IntList = IntLists.synchronize(this, sync)

/**
 * Shuffles the [IntList] using the given [Random] instance
 * Returns the receiver [IntList] with shuffled elements
 */
fun IntList.shuffle(rand: Random = Random()): IntList = IntLists.shuffle(this, rand)

/**
 * Shuffles the [IntList] using a [Random] created from the given [seed]
 * Returns the receiver [IntList] with shuffled elements
 */
fun IntList.shuffle(seed: Long): IntList = IntLists.shuffle(this, Random(seed))
