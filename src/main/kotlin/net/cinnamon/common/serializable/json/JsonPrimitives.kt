@file:JvmName("JsonPrimitives")

package net.cinnamon.common.serializable.json

import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonPrimitive

/**
 * Converts the Boolean receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Boolean?.toJson(): JsonElement = this?.let(::JsonPrimitive) ?: JsonNull.INSTANCE

/**
 * Converts the Number receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Number?.toJson(): JsonElement = this?.let(::JsonPrimitive) ?: JsonNull.INSTANCE

/**
 * Converts the String receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun String?.toJson(): JsonElement = this?.let(::JsonPrimitive) ?: JsonNull.INSTANCE

/**
 * Converts the Char receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Char?.toJson(): JsonElement = this?.let(::JsonPrimitive) ?: JsonNull.INSTANCE
