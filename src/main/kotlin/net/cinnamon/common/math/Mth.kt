@file:JvmName("Mth")
@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.common.math

import net.minecraft.util.math.MathHelper

fun toRadians(degrees: Double) = Math.toRadians(degrees)
fun toRadians(degrees: Float) = Math.toRadians(degrees.toDouble())
fun toDegrees(radians: Double) = Math.toDegrees(radians)
fun toDegrees(radians: Float) = Math.toDegrees(radians.toDouble())

fun ceilToInt(value: Float) = MathHelper.ceil(value)
fun ceilToInt(value: Double) = MathHelper.ceil(value)
fun floorToInt(value: Double) = MathHelper.floor(value)
fun floorToInt(value: Float) = MathHelper.floor(value)

@JvmName("ceilKt")
@JvmSynthetic
inline fun Float.ceil() = kotlin.math.ceil(this)

@JvmName("ceilKt")
@JvmSynthetic
inline fun Double.ceil() = kotlin.math.ceil(this)

@JvmName("floorKt")
@JvmSynthetic
inline fun Float.floor() = kotlin.math.floor(this)

@JvmName("floorKt")
@JvmSynthetic
inline fun Double.floor() = kotlin.math.floor(this)

@JvmName("ceilToIntKt")
@JvmSynthetic
inline fun Float.ceilToInt() = ceilToInt(this)

@JvmName("ceilToIntKt")
@JvmSynthetic
inline fun Double.ceilToInt() = ceilToInt(this)

@JvmName("floorToIntKt")
@JvmSynthetic
inline fun Double.floorToInt() = floorToInt(this)

@JvmName("floorToIntKt")
@JvmSynthetic
inline fun Float.floorToInt() = floorToInt(this)
