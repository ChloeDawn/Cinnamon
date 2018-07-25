package net.cinnamon.client

import net.cinnamon.common.item.isNotEmpty
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.color.IBlockColor
import net.minecraft.client.renderer.color.IItemColor
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess

abstract class ColorProvider : IBlockColor, IItemColor {
    override fun colorMultiplier(state: IBlockState, world: IBlockAccess?, pos: BlockPos?, tintIndex: Int) =
        if (world != null && pos != null) {
            getColor(state, world, pos, tintIndex)
        } else getColor(tintIndex)

    override fun colorMultiplier(stack: ItemStack, tintIndex: Int) =
        if (stack.isNotEmpty) {
            getColor(stack, tintIndex)
        } else getColor(tintIndex)

    abstract fun getColor(state: IBlockState, world: IBlockAccess, pos: BlockPos, tintIndex: Int): Int

    abstract fun getColor(stack: ItemStack, tintIndex: Int): Int

    abstract fun getColor(tintIndex: Int): Int
}
