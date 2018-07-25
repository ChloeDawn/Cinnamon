@file:JvmName("Objects")

package net.cinnamon.common.base

import com.google.common.base.MoreObjects
import kotlin.reflect.KClass

fun Any?.hashCode() = this?.hashCode() ?: 0

@JvmName("hashCode")
fun hashCodeOf(vararg objects: Any?) =
    if (objects.isEmpty()) 0 else {
        objects.fold(1) { hash, obj ->
            31 * hash + obj.hashCode()
        }
    }

@JvmSynthetic
inline fun Any?.toString(action: MoreObjects.ToStringHelper.() -> Unit) =
    MoreObjects.toStringHelper(this?.javaClass?.simpleName.toString()).also(action).toString()

@JvmSynthetic
inline fun stringOf(head: String, action: MoreObjects.ToStringHelper.() -> Unit) =
    MoreObjects.toStringHelper(head).also(action).toString()

@JvmSynthetic
inline fun stringOf(head: Any, action: MoreObjects.ToStringHelper.() -> Unit) =
    MoreObjects.toStringHelper(head).also(action).toString()

@JvmSynthetic
inline fun stringOf(head: Class<*>, action: MoreObjects.ToStringHelper.() -> Unit) =
    MoreObjects.toStringHelper(head).also(action).toString()

@JvmSynthetic
inline fun stringOf(head: KClass<*>, action: MoreObjects.ToStringHelper.() -> Unit) =
    MoreObjects.toStringHelper(head.java).also(action).toString()
