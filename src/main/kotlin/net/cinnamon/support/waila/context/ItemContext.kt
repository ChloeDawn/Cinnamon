package net.cinnamon.support.waila.context

import mcp.mobius.waila.api.IWailaDataAccessor

class ItemContext(private val accessor: IWailaDataAccessor) {
    val stack get() = accessor.stack
    val side get() = accessor.side
    val tile get() = accessor.tileEntity
    val metadata get() = accessor.metadata
    val block get() = accessor.block
    val state get() = accessor.blockState
    val rayTrace get() = accessor.mop
    val compound get() = accessor.nbtData
    val partialTicks get() = accessor.partialFrame
    val player get() = accessor.player
    val world get() = accessor.world
}
