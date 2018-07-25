@file:JvmName("BlockPositions")

package net.cinnamon.common.math

import net.minecraft.entity.Entity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.BlockPos.MutableBlockPos
import net.minecraft.util.math.BlockPos.PooledMutableBlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import java.util.function.Consumer

val BlockPos.isMutable
    get() = this is MutableBlockPos

val BlockPos.isImmutable
    get() = BlockPos::class.java == javaClass

@JvmName("newBlockPos")
fun posOf(x: Int = 0, y: Int = 0, z: Int = 0): BlockPos =
    BlockPos(x, y, z)

@JvmName("newBlockPos")
fun posOf(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): BlockPos =
    BlockPos(x, y, z)

@JvmName("newBlockPos")
fun posOf(entity: Entity): BlockPos =
    BlockPos(entity)

@JvmName("newMutableBlockPos")
fun mutablePosOf(): MutableBlockPos =
    MutableBlockPos()

@JvmName("newMutableBlockPos")
fun mutablePosOf(x: Int = 0, y: Int = 0, z: Int = 0): MutableBlockPos =
    MutableBlockPos(x, y, z)

@JvmName("newMutableBlockPos")
fun mutablePosOf(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): MutableBlockPos =
    MutableBlockPos(BlockPos(x, y, z))

@JvmName("newMutableBlockPos")
fun mutablePosOf(entity: Entity): MutableBlockPos =
    MutableBlockPos(
        floorToInt(entity.posX),
        floorToInt(entity.posY),
        floorToInt(entity.posZ)
    )

@JvmName("getPooledBlockPos")
fun pooledPosOf(): PooledMutableBlockPos =
    PooledMutableBlockPos.retain()

@JvmName("getPooledBlockPos")
fun pooledPosOf(x: Int = 0, y: Int = 0, z: Int = 0): PooledMutableBlockPos =
    PooledMutableBlockPos.retain(x, y, z)

@JvmName("getPooledBlockPos")
fun pooledPosOf(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): PooledMutableBlockPos =
    PooledMutableBlockPos.retain(x, y, z)

@JvmName("getPooledBlockPos")
fun pooledPosOf(vec: Vec3i): PooledMutableBlockPos =
    PooledMutableBlockPos.retain(vec)

@JvmName("getPooledBlockPos")
fun pooledPosOf(action: Consumer<PooledMutableBlockPos>) =
    PooledMutableBlockPos.retain().also(action::accept).release()

@JvmName("getPooledBlockPos")
fun pooledPosOf(x: Int = 0, y: Int = 0, z: Int = 0, action: Consumer<PooledMutableBlockPos>) =
    PooledMutableBlockPos.retain(x, y, z).also(action::accept).release()

@JvmName("getPooledBlockPos")
fun pooledPosOf(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, action: Consumer<PooledMutableBlockPos>) =
    PooledMutableBlockPos.retain(x, y, z).also(action::accept).release()

@JvmName("getPooledBlockPos")
fun pooledPosOf(vec: Vec3i, action: Consumer<PooledMutableBlockPos>) =
    PooledMutableBlockPos.retain(vec).also(action::accept).release()

@JvmSynthetic
inline fun pooledPosOf(action: (PooledMutableBlockPos) -> Unit) =
    PooledMutableBlockPos.retain().apply(action).release()

@JvmSynthetic
inline fun pooledPosOf(x: Int = 0, y: Int = 0, z: Int = 0, action: (PooledMutableBlockPos) -> Unit) =
    PooledMutableBlockPos.retain(x, y, z).apply(action).release()

@JvmSynthetic
inline fun pooledPosOf(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, action: (PooledMutableBlockPos) -> Unit) =
    PooledMutableBlockPos.retain(x, y, z).apply(action).release()

@JvmSynthetic
inline fun pooledPosOf(vec: Vec3i, action: (PooledMutableBlockPos) -> Unit) =
    PooledMutableBlockPos.retain(vec).apply(action).release()

@JvmName("getAllInRange")
infix fun BlockPos.rangeTo(other: BlockPos): Iterable<BlockPos> =
    BlockPos.getAllInBox(this, other)

@JvmName("getAllInRange")
infix fun MutableBlockPos.rangeTo(other: BlockPos): Iterable<MutableBlockPos> =
    MutableBlockPos.getAllInBoxMutable(this, other)

@JvmSynthetic
fun Vec3i.toBlockPos() =
    this as? BlockPos ?: BlockPos(this)

@JvmSynthetic
fun Vec3d.toBlockPos() = BlockPos(this)

@JvmSynthetic
fun BlockPos.toMutable(): MutableBlockPos =
    this as? MutableBlockPos
    ?: MutableBlockPos(this)

@JvmSynthetic
fun BlockPos.toPooled(): PooledMutableBlockPos =
    this as? PooledMutableBlockPos
    ?: PooledMutableBlockPos.retain(this)

@JvmSynthetic
fun BlockPos.toPooled(action: (PooledMutableBlockPos) -> Unit) =
    if (this is PooledMutableBlockPos) {
        this.apply(action).release()
    } else pooledPosOf(this, action)

@JvmSynthetic
infix fun BlockPos.cross(other: BlockPos): BlockPos =
    crossProduct(other)
