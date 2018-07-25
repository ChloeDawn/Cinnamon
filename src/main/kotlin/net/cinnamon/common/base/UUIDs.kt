@file:JvmName("UUIDs")

package net.cinnamon.common.base

import java.util.Random
import java.util.UUID
import net.minecraft.util.math.MathHelper as Mth

val randomUUID: UUID
    @JvmName("randomUUID")
    get() = Mth.getRandomUUID()

@JvmSynthetic
fun uuidOf(): UUID = randomUUID

@JvmName("newUUID")
fun uuidOf(rand: Random): UUID = Mth.getRandomUUID(rand)

@JvmName("newUUID")
fun uuidOf(seed: Long): UUID = Mth.getRandomUUID(Random(seed))

@JvmName("newUUID")
fun uuidOf(uuid: String): UUID = UUID.fromString(uuid)

@JvmName("newUUID")
fun uuidOf(least: Long, most: Long): UUID = UUID(least, most)
