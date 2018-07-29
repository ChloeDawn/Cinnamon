@file:JvmName("Constructors")

package net.cinnamon.common.reflection

import java.lang.reflect.Constructor
import java.lang.reflect.Modifier

/**
 * A top-level reference to [Modifier.constructorModifiers]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val constructorModifiers get() = Modifier.constructorModifiers()

/**
 * Determines if the modifiers of the [Constructor] receiver contain the `public` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Constructor<*>.isPublic get() = Modifier.isPublic(modifiers)

/**
 * Determines if the modifiers of the [Constructor] receiver contain the `private` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Constructor<*>.isPrivate get() = Modifier.isPrivate(modifiers)

/**
 * Determines if the modifiers of the [Constructor] receiver contain the `protected` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Constructor<*>.isProtected get() = Modifier.isProtected(modifiers)
