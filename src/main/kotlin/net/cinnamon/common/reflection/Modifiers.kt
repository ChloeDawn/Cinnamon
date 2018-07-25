@file:JvmName("Modifiers")

package net.cinnamon.common.reflection

import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import kotlin.reflect.KClass
import kotlin.reflect.KVisibility

val classModifiers get() = Modifier.classModifiers()
val interfaceModifiers get() = Modifier.interfaceModifiers()
val constructorModifiers get() = Modifier.constructorModifiers()
val methodModifiers get() = Modifier.methodModifiers()
val fieldModifiers get() = Modifier.fieldModifiers()
val parameterModifiers get() = Modifier.parameterModifiers()

val Field.isPublic get() = Modifier.isPublic(this.modifiers)
val Field.isPrivate get() = Modifier.isPrivate(this.modifiers)
val Field.isProtected get() = Modifier.isProtected(this.modifiers)
val Field.isStatic get() = Modifier.isStatic(this.modifiers)
val Field.isFinal get() = Modifier.isFinal(this.modifiers)
val Field.isSynchronized get() = Modifier.isSynchronized(this.modifiers)
val Field.isVolatile get() = Modifier.isVolatile(this.modifiers)
val Field.isTransient get() = Modifier.isTransient(this.modifiers)
val Field.isNative get() = Modifier.isNative(this.modifiers)
val Field.isAbstract get() = Modifier.isAbstract(this.modifiers)

val Method.isPublic get() = Modifier.isPublic(this.modifiers)
val Method.isPrivate get() = Modifier.isPrivate(this.modifiers)
val Method.isProtected get() = Modifier.isProtected(this.modifiers)
val Method.isStatic get() = Modifier.isStatic(this.modifiers)
val Method.isFinal get() = Modifier.isFinal(this.modifiers)
val Method.isSynchronized get() = Modifier.isSynchronized(this.modifiers)
val Method.isNative get() = Modifier.isNative(this.modifiers)
val Method.isAbstract get() = Modifier.isAbstract(this.modifiers)

val Constructor<*>.isPublic get() = Modifier.isPublic(this.modifiers)
val Constructor<*>.isPrivate get() = Modifier.isPrivate(this.modifiers)
val Constructor<*>.isProtected get() = Modifier.isProtected(this.modifiers)

val Class<*>.isPublic get() = Modifier.isPublic(this.modifiers)
val Class<*>.isPrivate get() = Modifier.isPrivate(this.modifiers)
val Class<*>.isProtected get() = Modifier.isProtected(this.modifiers)
val Class<*>.isStatic get() = Modifier.isStatic(this.modifiers)
val Class<*>.isFinal get() = Modifier.isFinal(this.modifiers)
val Class<*>.isAbstract get() = Modifier.isAbstract(this.modifiers)

val KClass<*>.isPublic get() = this.visibility == KVisibility.PUBLIC
val KClass<*>.isPrivate get() = this.visibility == KVisibility.PRIVATE
val KClass<*>.isProtected get() = this.visibility == KVisibility.PROTECTED
val KClass<*>.isInternal get() = this.visibility == KVisibility.INTERNAL
