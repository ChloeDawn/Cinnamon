@file:JvmName("Reflection")

package net.cinnamon.common.reflection

import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KClass

fun Class<*>.findField(fieldName: String): Field =
    this.getDeclaredField(fieldName).apply { this.isAccessible = true }

fun Class<*>.findField(fieldIndex: Int): Field =
    this.declaredFields[fieldIndex].apply { this.isAccessible = true }

fun Class<*>.findMethod(methodName: String, vararg parameterTypes: Class<*>): Method =
    this.getDeclaredMethod(methodName, *parameterTypes).apply { this.isAccessible = true }

fun <T : Any> Class<T>.findConstructor(vararg parameterTypes: Class<*>): Constructor<T> = try {
    this.getDeclaredConstructor(*parameterTypes).apply { this.isAccessible = true }
} catch (exception: NoSuchMethodException) {
    throw NoSuchConstructorException(exception)
}

@Suppress("UNCHECKED_CAST")
@JvmOverloads
fun <T, E : Any> Class<out E>.getValue(fieldName: String, instance: E? = null): T =
    this.findField(fieldName)[instance] as T

@JvmOverloads
fun <T, E : Any> Class<out E>.setValue(fieldName: String, value: T, instance: E? = null) {
    this.findField(fieldName)[instance] = value
}

@Suppress("UNCHECKED_CAST")
@JvmOverloads
fun <T, E : Any> Class<out E>.getValue(fieldIndex: Int, instance: E? = null): T =
    this.findField(fieldIndex)[instance] as T

@JvmOverloads
fun <T, E : Any> Class<out E>.setValue(fieldIndex: Int, value: T, instance: E? = null) {
    this.findField(fieldIndex)[instance] = value
}

fun Class<*>.findObfuscatedField(obfFieldName: String) =
    this.findField(MCPMappings.mapFieldName(this, obfFieldName))

fun Class<*>.findObfuscatedMethod(obfMethodName: String, vararg parameterTypes: Class<*>) =
    this.findMethod(MCPMappings.mapMethodName(this, obfMethodName), *parameterTypes)

@JvmSynthetic
fun KClass<*>.findField(fieldName: String): Field =
    this.java.getDeclaredField(fieldName).apply { this.isAccessible = true }

@JvmSynthetic
fun KClass<*>.findField(fieldIndex: Int): Field =
    this.java.declaredFields[fieldIndex].apply { this.isAccessible = true }

@JvmSynthetic
fun KClass<*>.findMethod(methodName: String, vararg parameterTypes: KClass<*>): Method =
    this.java.getDeclaredMethod(methodName, *parameterTypes.map(KClass<*>::java).toTypedArray())
        .apply { this.isAccessible = true }

@JvmSynthetic
fun <T : Any> KClass<T>.findConstructor(vararg parameterTypes: KClass<*>): Constructor<T> = try {
    this.java.getDeclaredConstructor(*parameterTypes.map(KClass<*>::java).toTypedArray())
        .apply { this.isAccessible = true }
} catch (exception: NoSuchMethodException) {
    throw NoSuchConstructorException(exception)
}

@Suppress("UNCHECKED_CAST")
@JvmSynthetic
fun <T, E : Any> KClass<out E>.getValue(fieldName: String, instance: E? = null): T =
    this.findField(fieldName)[instance] as T

@JvmSynthetic
fun <T, E : Any> KClass<out E>.setValue(fieldName: String, value: T, instance: E? = null) {
    this.findField(fieldName)[instance] = value
}

@Suppress("UNCHECKED_CAST")
@JvmSynthetic
fun <T, E : Any> KClass<out E>.getValue(fieldIndex: Int, instance: E? = null): T =
    this.findField(fieldIndex)[instance] as T

@JvmSynthetic
fun <T, E : Any> KClass<out E>.setValue(fieldIndex: Int, value: T, instance: E? = null) {
    this.findField(fieldIndex)[instance] = value
}

@JvmSynthetic
fun KClass<*>.findObfuscatedField(obfFieldName: String) =
    this.findField(MCPMappings.mapFieldName(this.java, obfFieldName))

@JvmSynthetic
fun KClass<*>.findObfuscatedMethod(obfMethodName: String, vararg parameterTypes: KClass<*>) =
    this.findMethod(MCPMappings.mapMethodName(this.java, obfMethodName), *parameterTypes)

private class NoSuchConstructorException(exception: NoSuchMethodException)
    : Exception(exception.localizedMessage)
