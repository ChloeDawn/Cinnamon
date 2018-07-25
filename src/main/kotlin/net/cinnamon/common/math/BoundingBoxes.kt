@file:JvmName("BoundingBoxes")

package net.cinnamon.common.math

import net.minecraft.util.EnumFacing
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i

@JvmField val FULL_CUBE = boundingBoxOf(0.0, 0.0, 0.0, 1.0, 1.0, 1.0)
@JvmField val LOWER_HALF = boundingBoxOf(0.0, 0.0, 0.0, 1.0, 0.5, 1.0)
@JvmField val UPPER_HALF = boundingBoxOf(0.0, 0.5, 0.0, 1.0, 1.0, 1.0)

@JvmName("newBoundingBox")
fun boundingBoxOf(minX: Int, minY: Int, minZ: Int, maxX: Int, maxY: Int, maxZ: Int) =
    AxisAlignedBB(
        minX.toDouble(),
        minY.toDouble(),
        minZ.toDouble(),
        maxX.toDouble(),
        maxY.toDouble(),
        maxZ.toDouble()
    )

@JvmName("newBoundingBox")
fun boundingBoxOf(minX: Double, minY: Double, minZ: Double, maxX: Double, maxY: Double, maxZ: Double) =
    AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ)

@JvmName("newBoundingBox")
fun boundingBoxOf(pos: Vec3i) =
    AxisAlignedBB(
        pos.x.toDouble(),
        pos.y.toDouble(),
        pos.z.toDouble(),
        pos.x.toDouble() + 1.0,
        pos.y.toDouble() + 1.0,
        pos.z.toDouble() + 1.0
    )

@JvmName("newBoundingBox")
fun boundingBoxOf(min: Vec3i, max: Vec3i) =
    AxisAlignedBB(
        min.x.toDouble(),
        min.y.toDouble(),
        min.z.toDouble(),
        max.x.toDouble(),
        max.y.toDouble(),
        max.z.toDouble()
    )

@JvmName("newBoundingBox")
fun boundingBoxOf(min: Vec3d, max: Vec3d) =
    AxisAlignedBB(min.x, min.y, min.z, max.x, max.y, max.z)

@Deprecated("To be removed and replaced with matrix based transformers")
@Suppress("DeprecatedCallableAddReplaceWith")
infix fun AxisAlignedBB.rotateTo(facing: EnumFacing) = when (facing) {
    EnumFacing.DOWN -> AxisAlignedBB(maxX - 1, minZ, maxY - 1, minX - 1, maxZ, minY - 1)
    EnumFacing.UP -> AxisAlignedBB(minX, maxZ - 1, minY, maxX, minZ - 1, maxY)
    EnumFacing.NORTH -> AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ)
    EnumFacing.SOUTH -> AxisAlignedBB(maxX - 1, minY, maxZ - 1, minX - 1, maxY, minZ - 1)
    EnumFacing.WEST -> AxisAlignedBB(minZ, minY, maxX - 1, maxZ, maxY, minX - 1)
    EnumFacing.EAST -> AxisAlignedBB(maxZ - 1, minY, minX, minZ - 1, maxY, maxX)
}

/**
 * Infix equivalent of [AxisAlignedBB.grow] for Kotlin use
 */
@JvmSynthetic
operator fun AxisAlignedBB.plus(vec: Vec3d): AxisAlignedBB = grow(vec)

@JvmSynthetic
operator fun AxisAlignedBB.minus(vec: Vec3d): AxisAlignedBB = shrink(vec)

@JvmSynthetic
infix fun AxisAlignedBB.contract(vec: Vec3d): AxisAlignedBB = contract(vec.x, vec.y, vec.z)

@JvmSynthetic
infix fun AxisAlignedBB.expand(vec: Vec3d): AxisAlignedBB = expand(vec.x, vec.y, vec.z)

@JvmSynthetic
infix fun AxisAlignedBB.grow(vec: Vec3d): AxisAlignedBB = grow(vec.x, vec.y, vec.z)

@JvmSynthetic
infix fun AxisAlignedBB.shrink(vec: Vec3d): AxisAlignedBB = grow(-vec.x, -vec.y, -vec.z)

@JvmSynthetic
infix fun AxisAlignedBB.grow(amount: Double): AxisAlignedBB = grow(amount)

@JvmSynthetic
infix fun AxisAlignedBB.shrink(amount: Double): AxisAlignedBB = shrink(amount)

@JvmSynthetic
infix fun AxisAlignedBB.intersect(other: AxisAlignedBB): AxisAlignedBB = intersect(other)

@JvmSynthetic
infix fun AxisAlignedBB.union(other: AxisAlignedBB): AxisAlignedBB = union(other)

@JvmSynthetic
infix fun AxisAlignedBB.offset(pos: BlockPos): AxisAlignedBB = offset(pos)

@JvmSynthetic
infix fun AxisAlignedBB.offset(vec: Vec3d): AxisAlignedBB = offset(vec)

@JvmSynthetic
infix fun AxisAlignedBB.intersects(other: AxisAlignedBB): Boolean = intersects(other)
