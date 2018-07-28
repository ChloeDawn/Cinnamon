@file:JvmName("JsonPrimitives")

package net.cinnamon.common.serializable.json

import com.google.gson.JsonPrimitive

/**
 * Converts the Boolean receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Boolean?.toJson() = JsonPrimitive(this)

/**
 * Converts the Number receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Number?.toJson() = JsonPrimitive(this)

/**
 * Converts the String receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun String?.toJson() = JsonPrimitive(this)

/**
 * Converts the Char receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Char?.toJson() = JsonPrimitive(this)
