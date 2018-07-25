package net.cinnamon.common.collection.mc

import net.minecraft.util.NonNullList
import java.util.ArrayList
import java.util.Comparator
import java.util.function.Predicate
import java.util.function.UnaryOperator
import kotlin.DeprecationLevel.ERROR

@Suppress("DeprecatedCallableAddReplaceWith")
open class ImmutableNonNullList<V>(delegate: List<V> = ArrayList(), type: V? = null) : NonNullList<V>(delegate, type) {
    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun addAll(index: Int, elements: Collection<V>): Boolean {
        throw UnsupportedOperationException("addAll")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun addAll(elements: Collection<V>): Boolean {
        throw UnsupportedOperationException("addAll")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun clear() {
        throw UnsupportedOperationException("clear")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun removeAll(elements: Collection<V>): Boolean {
        throw UnsupportedOperationException("removeAll")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun add(index: Int, element: V) {
        throw UnsupportedOperationException("add")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun add(element: V): Boolean {
        throw UnsupportedOperationException("add")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun removeRange(fromIndex: Int, toIndex: Int) {
        throw UnsupportedOperationException("removeRange")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun removeAt(index: Int): V {
        throw UnsupportedOperationException("removeAt")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun remove(element: V): Boolean {
        throw UnsupportedOperationException("remove")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun set(index: Int, element: V): V {
        throw UnsupportedOperationException("set")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun retainAll(elements: Collection<V>): Boolean {
        throw UnsupportedOperationException("retainAll")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun replaceAll(operator: UnaryOperator<V>) {
        throw UnsupportedOperationException("replaceAll")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun sort(c: Comparator<in V>?) {
        throw UnsupportedOperationException("sort")
    }

    @Deprecated("ImmutableNonNullList cannot be modified", level = ERROR)
    override fun removeIf(filter: Predicate<in V>): Boolean {
        throw UnsupportedOperationException("removeIf")
    }

    class Singleton<V>(private val value: V) : ImmutableNonNullList<V>() {
        override val size: Int = 1
        override fun isEmpty(): Boolean = false
        override fun contains(element: V): Boolean = value == element
        override fun containsAll(elements: Collection<V>): Boolean =
            elements.size == 1 && value == elements.first()
    }

    companion object {
        private val empty = object : ImmutableNonNullList<Any>() {
            override val size: Int = 0
            override fun isEmpty(): Boolean = true
            override fun contains(element: Any): Boolean = false
            override fun containsAll(elements: Collection<Any>): Boolean = false
        }

        @Suppress("UNCHECKED_CAST")
        fun <V> empty(): ImmutableNonNullList<V> = empty as ImmutableNonNullList<V>
    }
}
