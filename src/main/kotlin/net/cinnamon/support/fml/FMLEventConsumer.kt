package net.cinnamon.support.fml

import net.minecraftforge.fml.common.event.*

interface FMLEventConsumer {
    fun onConstruction(event: FMLConstructionEvent) {}

    fun onFingerprintViolation(event: FMLFingerprintViolationEvent) {}

    fun onModDisabled(event: FMLModDisabledEvent) {}

    fun onModIdMapping(event: FMLModIdMappingEvent) {}

    fun onPreInitialization(event: FMLPreInitializationEvent) {}

    fun onInitialization(event: FMLInitializationEvent) {}

    fun onIMCReceived(event: FMLInterModComms.IMCEvent) {}

    fun onPostInitialization(event: FMLPostInitializationEvent) {}

    fun onLoadComplete(event: FMLLoadCompleteEvent) {}

    fun onServerAboutToStart(event: FMLServerAboutToStartEvent) {}

    fun onServerStarting(event: FMLServerStartingEvent) {}

    fun onServerStarted(event: FMLServerStartedEvent) {}

    fun onServerStopping(event: FMLServerStoppingEvent) {}

    fun onServerStopped(event: FMLServerStoppedEvent) {}
}
