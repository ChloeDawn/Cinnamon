@file:JvmName("Worlds")

package net.cinnamon.common.world

import net.cinnamon.common.block.getExtendedState
import net.minecraft.block.material.MapColor
import net.minecraft.block.state.BlockFaceShape
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.EnumDyeColor
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.NonNullList
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.math.Vec3d
import net.minecraft.world.Explosion
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.common.IPlantable
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

fun World.rotateBlock(pos: BlockPos, axis: EnumFacing) =
    getBlockState(pos).block.rotateBlock(this, pos, axis)

fun World.recolorBlock(pos: BlockPos, side: EnumFacing, color: EnumDyeColor) =
    getBlockState(pos).block.recolorBlock(this, pos, side, color)

fun IBlockAccess.isReplaceable(pos: BlockPos) =
    getBlockState(pos).block.isReplaceable(this, pos)

fun IBlockAccess.getActualState(pos: BlockPos): IBlockState =
    getBlockState(pos).getActualState(this, pos)

fun IBlockAccess.getExtendedState(pos: BlockPos) =
    getBlockState(pos).getExtendedState(this, pos)

fun IBlockAccess.doesSideBlockRendering(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).doesSideBlockRendering(this, pos, side)

fun IBlockAccess.canEntitySpawn(pos: BlockPos, entity: Entity) =
    getBlockState(pos).canEntitySpawn(entity)

fun IBlockAccess.getLightOpacity(pos: BlockPos) =
    getBlockState(pos).let { it.block.getLightOpacity(it, this, pos) }

fun IBlockAccess.getLightValue(pos: BlockPos) =
    getBlockState(pos).getLightValue(this, pos)

fun IBlockAccess.getMapColor(pos: BlockPos): MapColor =
    getBlockState(pos).getMapColor(this, pos)

fun IBlockAccess.getPackedLightmapCoords(pos: BlockPos) =
    getBlockState(pos).getPackedLightmapCoords(this, pos)

fun IBlockAccess.getWeakPower(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).getWeakPower(this, pos, side)

fun World.getComparatorOutput(pos: BlockPos) =
    getBlockState(pos).getComparatorInputOverride(this, pos)

fun World.getBlockHardness(pos: BlockPos) =
    getBlockState(pos).getBlockHardness(this, pos)

fun World.getBlockHardness(pos: BlockPos, player: EntityPlayer) =
    getBlockState(pos).getPlayerRelativeBlockHardness(player, this, pos)

@SideOnly(Side.CLIENT)
fun World.getSelectedBoundingBox(pos: BlockPos): AxisAlignedBB =
    getBlockState(pos).getSelectedBoundingBox(this, pos)

fun IBlockAccess.getCollisionBoundingBox(pos: BlockPos): AxisAlignedBB? =
    getBlockState(pos).getCollisionBoundingBox(this, pos)

@SideOnly(Side.CLIENT)
fun IBlockAccess.shouldSideBeRendered(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).shouldSideBeRendered(this, pos, side)

fun IBlockAccess.getBoundingBox(pos: BlockPos): AxisAlignedBB =
    getBlockState(pos).getBoundingBox(this, pos)

fun World.collisionRayTrace(pos: BlockPos, start: Vec3d, end: Vec3d): RayTraceResult? =
    getBlockState(pos).collisionRayTrace(this, pos, start, end)

fun IBlockAccess.isSideSolid(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).isSideSolid(this, pos, side)

fun IBlockAccess.doesSideBlockChestOpening(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).doesSideBlockChestOpening(this, pos, side)

fun IBlockAccess.getBlockFaceShape(pos: BlockPos, side: EnumFacing): BlockFaceShape =
    getBlockState(pos).getBlockFaceShape(this, pos, side)

fun IBlockAccess.isPassable(pos: BlockPos) =
    getBlockState(pos).block.isPassable(this, pos)

@JvmOverloads
fun IBlockAccess.getSlipperiness(pos: BlockPos, entity: Entity? = null) =
    getBlockState(pos).let { it.block.getSlipperiness(it, this, pos, entity) }

@JvmOverloads
fun IBlockAccess.isLadder(pos: BlockPos, entity: EntityLivingBase? = null) =
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    // `entity` can be nullable, according to javadoc on method
    getBlockState(pos).let { it.block.isLadder(it, this, pos, entity) }

fun IBlockAccess.isNormalCube(pos: BlockPos) =
    getBlockState(pos).let { it.block.isNormalCube(it, this, pos) }

fun IBlockAccess.isBurning(pos: BlockPos) =
    getBlockState(pos).block.isBurning(this, pos)

fun IBlockAccess.getFlammability(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).block.getFlammability(this, pos, side)

fun IBlockAccess.isFlammable(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).block.isFlammable(this, pos, side)

fun IBlockAccess.getFireSpread(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).block.getFireSpreadSpeed(this, pos, side)

fun World.isFireSource(pos: BlockPos, side: EnumFacing) =
    getBlockState(pos).block.isFireSource(this, pos, side)

fun IBlockAccess.hasTileEntity(pos: BlockPos) =
    getBlockState(pos).let { it.block.hasTileEntity(it) }

fun IBlockAccess.getDrops(pos: BlockPos, drops: NonNullList<ItemStack>, fortune: Int) =
    getBlockState(pos).let { it.block.getDrops(drops, this, pos, it, fortune) }

@JvmOverloads
fun IBlockAccess.getDrops(pos: BlockPos, fortune: Int = 0): NonNullList<ItemStack> =
    NonNullList.create<ItemStack>().also { getDrops(pos, it, fortune) }

fun World.canSilkHarvest(pos: BlockPos, player: EntityPlayer) =
    getBlockState(pos).let { it.block.canSilkHarvest(this, pos, it, player) }

fun IBlockAccess.canCreatureSpawn(pos: BlockPos, type: EntityLiving.SpawnPlacementType) =
    getBlockState(pos).let { it.block.canCreatureSpawn(it, this, pos, type) }

@JvmOverloads
fun IBlockAccess.isBed(pos: BlockPos, player: EntityPlayer? = null) =
    getBlockState(pos).let { it.block.isBed(it, this, pos, player) }

fun IBlockAccess.canSustainLeaves(pos: BlockPos) =
    getBlockState(pos).let { it.block.canSustainLeaves(it, this, pos) }

fun IBlockAccess.canBeReplacedByLeaves(pos: BlockPos) =
    getBlockState(pos).let { it.block.canBeReplacedByLeaves(it, this, pos) }

fun IBlockAccess.isWood(pos: BlockPos) =
    getBlockState(pos).block.isWood(this, pos)

fun IBlockAccess.isLeaves(pos: BlockPos) =
    getBlockState(pos).let { it.block.isLeaves(it, this, pos) }

@JvmOverloads
fun World.getExplosionResistance(pos: BlockPos, explosion: Explosion, exploder: Entity? = null) =
    getBlockState(pos).block.getExplosionResistance(this, pos, exploder, explosion)

@JvmOverloads
fun IBlockAccess.canConnectRedstone(pos: BlockPos, side: EnumFacing? = null) =
    getBlockState(pos).let { it.block.canConnectRedstone(it, this, pos, side) }

fun World.getPickBlock(pos: BlockPos, target: RayTraceResult, player: EntityPlayer): ItemStack =
    getBlockState(pos).let { it.block.getPickBlock(it, target, this, pos, player) }

fun IBlockAccess.canSustainPlant(pos: BlockPos, side: EnumFacing, plantable: IPlantable) =
    getBlockState(pos).let { it.block.canSustainPlant(it, this, pos, side, plantable) }
