@file:JvmName("Randoms")

package net.cinnamon.common.math

import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import java.util.Random
import java.util.stream.DoubleStream
import java.util.stream.IntStream
import java.util.stream.LongStream

val Vec3i.coordinateRandom
    @JvmName("coordinateRandom")
    get() = MathHelper.getCoordinateRandom(x, y, z)

val Vec3d.coordinateRandom
    @JvmName("coordinateRandom")
    get() = toVec3i().coordinateRandom

fun Random.withSeed(seed: Long) =
    apply { setSeed(seed) }

@JvmOverloads
fun randInt(bound: Int = 32, rand: Random = Random()): Int =
    rand.nextInt(bound)

@JvmOverloads
fun randLong(rand: Random = Random()): Long =
    rand.nextLong()

@JvmOverloads
fun randBoolean(rand: Random = Random()): Boolean =
    rand.nextBoolean()

@JvmOverloads
fun randFloat(rand: Random = Random()): Float =
    rand.nextFloat()

@JvmOverloads
fun randDouble(rand: Random = Random()): Double =
    rand.nextDouble()

@JvmOverloads
fun randGaussian(rand: Random = Random()): Double =
    rand.nextGaussian()

@JvmOverloads
fun randInts(
    rand: Random = Random(),
    size: Long = Long.MAX_VALUE,
    origin: Int = Int.MAX_VALUE,
    bound: Int = 0
): IntStream = rand.ints(size, origin, bound)

@JvmOverloads
fun randLongs(
    rand: Random = Random(),
    size: Long = Long.MAX_VALUE,
    origin: Long = Long.MAX_VALUE,
    bound: Long = 0L
): LongStream = rand.longs(size, origin, bound)

@JvmOverloads
fun randDoubles(
    rand: Random = Random(),
    size: Long = Long.MAX_VALUE,
    origin: Double = Double.MAX_VALUE,
    bound: Double = 0.0
): DoubleStream = rand.doubles(size, origin, bound)
