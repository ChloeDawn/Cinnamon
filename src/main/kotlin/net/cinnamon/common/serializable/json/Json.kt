@file:JvmName("Json")

package net.cinnamon.common.serializable.json

import com.google.gson.JsonPrimitive

/**
 * Converts the Boolean receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Boolean.toJson() = JsonPrimitive(this)

/**
 * Converts the Number receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Number.toJson() = JsonPrimitive(this)

/**
 * Converts the String receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun String.toJson() = JsonPrimitive(this)

/**
 * Converts the Char receiver to a [JsonPrimitive]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Char.toJson() = JsonPrimitive(this)
