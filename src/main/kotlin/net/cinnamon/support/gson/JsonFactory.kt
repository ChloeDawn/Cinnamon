@file:JvmName("JsonFactory")

package net.cinnamon.support.gson

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.jetbrains.annotations.Nullable
import java.util.function.Consumer

@DslMarker
private annotation class JsonDslMarker

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
    operator fun String.invoke(value: Boolean?) =
        jsonObject.addProperty(this, value)

    /**
     * Appends the given Boolean [value] to the receiver key in the [jsonObject]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Boolean?) = this(value)

    /**
     * Appends the given Boolean [value] to the receiver key in the [jsonObject]
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Boolean?) = this(value)

    /**
     * Appends the given Char [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Char?) =
        jsonObject.addProperty(this, value)

    /**
     * Appends the given Char [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Char?) = this(value)

    /**
     * Appends the given Char [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Char?) = this(value)

    /**
     * Appends the given Number [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: Number?) =
        jsonObject.addProperty(this, value)

    /**
     * Appends the given Number [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: Number?) = this(value)

    /**
     * Appends the given Number [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: Number?) = this(value)

    /**
     * Appends the given String [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("add")
    operator fun String.invoke(value: String?) =
        jsonObject.addProperty(this, value)

    /**
     * Appends the given String [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(value: String?) = this(value)

    /**
     * Appends the given String [value] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(value: String?) = this(value)

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
    operator fun String.invoke(@Nullable vararg values: Any?) =
        jsonObject.add(this, values.toJsonArray())

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline fun String.to(@Nullable vararg values: Any?) = this(*values)

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline fun String.with(@Nullable vararg values: Any?) = this(*values)

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("arrayKt")
    @JvmSynthetic
    operator fun String.invoke(values: Array<out Any?>) =
        jsonObject.add(this, values.toJsonArray())

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    @JvmName("toKt")
    inline infix fun String.to(values: Array<out Any?>) = this(values)

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    @JvmName("withKt")
    inline infix fun String.with(values: Array<out Any?>) = this(values)

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmName("array")
    operator fun String.invoke(values: Collection<Any?>) =
        jsonObject.add(this, values.toTypedArray().toJsonArray())

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.to(values: Collection<Any?>) = this(values)

    /**
     * Appends a [JsonArray] containing the given [values] to the receiver key in the [jsonObject] delegate
     * @author InsomniaKitten
     * @since 0.1.0
     */
    @JvmSynthetic
    inline infix fun String.with(values: Collection<Any?>) = this(values)
}
