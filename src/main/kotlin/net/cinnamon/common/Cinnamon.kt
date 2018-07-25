package net.cinnamon.common

import net.minecraft.launchwrapper.Launch
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(
    modid = Cinnamon.ID,
    name = Cinnamon.NAME,
    version = Cinnamon.VERSION,
    acceptedMinecraftVersions = "[1.12,1.13)",
    modLanguageAdapter = "CinnamonKotlinAdapter"
)
object Cinnamon : Logger by LogManager.getLogger("cinnamon") {
    const val ID = "cinnamon"
    const val NAME = "Cinnamon"
    const val VERSION = "@cinnamon.version@"

    val isDeobfuscated by lazy {
        Launch.blackboard["fml.deobfuscatedEnvironment"] as Boolean
    }
}
