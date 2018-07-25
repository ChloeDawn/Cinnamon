@file:JvmName("Pairs")

package net.cinnamon.common.collection

infix fun <K, V> K.of(other: V) = Pair(other, this)

infix fun <K, V> K.from(other: V) = Pair(other, this)

infix fun <K, V> K.and(other: V) = Pair(this, other)

infix fun <K, V> K.with(other: V) = Pair(this, other)

infix fun <K, V> K.on(other: V) = Pair(this, other)
