package net.cinnamon.support.waila.context

import mcp.mobius.waila.api.IWailaEntityAccessor
import net.cinnamon.support.waila.TooltipPosition
import net.minecraft.entity.Entity

class EntityTooltipContext(
    val entity: Entity,
    var tooltip: MutableList<String>,
    val position: TooltipPosition,
    private val accessor: IWailaEntityAccessor
) {
    val rayTrace get() = accessor.mop
    val compound get() = accessor.nbtData
    val partialTicks get() = accessor.partialFrame
    val player get() = accessor.player
    val world get() = accessor.world
}
