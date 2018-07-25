package net.cinnamon.common.base

import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.ModContainer

object ModContainers {
    @JvmStatic
    val activeContainer: ModContainer?
        get() = Loader.instance().activeModContainer()

    @JvmStatic
    val minecraftContainer: ModContainer
        get() = Loader.instance().minecraftModContainer

    /**
     * The modId of the active [ModContainer] instance
     * @return "null" if the active container is `null`
     * @author InsomniaKitten
     * @since 1.0.0
     */
    @JvmStatic
    val activeModId: String
        get() = activeContainer?.modId.toString()

    @JvmStatic
    @JvmName("fromModId")
    operator fun get(modId: String): ModContainer? {
        return Loader.instance().indexedModList[modId]
    }

    @JvmStatic
    @JvmName("isPresent")
    operator fun contains(modId: String): Boolean {
        return modId in Loader.instance().indexedModList.keys
    }

    @JvmStatic
    @JvmName("isPresent")
    operator fun contains(container: ModContainer): Boolean {
        return container in Loader.instance().activeModList
    }

    @JvmStatic
    operator fun iterator(): MutableIterator<ModContainer> {
        return Loader.instance().activeModList.iterator()
    }
}
