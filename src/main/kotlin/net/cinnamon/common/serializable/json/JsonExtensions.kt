@file:JvmName("JsonExtensions")
@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.common.serializable.json

import com.google.gson.JsonElement
import com.google.gson.JsonObject

/**
 * Appends the given [property] and [value] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.add]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, value: JsonElement?) = add(property, value)

/**
 * Appends the given [property] and [value] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.addProperty]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, value: String?) = addProperty(property, value)

/**
 * Appends the given [property] and [value] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.addProperty]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, value: Number?) = addProperty(property, value)

/**
 * Appends the given [property] and [value] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.addProperty]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, value: Boolean?) = addProperty(property, value)

/**
 * Appends the given [property] and [value] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.addProperty]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, value: Char?) = addProperty(property, value)

/**
 * Determines if the [JsonObject] receiver has the given [property]
 * This extension is inlined at call site, delegating to [JsonObject.has]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.contains(property: String) = has(property)
