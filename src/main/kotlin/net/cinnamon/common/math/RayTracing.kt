@file:JvmName("RayTracing")

package net.cinnamon.common.math

import net.minecraft.entity.Entity
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.math.RayTraceResult.Type
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import kotlin.reflect.KClass

/**
 * Determines the [RayTraceResult.typeOfHit] for the nullable receiver
 * @return [Type.MISS] if the receiver or [RayTraceResult.typeOfHit] is `null`
 * @author InsomniaKitten
 * @since 1.0.0
 */
val RayTraceResult?.typeOfHit: Type get() = this?.typeOfHit ?: Type.MISS

/**
 * Calls back to extension [typeOfHit] to determine if it is [Type.MISS]
 * @return True if the [typeOfHit] is [Type.MISS]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val RayTraceResult?.isMiss get() = Type.MISS == typeOfHit

/**
 * Calls back to extension [typeOfHit] to determine if it is [Type.BLOCK]
 * @return True if the [typeOfHit] is [Type.BLOCK]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val RayTraceResult?.isBlockHit get() = Type.BLOCK == typeOfHit

/**
 * Calls back to extension [typeOfHit] to determine if it is [Type.ENTITY]
 * @return True if the [typeOfHit] is [Type.ENTITY]
 * @author InsomniaKitten
 * @since 1.0.0
 */
val RayTraceResult?.isEntityHit get() = Type.ENTITY == typeOfHit

/**
 * Determines if the receiver is a block hit and contains the given [BlockPos] coordinates
 * @return True if [isBlockHit] and [RayTraceResult.blockPos] is equal to [pos]
 * @author InsomniaKitten
 * @since 1.0.0
 */
operator fun RayTraceResult?.contains(pos: BlockPos) =
    isBlockHit && this!!.blockPos == pos

/**
 * Determines if the receiver is an entity hit and holds a reference to the given [Entity]
 * @return True if [isEntityHit] and [RayTraceResult.entityHit] is equal to [entity]
 * @author InsomniaKitten
 * @since 1.0.0
 */
operator fun RayTraceResult?.contains(entity: Entity) =
    isEntityHit && this!!.entityHit == entity

/**
 * Determines if the receiver is an entity hit and holds an [Entity] of class matching the given [entityClass]
 * @return True if [isEntityHit] and the class of [RayTraceResult.entityHit] is equal to [entityClass]
 * @author InsomniaKitten
 * @since 1.0.0
 */
@JvmSynthetic
operator fun RayTraceResult?.contains(entityClass: KClass<out Entity>) =
    isEntityHit && this!!.entityHit::class.java == entityClass.java

/**
 * Determines if the receiver is an entity hit and holds an [Entity] of class matching the given [entityClass]
 * @return True if [isEntityHit] and the class of [RayTraceResult.entityHit] is equal to [entityClass]
 * @author InsomniaKitten
 * @since 1.0.0
 */
operator fun RayTraceResult?.contains(entityClass: Class<out Entity>) =
    isEntityHit && this!!.entityHit::class.java == entityClass

fun Iterable<AxisAlignedBB>.rayTrace(pos: BlockPos, start: Vec3d, end: Vec3d) =
    pos.toVec3d().let { vec ->
        mapNotNull { it.calculateIntercept(start - vec, end - vec) }
            .map { RayTraceResult(it.hitVec + vec, it.sideHit, pos) }
            .maxBy { it.hitVec sqrDistTo end }
    }

fun Iterable<AxisAlignedBB>.rayTrace(pos: Vec3i, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(pos.x, pos.y, pos.z), start, end)

fun Iterable<AxisAlignedBB>.rayTrace(pos: Vec3d, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(pos.x, pos.y, pos.z), start, end)

fun Iterable<AxisAlignedBB>.rayTrace(x: Int, y: Int, z: Int, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(x, y, z), start, end)

fun Iterable<AxisAlignedBB>.rayTrace(x: Double, y: Double, z: Double, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(x, y, z), start, end)

fun Iterable<AxisAlignedBB>.rayTrace(entity: Entity, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(entity), start, end)

fun Array<AxisAlignedBB>.rayTrace(pos: BlockPos, start: Vec3d, end: Vec3d) =
    pos.toVec3d().let { vec ->
        mapNotNull { it.calculateIntercept(start - vec, end - vec) }
            .map { RayTraceResult(it.hitVec + vec, it.sideHit, pos) }
            .maxBy { it.hitVec.squareDistanceTo(end) }
    }

fun Array<AxisAlignedBB>.rayTrace(pos: Vec3i, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(pos.x, pos.y, pos.z), start, end)

fun Array<AxisAlignedBB>.rayTrace(pos: Vec3d, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(pos.x, pos.y, pos.z), start, end)

fun Array<AxisAlignedBB>.rayTrace(x: Int, y: Int, z: Int, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(x, y, z), start, end)

fun Array<AxisAlignedBB>.rayTrace(x: Double, y: Double, z: Double, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(x, y, z), start, end)

fun Array<AxisAlignedBB>.rayTrace(entity: Entity, start: Vec3d, end: Vec3d) =
    rayTrace(BlockPos(entity), start, end)
