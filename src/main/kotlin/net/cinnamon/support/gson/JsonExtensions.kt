@file:JvmName("JsonExtensions")
@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.support.gson

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject

/**
 * Casts the receiver to a [JsonArray] and returns the element at the given [index]
 * This extension is inlined at call site, delegating to [JsonElement.getAsJsonArray] and [JsonArray.get]
 * @throws IllegalStateException If the receiver cannot be cast to a [JsonArray]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonElement.get(index: Int): JsonElement = asJsonArray.get(index)

/**
 * Casts the receiver to a [JsonObject] and returns the element of the given [property]
 * This extension is inlined at call site, delegating to [JsonElement.getAsJsonObject] and [JsonObject.get]
 * @throws IllegalStateException If the receiver cannot be cast to a [JsonObject]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonElement.get(property: String): JsonElement = asJsonObject.get(property)

/**
 * Appends the given [property] and [element] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.add]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, element: JsonElement?) = element.also { add(property, it) }

/**
 * Appends the given [property] and [element] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.addProperty]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, element: String?) = element.also { addProperty(property, it) }

/**
 * Appends the given [property] and [element] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.addProperty]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, element: Number?) = element.also { addProperty(property, it) }

/**
 * Appends the given [property] and [element] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.addProperty]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, element: Boolean?) = element.also { addProperty(property, it) }

/**
 * Appends the given [property] and [element] to the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonObject.addProperty]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.set(property: String, element: Char?) = element.also { addProperty(property, it) }

/**
 * Sets the given [element] to the given [index] within the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.set]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.set(index: Int, element: String?): JsonElement = set(index, element.toJson())

/**
 * Sets the given [element] to the given [index] within the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.set]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.set(index: Int, element: Number?): JsonElement = set(index, element.toJson())

/**
 * Sets the given [element] to the given [index] within the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.set]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.set(index: Int, element: Boolean?): JsonElement = set(index, element.toJson())

/**
 * Sets the given [element] to the given [index] within the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.set]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.set(index: Int, element: Char?): JsonElement = set(index, element.toJson())

/**
 * Appends the given [element] to the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.add]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.plusAssign(element: JsonElement?) = add(element)

/**
 * Appends the given [element] to the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.add]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.plusAssign(element: String?) = add(element)

/**
 * Appends the given [element] to the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.add]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.plusAssign(element: Number?) = add(element)

/**
 * Appends the given [element] to the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.add]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.plusAssign(element: Boolean?) = add(element)

/**
 * Appends the given [element] to the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.add]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.plusAssign(element: Char?) = add(element)

/**
 * Removes the given [element] from the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.remove]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.minusAssign(element: JsonElement?) { remove(element) }

/**
 * Removes the given [element] from the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.remove]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.minusAssign(element: String?) { remove(element.toJson()) }

/**
 * Removes the given [element] from the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.remove]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.minusAssign(element: Number?) { remove(element.toJson()) }

/**
 * Removes the given [element] from the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.remove]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.minusAssign(element: Boolean?) { remove(element.toJson()) }

/**
 * Removes the given [element] from the receiver [JsonArray]
 * This extension is inlined at call site, delegating to [JsonArray.remove]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.minusAssign(element: Char?) { remove(element.toJson()) }

/**
 * Removes the given [property] from the receiver [JsonObject]
 * This extension is inlined at call site, delegating to [JsonArray.remove]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.minusAssign(property: String) { remove(property) }

/**
 * Determines if the [JsonObject] receiver contains the given [property]
 * This extension is inlined at call site, delegating to [JsonObject.has]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonObject.contains(property: String) = has(property)

/**
 * Determines if the [JsonArray] receiver contains the given [element]
 * This extension is inlined at call site, delegating to [JsonArray.contains]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.contains(element: String?) = contains(element.toJson())

/**
 * Determines if the [JsonArray] receiver contains the given [element]
 * This extension is inlined at call site, delegating to [JsonArray.contains]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.contains(element: Number?) = contains(element.toJson())

/**
 * Determines if the [JsonArray] receiver contains the given [element]
 * This extension is inlined at call site, delegating to [JsonArray.contains]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.contains(element: Boolean?) = contains(element.toJson())

/**
 * Determines if the [JsonArray] receiver contains the given [element]
 * This extension is inlined at call site, delegating to [JsonArray.contains]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmSynthetic
inline operator fun JsonArray.contains(element: Char?) = contains(element.toJson())
