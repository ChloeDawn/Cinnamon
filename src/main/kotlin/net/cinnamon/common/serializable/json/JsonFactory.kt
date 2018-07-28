@file:JvmName("JsonFactory")

package net.cinnamon.common.serializable.json

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import java.util.function.Consumer

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

/**
 * Converts the BooleanArray receiver to a [JsonArray] of Booleans
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun BooleanArray.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the DoubleArray receiver to a [JsonArray] of Doubles
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun DoubleArray.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the FloatArray receiver to a [JsonArray] of Floats
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun FloatArray.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the LongArray receiver to a [JsonArray] of Longs
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun LongArray.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the IntArray receiver to a [JsonArray] of Ints
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun IntArray.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the CharArray receiver to a [JsonArray] of Chars
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun CharArray.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the ShortArray receiver to a [JsonArray] of Shorts
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun ShortArray.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the ByteArray receiver to a [JsonArray] of Bytes
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun ByteArray.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the Array<String> receiver to a [JsonArray] of Strings
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<String>.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the Array<JsonElement> receiver to a [JsonArray] of JsonElements
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<JsonElement>.toJson() = JsonArray().also { this.forEach(it::add) }

/**
 * Converts the Array<*> receiver to a [JsonArray] of JsonElements
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<*>.toJson() = JsonArray().also {
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

/**
 * Flattens the Array of JsonArrays into an Array of JsonElements
 * @return an Array of JsonElements collected from the JsonArrays
 * @author InsomniaKitten
 * @since 0.1.0
 */
fun Array<JsonArray>.flatten() = flatMap { it }.toTypedArray()

@DslMarker
internal annotation class JsonDslMarker

/**
 * A factory method for creating a Json object. The consumer function parameter is
 * applied to a [JsonObjectFactory], which delegates all calls to a [JsonObject]
 * @return A [JsonObject] instance with the factory changes applied
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JsonDslMarker
@JvmName("createJson")
@JvmSynthetic
fun json(json: JsonObjectFactory.() -> Unit) =
    JsonObject().also { json.invoke(JsonObjectFactory(it)) }

/**
 * A factory method for creating a Json object. The consumer function parameter is
 * applied to a [JsonObjectFactory], which delegates all calls to a [JsonObject]
 * @return A [JsonObject] instance with the factory changes applied
 * @author InsomniaKitten
 * @since 0.1.0
 */
@JsonDslMarker
@JvmName("createJson")
fun json(json: Consumer<JsonObjectFactory>) =
    JsonObject().also { json.accept(JsonObjectFactory(it)) }

@Suppress("NOTHING_TO_INLINE")
class JsonObjectFactory(private val jsonObject: JsonObject) {
    /**
     * Appends the given Boolean [value] to the receiver key in the [jsonObject]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Boolean) =
        jsonObject.addProperty(this, value)

    /**
     * Appends the given Boolean [value] to the receiver key in the [jsonObject]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Boolean) = this(value)

    /**
     * Appends the given Boolean [value] to the receiver key in the [jsonObject]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Boolean) = this(value)

    /**
     * Appends the given Char [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Char) =
        jsonObject.addProperty(this, value)

    /**
     * Appends the given Char [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Char) = this(value)

    /**
     * Appends the given Char [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Char) = this(value)

    /**
     * Appends the given Number [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Number) =
        jsonObject.addProperty(this, value)

    /**
     * Appends the given Number [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Number) = this(value)

    /**
     * Appends the given Number [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Number) = this(value)

    /**
     * Appends the given String [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: String) =
        jsonObject.addProperty(this, value)

    /**
     * Appends the given String [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: String) = this(value)

    /**
     * Appends the given String [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: String) = this(value)

    /**
     * Appends the [JsonObject] generated from the factory [obj] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("object")
    @JvmSynthetic
    operator fun String.invoke(obj: JsonObjectFactory.() -> Unit) =
        jsonObject.add(this, JsonObject().also { obj.invoke(JsonObjectFactory(it)) })

    /**
     * Appends the [JsonObject] generated from the factory [obj] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(noinline obj: JsonObjectFactory.() -> Unit) = this(obj)

    /**
     * Appends the [JsonObject] generated from the factory [obj] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(noinline obj: JsonObjectFactory.() -> Unit) = this(obj)

    /**
     * Appends the [JsonObject] generated from the factory [obj] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("object")
    operator fun String.invoke(obj: Consumer<JsonObjectFactory>) =
        jsonObject.add(this, JsonObject().also { obj.accept(JsonObjectFactory(it)) })

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("array")
    operator fun String.invoke(vararg values: Any?) =
        jsonObject.add(this, values.toJson())

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline fun String.to(vararg values: Any?) = this(*values)

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline fun String.with(vararg values: Any?) = this(*values)

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("arrayKt")
    @JvmSynthetic
    operator fun String.invoke(values: Array<Any?>) =
        jsonObject.add(this, values.toJson())

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    @JvmName("toKt")
    inline fun String.to(values: Array<Any?>) = this(values)

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    @JvmName("withKt")
    inline fun String.with(values: Array<Any?>) = this(values)
}
