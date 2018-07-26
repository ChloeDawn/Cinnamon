package net.cinnamon.common

import net.minecraft.launchwrapper.Launch
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(modid = Cinnamon.ID, modLanguageAdapter = "CinnamonKotlinAdapter", useMetadata = true)
object Cinnamon : Logger by LogManager.getLogger("cinnamon") {
    const val ID = "cinnamon"

    val isDeobfuscated by lazy {
        Launch.blackboard["fml.deobfuscatedEnvironment"] as Boolean
    }
}
