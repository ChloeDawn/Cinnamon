@file:JvmName("JsonObjects")
@file:JvmMultifileClass

package net.cinnamon.support.gson

import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject

/**
 * Creates a new empty [JsonObject]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonObject")
fun jsonObjectOf() = JsonObject()

/**
 * Creates a new [JsonObject] populated with the given [key] and [Boolean] [value]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonObject")
fun jsonObjectOf(key: String, value: Boolean?) = JsonObject().apply { add(key, value.toJson()) }

/**
 * Creates a new [JsonObject] populated with the given [key] and [Char] [value]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonObject")
fun jsonObjectOf(key: String, value: Char?) = JsonObject().apply { add(key, value.toJson()) }

/**
 * Creates a new [JsonObject] populated with the given [key] and [Number] [value]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonObject")
fun jsonObjectOf(key: String, value: Number?) = JsonObject().apply { add(key, value.toJson()) }

/**
 * Creates a new [JsonObject] populated with the given [key] and [String] [value]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonObject")
fun jsonObjectOf(key: String, value: String?) = JsonObject().apply { add(key, value.toJson()) }

/**
 * Creates a new [JsonObject] populated with the given [key] and [JsonElement] [value]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonObject")
fun jsonObjectOf(key: String, value: JsonElement?) = JsonObject().apply { add(key, value) }

/**
 * Creates a new [JsonObject] populated with the given [elements]
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JvmName("newJsonObject")
fun jsonObjectOf(vararg elements: Pair<String, Any?>) = JsonObject().apply {
    for ((key, value) in elements) when (value) {
        null -> add(key, JsonNull.INSTANCE)
        is Boolean -> add(key, value.toJson())
        is Char -> add(key, value.toJson())
        is Number -> add(key, value.toJson())
        is String -> add(key, value.toJson())
        is JsonElement -> add(key, value)
        else -> error("Unsupported type $value for JsonObject value")
    }
}

/**
 * Filters [JsonNull.INSTANCE] values from the receiver [JsonObject]
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun JsonObject.filterNotNull() = apply {
    val it = entrySet().iterator()
    while (it.hasNext()) {
        if (JsonNull.INSTANCE == it.next().value) {
            it.remove()
        }
    }
}
