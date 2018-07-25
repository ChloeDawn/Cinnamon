package net.cinnamon.support.waila

import mcp.mobius.waila.api.IWailaDataProvider
import mcp.mobius.waila.api.IWailaEntityProvider
import java.util.function.Consumer
import java.util.function.Function

interface ContextConsumer<V> : Consumer<V>, IWailaDataProvider, IWailaEntityProvider

interface ContextFunction<K, V> : Function<K, V>, IWailaDataProvider, IWailaEntityProvider

enum class TooltipPosition {
    HEAD, BODY, TAIL;

    val isHead get() = this == HEAD
    val isBody get() = this == BODY
    val isTail get() = this == TAIL
}
