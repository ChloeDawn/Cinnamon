package net.cinnamon.support.waila.context

import mcp.mobius.waila.api.IWailaEntityAccessor

class EntityContext(private val accessor: IWailaEntityAccessor) {
    val entity get() = accessor.entity
    val rayTrace get() = accessor.mop
    val compound get() = accessor.nbtData
    val partialTicks get() = accessor.partialFrame
    val player get() = accessor.player
    val world get() = accessor.world
}
