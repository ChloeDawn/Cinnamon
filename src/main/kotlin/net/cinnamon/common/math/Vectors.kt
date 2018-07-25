@file:JvmName("Vectors")
@file:Suppress("NOTHING_TO_INLINE")

package net.cinnamon.common.math

import com.google.common.collect.AbstractIterator
import net.cinnamon.common.entity.getPosition
import net.minecraft.entity.Entity
import net.minecraft.util.math.Vec2f
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

/**
 * Constructs a [Vec3i] from the given [x], [y], and [z]
 */
@JvmName("newVector")
fun vecOf(x: Int, y: Int, z: Int) = Vec3i(x, y, z)

/**
 * Constructs a [Vec3d] from the given [x], [y], and [z]
 */
@JvmName("newVector")
fun vecOf(x: Double, y: Double, z: Double) = Vec3d(x, y, z)

/**
 * Constructs a [Vec3d] from the position of the given [Entity]
 */
@JvmName("newVector")
fun vecOf(entity: Entity) = Vec3d(entity.posX, entity.posY, entity.posZ)

/**
 * Constructs a [Vec3d] from the interpolated position of the given [Entity]
 * Vector interpolation is smoothed using the given [partialTicks]
 */
@JvmName("newVector")
fun vecOf(entity: Entity, partialTicks: Float) = entity.getPosition(partialTicks)

/**
 * Constructs a [Vec2f] from the given [x] and [y]
 */
@SideOnly(Side.CLIENT)
@JvmName("newVector")
fun vecOf(x: Float, y: Float) = Vec2f(x, y)

/**
 * Constructs a [Vec2f] from the given [x] and [y]
 */
@SideOnly(Side.CLIENT)
@JvmName("newVector")
fun vecOf(x: Int, y: Int) = Vec2f(x.toFloat(), y.toFloat())

/**
 * Constructs a of [Vec2f] from the given [x] and [y]
 */
@SideOnly(Side.CLIENT)
@JvmName("newVector")
fun vecOf(x: Double, y: Double) = Vec2f(x.toFloat(), y.toFloat())

/**
 * Constructs a [Vec3d] object from the receiver
 */
@JvmSynthetic
fun Vec3i.toVec3d() = Vec3d(this)

/**
 * Constructs a [Vec3i] object from the receiver
 */
@JvmSynthetic
fun Vec3d.toVec3i() = Vec3i(x, y, z)

/**
 * Returns the value of the receiver with [vec] added
 */
@JvmSynthetic
operator fun Vec3i.plus(vec: Vec3i) = Vec3i(x + vec.x, y + vec.y, z + vec.z)

/**
 * Returns the value of the receiver with [vec] added
 */
@JvmSynthetic
operator fun Vec3d.plus(vec: Vec3d) = Vec3d(x + vec.x, y + vec.y, z + vec.z)

/**
 * Returns the value of the receiver with [vec] subtracted
 */
@JvmSynthetic
operator fun Vec3i.minus(vec: Vec3i) = Vec3i(x - vec.x, y - vec.y, z - vec.z)

/**
 * Returns the value of the receiver with [vec] subtracted
 */
@JvmSynthetic
operator fun Vec3d.minus(vec: Vec3d) = Vec3d(x - vec.x, y - vec.y, z - vec.z)

/**
 * Calculates the dot product [Int] of the receiver and [other]
 */
infix fun Vec3i.dot(other: Vec3i): Int = dotProduct(other)

/**
 * Calculates the dot product [Double] of the receiver and [other]
 */
infix fun Vec3d.dot(other: Vec3d): Double = dotProduct(other)

/**
 * Calculates the cross product [Vec3i] of the receiver and [other]
 */
infix fun Vec3i.cross(other: Vec3i): Vec3i = crossProduct(other)

/**
 * Calculates the cross product [Vec3d] of the receiver and [other]
 */
infix fun Vec3d.cross(other: Vec3d): Vec3d = crossProduct(other)

/**
 * This exists to provide the function that Mojang never implemented
 * For most operations, [Vec3i.dot] can be used in place of this
 */
@JvmSynthetic
fun Vec3i.dotProduct(vec: Vec3i) = x * vec.x + y * vec.y + z * vec.z

/**
 * Infix equivalent of [Vec3d.distanceTo]
 */
@JvmSynthetic
inline infix fun Vec3d.distTo(vec: Vec3d) = distanceTo(vec)

/**
 * Infix equivalent of [Vec3d.squareDistanceTo]
 */
@JvmSynthetic
inline infix fun Vec3d.sqrDistTo(vec: Vec3d) = squareDistanceTo(vec)

/**
 * Infix equivalent of [Vec3i.getDistance]
 */
@JvmSynthetic
inline infix fun Vec3i.distTo(vec: Vec3i) = getDistance(vec.x, vec.y, vec.z)

/**
 * Infix equivalent of [Vec3i.distanceSq]
 */
@JvmSynthetic
inline infix fun Vec3i.sqrDistTo(vec: Vec3i) = distanceSq(vec)

/**
 * Creates an [Vec3i] [Iterable] with a range between the receiver and [max]
 */
@JvmName("rangeOf")
fun Vec3i.rangeTo(max: Vec3i): Iterable<Vec3i> = object : Iterable<Vec3i> {
    override fun iterator() = object : AbstractIterator<Vec3i>() {
        private var lastX = x - 1
        private var lastY = y - 1
        private var lastZ = z - 1

        override fun computeNext() =
            if (lastX != max.x || lastY != max.y || lastZ != max.z) {
                when {
                    lastX < max.x -> {
                        ++lastX
                    }
                    lastY < max.y -> {
                        lastX = x
                        ++lastY
                    }
                    lastZ < max.z -> {
                        lastX = x
                        lastY = y
                        ++lastZ
                    }
                }
                Vec3i(lastX, lastY, lastZ)
            } else endOfData()
    }
}

/**
 * Creates a [Vec3d] [Iterable] with a range between the receiver and [max]
 */
@JvmName("rangeOf")
fun Vec3d.rangeTo(max: Vec3d): Iterable<Vec3d> = object : Iterable<Vec3d> {
    override fun iterator() = object : AbstractIterator<Vec3d>() {
        private var lastX = x - 1.0
        private var lastY = y - 1.0
        private var lastZ = z - 1.0

        override fun computeNext() =
            if (lastX != max.x || lastY != max.y || lastZ != max.z) {
                when {
                    lastX < max.x -> {
                        ++lastX
                    }
                    lastY < max.y -> {
                        lastX = x
                        ++lastY
                    }
                    lastZ < max.z -> {
                        lastX = x
                        lastY = y
                        ++lastZ
                    }
                }
                Vec3d(lastX, lastY, lastZ)
            } else endOfData()
    }
}
