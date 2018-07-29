@file:JvmName("Classes")

package net.cinnamon.common.reflection

import java.lang.reflect.Modifier
import kotlin.reflect.KClass
import kotlin.reflect.KVisibility

/**
 * A top-level reference to [Modifier.classModifiers]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val classModifiers get() = Modifier.classModifiers()

/**
 * A top-level reference to [Modifier.interfaceModifiers]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val interfaceModifiers get() = Modifier.interfaceModifiers()

/**
 * Determines if the modifiers of the [Class] receiver contain the `public` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Class<*>.isPublic get() = Modifier.isPublic(modifiers)

/**
 * Determines if the modifiers of the [Class] receiver contain the `private` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Class<*>.isPrivate get() = Modifier.isPrivate(modifiers)

/**
 * Determines if the modifiers of the [Class] receiver contain the `protected` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Class<*>.isProtected get() = Modifier.isProtected(modifiers)

/**
 * Determines if the modifiers of the [Class] receiver contain the `static` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Class<*>.isStatic get() = Modifier.isStatic(modifiers)

/**
 * Determines if the modifiers of the [Class] receiver contain the `final` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Class<*>.isFinal get() = Modifier.isFinal(modifiers)

/**
 * Determines if the modifiers of the [Class] receiver contain the `abstract` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Class<*>.isAbstract get() = Modifier.isAbstract(modifiers)

/**
 * Determines if the visibility of the [KClass] receiver is [KVisibility.PUBLIC]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val KClass<*>.isPublic get() = KVisibility.PUBLIC == visibility

/**
 * Determines if the visibility of the [KClass] receiver is [KVisibility.PRIVATE]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val KClass<*>.isPrivate get() = KVisibility.PRIVATE == visibility

/**
 * Determines if the visibility of the [KClass] receiver is [KVisibility.PROTECTED]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val KClass<*>.isProtected get() = KVisibility.PROTECTED == visibility

/**
 * Determines if the visibility of the [KClass] receiver is [KVisibility.INTERNAL]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val KClass<*>.isInternal get() = KVisibility.INTERNAL == visibility
