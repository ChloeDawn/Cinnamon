@file:JvmName("JsonPrimitives")

package net.cinnamon.support.gson

import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonPrimitive

/**
 * Returns the Boolean receiver as a [JsonPrimitive], or [JsonNull.INSTANCE] if the receiver is `null`
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Boolean?.toJson(): JsonElement = this?.let(::JsonPrimitive) ?: JsonNull.INSTANCE

/**
 * Returns the Number receiver as a [JsonPrimitive], or [JsonNull.INSTANCE] if the receiver is `null`
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Number?.toJson(): JsonElement = this?.let(::JsonPrimitive) ?: JsonNull.INSTANCE

/**
 * Returns the String receiver as a [JsonPrimitive], or [JsonNull.INSTANCE] if the receiver is `null`
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun String?.toJson(): JsonElement = this?.let(::JsonPrimitive) ?: JsonNull.INSTANCE

/**
 * Returns the Char receiver as a [JsonPrimitive], or [JsonNull.INSTANCE] if the receiver is `null`
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonPrimitive")
fun Char?.toJson(): JsonElement = this?.let(::JsonPrimitive) ?: JsonNull.INSTANCE
