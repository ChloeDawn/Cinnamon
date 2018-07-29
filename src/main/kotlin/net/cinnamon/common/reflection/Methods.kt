@file:JvmName("Methods")

package net.cinnamon.common.reflection

import java.lang.reflect.Method
import java.lang.reflect.Modifier

/**
 * A top-level reference to [Modifier.methodModifiers]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val methodModifiers get() = Modifier.methodModifiers()

/**
 * Determines if the modifiers of the [Method] receiver contain the `public` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Method.isPublic get() = Modifier.isPublic(modifiers)

/**
 * Determines if the modifiers of the [Method] receiver contain the 'private` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Method.isPrivate get() = Modifier.isPrivate(modifiers)

/**
 * Determines if the modifiers of the [Method] receiver contain the `protected` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Method.isProtected get() = Modifier.isProtected(modifiers)

/**
 * Determines if the modifiers of the [Method] receiver contain the `static` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Method.isStatic get() = Modifier.isStatic(modifiers)

/**
 * Determines if the modifiers of the [Method] receiver contain the `final` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Method.isFinal get() = Modifier.isFinal(modifiers)

/**
 * Determines if the modifiers of the [Method] receiver contain the `synchronized` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Method.isSynchronized get() = Modifier.isSynchronized(modifiers)

/**
 * Determines if the modifiers of the [Method] receiver contain the `native` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Method.isNative get() = Modifier.isNative(modifiers)

/**
 * Determines if the modifiers of the [Method] receiver contain the `abstract` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Method.isAbstract get() = Modifier.isAbstract(modifiers)
