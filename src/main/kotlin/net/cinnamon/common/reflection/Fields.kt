@file:JvmName("Fields")

package net.cinnamon.common.reflection

import java.lang.reflect.Field
import java.lang.reflect.Modifier

/**
 * A top-level reference to [Modifier.fieldModifiers]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val fieldModifiers get() = Modifier.fieldModifiers()

/**
 * A top-level reference to [Modifier.parameterModifiers]
 * @author InsomniaKitten
 * @since 0.1.0
 */
val parameterModifiers get() = Modifier.parameterModifiers()

/**
 * Determines if the modifiers of the [Field] receiver contain the `public` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isPublic get() = Modifier.isPublic(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `private` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isPrivate get() = Modifier.isPrivate(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `protected` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isProtected get() = Modifier.isProtected(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `static` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isStatic get() = Modifier.isStatic(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `final` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isFinal get() = Modifier.isFinal(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `synchronized` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isSynchronized get() = Modifier.isSynchronized(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `volatile` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isVolatile get() = Modifier.isVolatile(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `transient` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isTransient get() = Modifier.isTransient(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `native` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isNative get() = Modifier.isNative(modifiers)

/**
 * Determines if the modifiers of the [Field] receiver contain the `abstract` modifier
 * @author InsomniaKitten
 * @since 0.1.0
 */
val Field.isAbstract get() = Modifier.isAbstract(modifiers)
