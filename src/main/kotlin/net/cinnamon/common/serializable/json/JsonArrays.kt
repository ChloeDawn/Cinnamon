@file:JvmName("JsonArrays")

package net.cinnamon.common.serializable.json

import com.google.gson.JsonArray
import com.google.gson.JsonElement

/**
 * Converts the BooleanArray receiver to a [JsonArray] of Booleans
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun BooleanArray.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the DoubleArray receiver to a [JsonArray] of Doubles
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun DoubleArray.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the FloatArray receiver to a [JsonArray] of Floats
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun FloatArray.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the LongArray receiver to a [JsonArray] of Longs
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun LongArray.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the IntArray receiver to a [JsonArray] of Ints
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun IntArray.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the CharArray receiver to a [JsonArray] of Chars
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun CharArray.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the ShortArray receiver to a [JsonArray] of Shorts
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun ShortArray.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the ByteArray receiver to a [JsonArray] of Bytes
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun ByteArray.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the Array<String> receiver to a [JsonArray] of Strings
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<String>.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the Array<JsonElement> receiver to a [JsonArray] of JsonElements
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<JsonElement>.toJsonArray() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the Array<*> receiver to a [JsonArray] of JsonElements
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<*>.toJsonArray() = JsonArray().also {
    for (obj in this) when (obj) {
        is Boolean -> it.add(obj)
        is Char -> it.add(obj)
        is Number -> it.add(obj)
        is String -> it.add(obj)
        is JsonArray -> it.add(obj)
        is JsonElement -> it.add(obj)
        else -> error("Unsupported type $obj for JsonArray")
    }
}
