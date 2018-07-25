@file:JvmName("DataParameters")
@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.common.entity

import net.minecraft.entity.Entity
import net.minecraft.network.datasync.DataParameter
import net.minecraft.network.datasync.DataSerializer
import net.minecraft.network.datasync.EntityDataManager
import kotlin.reflect.KClass

@JvmName("newDataParameter")
fun <T> dataParameterOf(clazz: KClass<out Entity>, serializer: DataSerializer<T>): DataParameter<T> {
    return EntityDataManager.createKey(clazz.java, serializer)
}

@JvmName("newDataParameter")
fun <T> dataParameterOf(clazz: Class<out Entity>, serializer: DataSerializer<T>): DataParameter<T> {
    return EntityDataManager.createKey(clazz, serializer)
}

@JvmSynthetic
inline fun <T> DataSerializer<T>.toDataParameter(clazz: KClass<out Entity>): DataParameter<T> {
    return dataParameterOf(clazz, this)
}

@JvmSynthetic
inline fun <T> DataSerializer<T>.toDataParameter(clazz: Class<out Entity>): DataParameter<T> {
    return dataParameterOf(clazz, this)
}
