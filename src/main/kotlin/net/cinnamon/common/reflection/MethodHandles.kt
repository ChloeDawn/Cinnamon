package net.cinnamon.common.reflection

import java.lang.invoke.MethodHandles
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

inline fun <reified R : Any, reified T> methodHandle(fieldName: String) =
    object : ReadWriteProperty<R, T> {
        private val lookup = MethodHandles.lookup()
        private val field = R::class.java.findField(fieldName)
        private val getter = lookup.unreflectGetter(field)
        private val setter = lookup.unreflectSetter(field)

        override operator fun getValue(thisRef: R, property: KProperty<*>) =
            getter.invokeExact(thisRef) as T

        override operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
            setter.invokeExact(thisRef, value)
        }
    }

inline fun <reified R : Any, reified T> methodHandle(fieldName: String, crossinline setter: (R, T) -> Unit) =
    object : ReadWriteProperty<R, T> {
        private val field = R::class.java.findField(fieldName)
        private val getter = MethodHandles.lookup().unreflectGetter(field)

        override operator fun getValue(thisRef: R, property: KProperty<*>) =
            getter.invokeExact(thisRef) as T

        override operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
            setter(thisRef, value)
        }
    }

inline fun <reified R : Any, reified T> methodHandle(fieldName: String, crossinline getter: (R) -> T) =
    object : ReadWriteProperty<R, T> {
        private val field = R::class.java.findField(fieldName)
        private val setter = MethodHandles.lookup().unreflectSetter(field)

        override operator fun getValue(thisRef: R, property: KProperty<*>) =
            getter(thisRef)

        override operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
            setter.invokeExact(thisRef, value)
        }
    }

inline fun <reified R : Any, reified T> obfMethodHandle(obfFieldName: String) =
    object : ReadWriteProperty<R, T> {
        private val field = R::class.java.findObfuscatedField(obfFieldName)
        private val lookup = MethodHandles.lookup()
        private val getter = lookup.unreflectGetter(field)
        private val setter = lookup.unreflectSetter(field)

        override operator fun getValue(thisRef: R, property: KProperty<*>) =
            getter.invokeExact(thisRef) as T

        override operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
            setter.invokeExact(thisRef, value)
        }
    }

inline fun <reified R : Any, reified T> obfMethodHandle(obfFieldName: String, crossinline setter: (R, T) -> Unit) =
    object : ReadWriteProperty<R, T> {
        private val field = R::class.java.findObfuscatedField(obfFieldName)
        private val getter = MethodHandles.lookup().unreflectGetter(field)

        override operator fun getValue(thisRef: R, property: KProperty<*>) =
            getter.invokeExact(thisRef) as T

        override operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
            setter(thisRef, value)
        }
    }

inline fun <reified R : Any, reified T> obfMethodHandle(obfFieldName: String, crossinline getter: (R) -> T) =
    object : ReadWriteProperty<R, T> {
        private val field = R::class.java.findObfuscatedField(obfFieldName)
        private val setter = MethodHandles.lookup().unreflectSetter(field)

        override operator fun getValue(thisRef: R, property: KProperty<*>) =
            getter(thisRef)

        override operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
            setter.invokeExact(thisRef, value)
        }
    }

// -------------------------------------------------- STATICS ------------------------------------------------------ //

inline fun <R : Any, reified T> methodHandle(clazz: KClass<R>, fieldName: String) =
    object : ReadWriteProperty<Any?, T> {
        private val lookup = MethodHandles.lookup()
        private val field = clazz.java.findField(fieldName)
        private val getter = lookup.unreflectGetter(field)
        private val setter = lookup.unreflectSetter(field)

        override operator fun getValue(thisRef: Any?, property: KProperty<*>) =
            getter.invokeExact() as T

        override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            setter.invokeExact(value)
        }
    }

inline fun <R : Any, reified T> methodHandle(clazz: KClass<R>, fieldName: String, crossinline setter: (T) -> Unit) =
    object : ReadWriteProperty<Any?, T> {
        private val field = clazz.java.findField(fieldName)
        private val getter = MethodHandles.lookup().unreflectGetter(field)

        override operator fun getValue(thisRef: Any?, property: KProperty<*>) =
            getter.invokeExact() as T

        override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            setter(value)
        }
    }

inline fun <R : Any, reified T> methodHandle(clazz: KClass<R>, fieldName: String, crossinline getter: () -> T) =
    object : ReadWriteProperty<Any?, T> {
        private val field = clazz.java.findField(fieldName)
        private val setter = MethodHandles.lookup().unreflectSetter(field)

        override operator fun getValue(thisRef: Any?, property: KProperty<*>) =
            getter()

        override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            setter.invokeExact(value)
        }
    }

inline fun <R : Any, reified T> obfMethodHandle(clazz: KClass<R>, obfFieldName: String) =
    object : ReadWriteProperty<Any?, T> {
        private val field = clazz.java.findObfuscatedField(obfFieldName)
        private val lookup = MethodHandles.lookup()
        private val getter = lookup.unreflectGetter(field)
        private val setter = lookup.unreflectSetter(field)

        override operator fun getValue(thisRef: Any?, property: KProperty<*>) =
            getter.invokeExact() as T

        override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            setter.invokeExact(value)
        }
    }

inline fun <R : Any, reified T> obfMethodHandle(clazz: KClass<R>, obfFieldName: String, crossinline setter: (T) -> Unit) =
    object : ReadWriteProperty<Any?, T> {
        private val field = clazz.java.findObfuscatedField(obfFieldName)
        private val getter = MethodHandles.lookup().unreflectGetter(field)

        override operator fun getValue(thisRef: Any?, property: KProperty<*>) =
            getter.invokeExact() as T

        override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            setter(value)
        }
    }

inline fun <R : Any, reified T> obfMethodHandle(clazz: KClass<R>, obfFieldName: String, crossinline getter: () -> T) =
    object : ReadWriteProperty<Any?, T> {
        private val field = clazz.java.findObfuscatedField(obfFieldName)
        private val setter = MethodHandles.lookup().unreflectSetter(field)

        override operator fun getValue(thisRef: Any?, property: KProperty<*>) =
            getter()

        override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            setter.invokeExact(value)
        }
    }
